package cn.net.luoma.aicarsystemserver.controller;

import cn.net.luoma.aicarsystemserver.entity.EventInfo;
import cn.net.luoma.aicarsystemserver.entity.EventPic;
import cn.net.luoma.aicarsystemserver.response.BaseResponse;
import cn.net.luoma.aicarsystemserver.service.EventInfoService;
import cn.net.luoma.aicarsystemserver.service.EventPicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.map.LinkedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * (EventInfo)表控制层
 *
 * @author makejava
 * @since 2020-07-01 11:19:48
 */
@RestController
@RequestMapping("eventInfo")
@Api(value = "监控事件相关操作接口", tags = "监控事件相关操作接口", description = "事件")
public class EventInfoController {
    /**
     * 服务对象
     */
    @Resource
    private EventInfoService eventInfoService;
    @Resource
    private EventPicService eventPicService;
    @Autowired
    private RestTemplate restTemplate;

    private static final String baseUrl = "http://luoma.net.cn:12580/api/1/upload";
    private static final String key = "ef61b1c887c1c281d9df303fff8031b3";

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public BaseResponse selectOne(int id){
        EventInfo eventInfo = this.eventInfoService.queryById(id);

        if (eventInfo == null)
            return BaseResponse.fail("id不存在");
        else
            return BaseResponse.okMap("信息如下",eventInfo);
    }

    @ApiOperation(value = "返回事件总数")
    @GetMapping("/countAll")
    public BaseResponse countAll(){
        return BaseResponse.okMap("事件总数",this.eventInfoService.countAll());
    }

//    @GetMapping("/countByType")
//    public BaseResponse countByType(){
//        List<VolunteerCountVO> voList = this.eventInfoService.countByType();
//        List list = new ArrayList() ;
//        //使用 For-Each 遍历 List
//        for (StockAll stock : stockAll) {
//            Map<String, String> map = new LinkedMap<String, String>();
//            map.put("time", stock.getStateDt());
//            map.put("open", stock.getOpen());
//            map.put("close", stock.getClose());
//            map.put("high", stock.getHigh());
//            map.put("low",stock.getLow() );
//            map.put("amount", stock.getAmount());
//            list.add(map);
//        }

//        return BaseResponse.okMap("stockrecentdetail", list);
//    }


    @ApiOperation(value = "监控事件记录-插入记录")
    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "form", name = "id", value = "事件id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "event_type", value = "事件类型", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "event_date", value = "事件日期", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "form", name = "event_location", value = "地点", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "form", name = "event_desc", value = "描述", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "form", name = "oldperson_id", value = "老人id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "base64", value = "头像base64编码字符串", dataType = "String", required = true),
    })
    @PostMapping("/newEvent")
    public BaseResponse newEvent(
            HttpServletRequest request,
            HttpServletResponse response,
//            @RequestParam(value = "id", defaultValue = "") String id,
            @RequestParam(value = "event_type", defaultValue = "") int event_type,
            @RequestParam(value = "event_date", defaultValue = "") String event_date,
            @RequestParam(value = "event_location", defaultValue = "") String event_location,
            @RequestParam(value = "event_desc", defaultValue = "") String event_desc,
            @RequestParam(value = "oldperson_id", defaultValue = "") int oldperson_id,
            @RequestParam(value = "base64", required = true, defaultValue = "") String base64
    ){
        EventInfo eventInfo=new EventInfo();
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date event = null;

        try {
            event = fmt.parse(event_date);
        } catch (ParseException e) {
            return BaseResponse.fail("时间格式错误: " + e.getMessage());
        }

//        eventInfo.setId(Integer.valueOf(id));
        eventInfo.setEventType(event_type);
        eventInfo.setEventDate(event);
        eventInfo.setEventLocation(event_location);
        eventInfo.setEventDesc(event_desc);
        eventInfo.setOldpersonId(oldperson_id);

        EventInfo result1 = eventInfoService.insert(eventInfo);

        if (result1==null) {
            return BaseResponse.fail("添加失败");
        }

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("key", key);
        map.add("source", base64);
        map.add("format", "txt");

        String res = restTemplate.postForObject(baseUrl,map,String.class);

        if(res.startsWith("http")) {
            EventPic eventPic = new EventPic();
            eventPic.setEventId(result1.getId());
            eventPic.setUrl(res);

            EventPic result2 = eventPicService.insert(eventPic);

            if (result2 != null) {
                return BaseResponse.ok(result2,"插入成功");
            }
        }

        return BaseResponse.fail(res);
    }

    @ApiOperation(value = "返回24h内各种类型事件的统计情况")
    @GetMapping("/countByType")
    public BaseResponse countByType() {
//0代表情感检测，1代表义工交互检测，2代表陌生人检测，3代表摔倒检测，4代表禁止区域入侵检测
        Map<String, Integer> map = new LinkedMap<String, Integer>();
        map.put("情感检测", this.eventInfoService.count0());
        map.put("义工交互检测", this.eventInfoService.count1());
        map.put("陌生人检测", this.eventInfoService.count2());
        map.put("摔倒检测", this.eventInfoService.count3());
        map.put("禁止区域入侵检测", this.eventInfoService.count4());

        return BaseResponse.okMap("eventByType", map);
    }

    @ApiOperation(value = "返回24h内情感检测事件数量")
    @GetMapping("/count0ByTime")
    public BaseResponse count0ByTime() {
//0代表情感检测，1代表义工交互检测，2代表陌生人检测，3代表摔倒检测，4代表禁止区域入侵检测
        Map<String, Integer> map = new LinkedMap<String, Integer>();

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String today = formatter.format(date);
        map.put("one", this.eventInfoService.countByTime(0,today+" 00:00:00",today+" 01:59:59"));
        map.put("two", this.eventInfoService.countByTime(0,today+" 02:00:00",today+" 03:59:59"));
        map.put("three", this.eventInfoService.countByTime(0,today+" 04:00:00",today+" 05:59:59"));
        map.put("four", this.eventInfoService.countByTime(0,today+" 06:00:00",today+" 07:59:59"));
        map.put("five", this.eventInfoService.countByTime(0,today+" 08:00:00",today+" 09:59:59"));
        map.put("six", this.eventInfoService.countByTime(0,today+" 10:00:00",today+" 11:59:59"));
        map.put("seven", this.eventInfoService.countByTime(0,today+" 12:00:00",today+" 13:59:59"));
        map.put("eight", this.eventInfoService.countByTime(0,today+" 14:00:00",today+" 15:59:59"));
        map.put("nine", this.eventInfoService.countByTime(0,today+" 16:00:00",today+" 17:59:59"));
        map.put("ten", this.eventInfoService.countByTime(0,today+" 18:00:00",today+" 19:59:59"));
        map.put("eleven", this.eventInfoService.countByTime(0,today+" 20:00:00",today+" 21:59:59"));
        map.put("twelve", this.eventInfoService.countByTime(0,today+" 22:00:00",today+" 23:59:59"));


        return BaseResponse.okMap("event0ByTime", map);
    }

    @ApiOperation(value = "返回24h内交互检测事件数量")
    @GetMapping("/count1ByTime")
    public BaseResponse count1ByTime() {
//0代表情感检测，1代表义工交互检测，2代表陌生人检测，3代表摔倒检测，4代表禁止区域入侵检测
        Map<String, Integer> map = new LinkedMap<String, Integer>();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String today = formatter.format(date);
        map.put("one", this.eventInfoService.countByTime(1,today+" 00:00:00",today+" 01:59:59"));
        map.put("two", this.eventInfoService.countByTime(1,today+" 02:00:00",today+" 03:59:59"));
        map.put("three", this.eventInfoService.countByTime(1,today+" 04:00:00",today+" 05:59:59"));
        map.put("four", this.eventInfoService.countByTime(1,today+" 06:00:00",today+" 07:59:59"));
        map.put("five", this.eventInfoService.countByTime(1,today+" 08:00:00",today+" 09:59:59"));
        map.put("six", this.eventInfoService.countByTime(1,today+" 10:00:00",today+" 11:59:59"));
        map.put("seven", this.eventInfoService.countByTime(1,today+" 12:00:00",today+" 13:59:59"));
        map.put("eight", this.eventInfoService.countByTime(1,today+" 14:00:00",today+" 15:59:59"));
        map.put("nine", this.eventInfoService.countByTime(1,today+" 16:00:00",today+" 17:59:59"));
        map.put("ten", this.eventInfoService.countByTime(1,today+" 18:00:00",today+" 19:59:59"));
        map.put("eleven", this.eventInfoService.countByTime(1,today+" 20:00:00",today+" 21:59:59"));
        map.put("twelve", this.eventInfoService.countByTime(1,today+" 22:00:00",today+" 23:59:59"));

        return BaseResponse.okMap("event1ByTime", map);
    }

    @ApiOperation(value = "返回24h内陌生人检测事件数量")
    @GetMapping("/count2ByTime")
    public BaseResponse count2ByTime() {
//0代表情感检测，1代表义工交互检测，2代表陌生人检测，3代表摔倒检测，4代表禁止区域入侵检测
        Map<String, Integer> map = new LinkedMap<String, Integer>();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String today = formatter.format(date);
        map.put("one", this.eventInfoService.countByTime(2,today+" 00:00:00",today+" 01:59:59"));
        map.put("two", this.eventInfoService.countByTime(2,today+" 02:00:00",today+" 03:59:59"));
        map.put("three", this.eventInfoService.countByTime(2,today+" 04:00:00",today+" 05:59:59"));
        map.put("four", this.eventInfoService.countByTime(2,today+" 06:00:00",today+" 07:59:59"));
        map.put("five", this.eventInfoService.countByTime(2,today+" 08:00:00",today+" 09:59:59"));
        map.put("six", this.eventInfoService.countByTime(2,today+" 10:00:00",today+" 11:59:59"));
        map.put("seven", this.eventInfoService.countByTime(2,today+" 12:00:00",today+" 13:59:59"));
        map.put("eight", this.eventInfoService.countByTime(2,today+" 14:00:00",today+" 15:59:59"));
        map.put("nine", this.eventInfoService.countByTime(2,today+" 16:00:00",today+" 17:59:59"));
        map.put("ten", this.eventInfoService.countByTime(2,today+" 18:00:00",today+" 19:59:59"));
        map.put("eleven", this.eventInfoService.countByTime(2,today+" 20:00:00",today+" 21:59:59"));
        map.put("twelve", this.eventInfoService.countByTime(2,today+" 22:00:00",today+" 23:59:59"));


        return BaseResponse.okMap("event2ByTime", map);
    }

    @ApiOperation(value = "返回24h内摔倒事件数量")
    @GetMapping("/count3ByTime")
    public BaseResponse count3ByTime() {
//0代表情感检测，1代表义工交互检测，2代表陌生人检测，3代表摔倒检测，4代表禁止区域入侵检测
        Map<String, Integer> map = new LinkedMap<String, Integer>();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String today = formatter.format(date);
//        map.put(formatter.format(date)+" 01:59:59", this.eventInfoService.countByTime(3,date+" 00:00:00",date+" 01:59:59"));
        map.put("one", this.eventInfoService.countByTime(3,today+" 00:00:00",today+" 01:59:59"));
        map.put("two", this.eventInfoService.countByTime(3,today+" 02:00:00",today+" 03:59:59"));
        map.put("three", this.eventInfoService.countByTime(3,today+" 04:00:00",today+" 05:59:59"));
        map.put("four", this.eventInfoService.countByTime(3,today+" 06:00:00",today+" 07:59:59"));
        map.put("five", this.eventInfoService.countByTime(3,today+" 08:00:00",today+" 09:59:59"));
        map.put("six", this.eventInfoService.countByTime(3,today+" 10:00:00",today+" 11:59:59"));
        map.put("seven", this.eventInfoService.countByTime(3,today+" 12:00:00",today+" 13:59:59"));
        map.put("eight", this.eventInfoService.countByTime(3,today+" 14:00:00",today+" 15:59:59"));
        map.put("nine", this.eventInfoService.countByTime(3,today+" 16:00:00",today+" 17:59:59"));
        map.put("ten", this.eventInfoService.countByTime(3,today+" 18:00:00",today+" 19:59:59"));
        map.put("eleven", this.eventInfoService.countByTime(3,today+" 20:00:00",today+" 21:59:59"));
        map.put("twelve", this.eventInfoService.countByTime(3,today+" 22:00:00",today+" 23:59:59"));

        return BaseResponse.okMap("event3ByTime", map);
    }

    @ApiOperation(value = "返回24h内禁止区域入侵事件数量")
    @GetMapping("/count4ByTime")
    public BaseResponse count4ByTime() {
//0代表情感检测，1代表义工交互检测，2代表陌生人检测，3代表摔倒检测，4代表禁止区域入侵检测
        Map<String, Integer> map = new LinkedMap<String, Integer>();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String today = formatter.format(date);
        map.put("one", this.eventInfoService.countByTime(4,today+" 00:00:00",today+" 01:59:59"));
        map.put("two", this.eventInfoService.countByTime(4,today+" 02:00:00",today+" 03:59:59"));
        map.put("three", this.eventInfoService.countByTime(4,today+" 04:00:00",today+" 05:59:59"));
        map.put("four", this.eventInfoService.countByTime(4,today+" 06:00:00",today+" 07:59:59"));
        map.put("five", this.eventInfoService.countByTime(4,today+" 08:00:00",today+" 09:59:59"));
        map.put("six", this.eventInfoService.countByTime(4,today+" 10:00:00",today+" 11:59:59"));
        map.put("seven", this.eventInfoService.countByTime(4,today+" 12:00:00",today+" 13:59:59"));
        map.put("eight", this.eventInfoService.countByTime(4,today+" 14:00:00",today+" 15:59:59"));
        map.put("nine", this.eventInfoService.countByTime(4,today+" 16:00:00",today+" 17:59:59"));
        map.put("ten", this.eventInfoService.countByTime(4,today+" 18:00:00",today+" 19:59:59"));
        map.put("eleven", this.eventInfoService.countByTime(4,today+" 20:00:00",today+" 21:59:59"));
        map.put("twelve", this.eventInfoService.countByTime(4,today+" 22:00:00",today+" 23:59:59"));


        return BaseResponse.okMap("event4ByTime", map);
    }

    @ApiOperation(value = "返回（摔倒）事件发生地点的统计情况")
    @GetMapping("/countByLocation")
    public BaseResponse countByLocation() {
//0代表情感检测，1代表义工交互检测，2代表陌生人检测，3代表摔倒检测，4代表禁止区域入侵检测
        Map<String, Integer> map = new LinkedMap<String, Integer>();
        map.put("房间", this.eventInfoService.countByLocation(3,"房间"));
        map.put("院子", this.eventInfoService.countByLocation(3,"院子"));
        map.put("走廊", this.eventInfoService.countByLocation(3,"走廊"));

        return BaseResponse.okMap("eventByLocation", map);
    }

    /**
     * 查询指定数量的事件信息
     *
     *
     * @param  limit 查询条数
     * @return RESTful api
     */

    @ApiOperation(value = "查询指定数量的事件信息查询接口", notes = "查询指定数量的事件信息")

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "offset", value = "起始位置", dataType = "int", required = false),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "查询条数", dataType = "int", required = true)
    })
    @GetMapping("/querybylimit")
    public BaseResponse querybylimit(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "offset", required = false, defaultValue = "0")int offset,
            @RequestParam(value = "limit",defaultValue = "9") int limit) {

        List<EventInfo> eventInfos = this.eventInfoService.queryAllByLimit(offset,limit);
        return BaseResponse.ok(eventInfos);
    }

}