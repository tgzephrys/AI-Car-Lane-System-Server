package cn.net.luoma.aicarsystemserver.controller;

import cn.net.luoma.aicarsystemserver.entity.OldpersonInfo;
import cn.net.luoma.aicarsystemserver.response.BaseResponse;
import cn.net.luoma.aicarsystemserver.service.OldpersonInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (OldpersonInfo)表控制层
 *
 * @author makejava
 * @since 2020-07-01 12:26:58
 */
@RestController
@RequestMapping("oldpersonInfo")
@Api(value = "老人信息相关操作接口", tags = "老人信息相关操作接口", description = "老人信息")
public class OldpersonInfoController {
    /**
     * 服务对象
     */
    @Resource
    private OldpersonInfoService oldpersonInfoService;

    public Date checkDate(String origin) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        Date result = null;

        try {
            result = fmt.parse(origin);
        } catch (ParseException e) {
            return null;
        }

        return result;
    }
/*   参数列表，随时取用。
    @RequestParam(value = "id", required = false) Integer id,
    @RequestParam(value = "username", defaultValue = "", required = false) String username,
    @RequestParam(value = "gender", defaultValue = "", required = false) String gender,
    @RequestParam(value = "phone",  defaultValue = "", required = false) String phone,
    @RequestParam(value = "id_card", defaultValue = "", required = false) String id_card,
    @RequestParam(value = "birthday", defaultValue = "", required = false) Date birthday,
    @RequestParam(value = "checkin_date", required = false) Date checkin_date,
    @RequestParam(value = "checkout_date", required = false) Date checkout_date,
    @RequestParam(value = "imgset_dir", defaultValue = "", required = false) String imgset_dir,
    @RequestParam(value = "profile_photo", defaultValue = "", required = false) String profile_photo,
    @RequestParam(value = "room_number", defaultValue = "", required = false) String room_number,
    @RequestParam(value = "firstguardian_name", defaultValue = "", required = false) String firstguardian_name,
    @RequestParam(value = "firstguardian_relationship", defaultValue = "", required = false) String firstguardian_relationship,
    @RequestParam(value = "firstguardian_phone", defaultValue = "", required = false) String firstguardian_phone,
    @RequestParam(value = "firstguardian_wechat", defaultValue = "", required = false) String firstguardian_wechat,
    @RequestParam(value = "secondguardian_name", defaultValue = "", required = false) String secondguardian_name,
    @RequestParam(value = "secondguardian_relationship", defaultValue = "", required = false) String secondguardian_relationship,
    @RequestParam(value = "secondguardian_phone", defaultValue = "", required = false) String secondguardian_phone,
    @RequestParam(value = "secondguardian_wechat", defaultValue = "", required = false) String secondguardian_wechat,
    @RequestParam(value = "health_state", defaultValue = "", required = false) String health_state,
    @RequestParam(value = "DESCRIPTION", defaultValue = "", required = false) String DESCRIPTION,
    @RequestParam(value = "ISACTIVE", defaultValue = "", required = false) String ISACTIVE,
    @RequestParam(value = "CREATED", required = false) Date CREATED,
    @RequestParam(value = "CREATEBY", required = false) Integer CREATEBY,
    @RequestParam(value = "UPDATED", required = false) Date UPDATED,
    @RequestParam(value = "UPDATEBY", required = false) Integer UPDATEBY,
    @RequestParam(value = "REMOVE", defaultValue = "", required = false) String REMOVE

*/

    /**
     * 老人信息录入
     *
     * @param //太多了，不写了
     * @return RESTful api
     */

    @ApiOperation(value = "老人信息录入接口", notes = "老人信息录入")

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "username", value = "老人姓名", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "gender", value = "老人性别", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "phone", value = "老人电话", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "id_card", value = "老人身份证号码", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "birthday", value = "老人生日", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "checkin_date", value = "老人入养老院日期", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "checkout_date", value = "老人出养老院日期", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "imgset_dir", value = "老人图像目录", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "profile_photo", value = "老人头像路径", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "room_number", value = "老人房间号", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "firstguardian_name", value = "老人第一监护人姓名", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "firstguardian_relationship", value = "老人与第一监护人关系", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "firstguardian_phone", value = "老人第一监护人电话", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "firstguardian_wechat", value = "老人第一监护人微信", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "secondguardian_name", value = "老人第二监护人姓名", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "secondguardian_relationship", value = "老人与第二监护人关系", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "secondguardian_phone", value = "老人第二监护人电话", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "secondguardian_wechat", value = "老人第二监护人微信", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "health_state", value = "老人健康状况", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "DESCRIPTION", value = "描述", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "ISACTIVE", value = "是否有效", dataType = "String", required = false)
//            @ApiImplicitParam(paramType = "form", name = "CREATED", value = "创建时间", dataType = "Date", required = false),
//            @ApiImplicitParam(paramType = "form", name = "CREATEBY", value = "创建人", dataType = "Integer", required = false),
//            @ApiImplicitParam(paramType = "form", name = "UPDATED", value = "更新时间", dataType = "Date", required = false),
//            @ApiImplicitParam(paramType = "form", name = "UPDATEBY", value = "更新人", dataType = "Integer", required = false),
//            @ApiImplicitParam(paramType = "form", name = "REMOVE", value = "删除标志", dataType = "String", required = false)
    })

    @PostMapping("/add")
    public BaseResponse add(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "username", defaultValue = "", required = false) String username,
            @RequestParam(value = "gender", defaultValue = "", required = false) String gender,
            @RequestParam(value = "phone", defaultValue = "", required = false) String phone,
            @RequestParam(value = "id_card", defaultValue = "", required = false) String id_card,
            @RequestParam(value = "birthday", defaultValue = "", required = false) String birthday,
            @RequestParam(value = "checkin_date", defaultValue = "",required = false) String checkin_date,
            @RequestParam(value = "imgset_dir", defaultValue = "", required = false) String imgset_dir,
            @RequestParam(value = "profile_photo", defaultValue = "", required = false) String profile_photo,
            @RequestParam(value = "room_number", defaultValue = "", required = false) String room_number,
            @RequestParam(value = "firstguardian_name", defaultValue = "", required = false) String firstguardian_name,
            @RequestParam(value = "firstguardian_relationship", defaultValue = "", required = false) String firstguardian_relationship,
            @RequestParam(value = "firstguardian_phone", defaultValue = "", required = false) String firstguardian_phone,
            @RequestParam(value = "firstguardian_wechat", defaultValue = "", required = false) String firstguardian_wechat,
            @RequestParam(value = "secondguardian_name", defaultValue = "", required = false) String secondguardian_name,
            @RequestParam(value = "secondguardian_relationship", defaultValue = "", required = false) String secondguardian_relationship,
            @RequestParam(value = "secondguardian_phone", defaultValue = "", required = false) String secondguardian_phone,
            @RequestParam(value = "secondguardian_wechat", defaultValue = "", required = false) String secondguardian_wechat,
            @RequestParam(value = "health_state", defaultValue = "", required = false) String health_state,
            @RequestParam(value = "DESCRIPTION", defaultValue = "", required = false) String DESCRIPTION
//            @RequestParam(value = "CREATEBY", required = false) Integer CREATEBY
           ) {

        OldpersonInfo oldperson = new OldpersonInfo();
        //赋值
        if (!"".equals(username))
            oldperson.setUsername(username);
        if (!"".equals(gender))
            oldperson.setGender(gender);
        if (!"".equals(phone))
            oldperson.setPhone(phone);
        if (!"".equals(id_card))
            oldperson.setIdCard(id_card);
        if (checkDate(birthday) != null)
            oldperson.setBirthday(checkDate(birthday));
        if (checkDate(checkin_date) != null)
            oldperson.setCheckinDate(checkDate(checkin_date));
        if (!"".equals(imgset_dir))
            oldperson.setImgsetDir(imgset_dir);
        if (!"".equals(profile_photo))
            oldperson.setProfilePhoto(profile_photo);
        if (!"".equals(room_number))
            oldperson.setRoomNumber(room_number);
        if (!"".equals(firstguardian_name))
            oldperson.setFirstguardianName(firstguardian_name);
        if (!"".equals(firstguardian_relationship))
            oldperson.setFirstguardianRelationship(firstguardian_relationship);
        if (!"".equals(firstguardian_phone))
            oldperson.setFirstguardianPhone(firstguardian_phone);
        if (!"".equals(firstguardian_wechat))
            oldperson.setFirstguardianWechat(firstguardian_wechat);
        if (!"".equals(secondguardian_name))
            oldperson.setSecondguardianName(secondguardian_name);
        if (!"".equals(secondguardian_relationship))
            oldperson.setSecondguardianRelationship(secondguardian_relationship);
        if (!"".equals(secondguardian_phone))
            oldperson.setSecondguardianPhone(secondguardian_phone);
        if (!"".equals(secondguardian_wechat))
            oldperson.setSecondguardianWechat(secondguardian_wechat);
        if (!"".equals(health_state))
            oldperson.setHealthState(health_state);
        if (!"".equals(DESCRIPTION))
            oldperson.setDescription(DESCRIPTION);
        oldperson.setIsactive("有效");
        oldperson.setCreated(new Date());

        //插入数据
        OldpersonInfo oldperson1 = this.oldpersonInfoService.insert(oldperson);
        if (oldperson1.getId() != 0) {
            return BaseResponse.ok(null, "老人信息录入成功");
        } else {
            return BaseResponse.fail("老人信息录入失败");
        }
    }

    /**
     * 修改
     *
     * @param //太多了，不写了
     * @return RESTful api
     */

    @ApiOperation(value = "老人信息修改接口", notes = "老人信息修改")

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "id", value = "老人ID", dataType = "int", required = true),
            @ApiImplicitParam(paramType = "form", name = "username", value = "老人姓名", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "gender", value = "老人性别", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "phone", value = "老人电话", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "id_card", value = "老人身份证号码", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "birthday", value = "老人生日", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "checkin_date", value = "老人入养老院日期", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "checkout_date", value = "老人出养老院日期", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "imgset_dir", value = "老人图像目录", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "profile_photo", value = "老人头像路径", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "room_number", value = "老人房间号", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "firstguardian_name", value = "老人第一监护人姓名", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "firstguardian_relationship", value = "老人与第一监护人关系", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "firstguardian_phone", value = "老人第一监护人电话", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "firstguardian_wechat", value = "老人第一监护人微信", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "secondguardian_name", value = "老人第二监护人姓名", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "secondguardian_relationship", value = "老人与第二监护人关系", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "secondguardian_phone", value = "老人第二监护人电话", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "secondguardian_wechat", value = "老人第二监护人微信", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "health_state", value = "老人健康状况", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "DESCRIPTION", value = "描述", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "ISACTIVE", value = "是否有效", dataType = "String", required = false)
//            @ApiImplicitParam(paramType = "form", name = "CREATEBY", value = "创建人", dataType = "Integer", required = false),
//            @ApiImplicitParam(paramType = "form", name = "UPDATEBY", value = "更新人", dataType = "Integer", required = true)
    })

    @PostMapping("/modify")
    public BaseResponse modify(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "username", defaultValue = "", required = false) String username,
            @RequestParam(value = "gender", defaultValue = "", required = false) String gender,
            @RequestParam(value = "phone", defaultValue = "", required = false) String phone,
            @RequestParam(value = "id_card", defaultValue = "", required = false) String id_card,
            @RequestParam(value = "birthday", defaultValue = "", required = false) String birthday,
            @RequestParam(value = "checkin_date", defaultValue = "", required = false) String checkin_date,
            @RequestParam(value = "checkout_date", defaultValue = "",required = false) String checkout_date,
            @RequestParam(value = "imgset_dir", defaultValue = "", required = false) String imgset_dir,
            @RequestParam(value = "profile_photo", defaultValue = "", required = false) String profile_photo,
            @RequestParam(value = "room_number", defaultValue = "", required = false) String room_number,
            @RequestParam(value = "firstguardian_name", defaultValue = "", required = false) String firstguardian_name,
            @RequestParam(value = "firstguardian_relationship", defaultValue = "", required = false) String firstguardian_relationship,
            @RequestParam(value = "firstguardian_phone", defaultValue = "", required = false) String firstguardian_phone,
            @RequestParam(value = "firstguardian_wechat", defaultValue = "", required = false) String firstguardian_wechat,
            @RequestParam(value = "secondguardian_name", defaultValue = "", required = false) String secondguardian_name,
            @RequestParam(value = "secondguardian_relationship", defaultValue = "", required = false) String secondguardian_relationship,
            @RequestParam(value = "secondguardian_phone", defaultValue = "", required = false) String secondguardian_phone,
            @RequestParam(value = "secondguardian_wechat", defaultValue = "", required = false) String secondguardian_wechat,
            @RequestParam(value = "health_state", defaultValue = "", required = false) String health_state,
            @RequestParam(value = "DESCRIPTION", defaultValue = "", required = false) String DESCRIPTION,
            @RequestParam(value = "ISACTIVE", defaultValue = "", required = false) String ISACTIVE
//            @RequestParam(value = "CREATEBY", required = false) Integer CREATEBY,
//            @RequestParam(value = "UPDATEBY", required = true) Integer UPDATEBY
            ) {

        OldpersonInfo oldperson = this.oldpersonInfoService.queryById(id);
        //赋值
        if (!username.equals("")) {
            oldperson.setUsername(username);
        }

        if (!gender.equals("")) {
            oldperson.setGender(gender);
        }
        if (!phone.equals("")) {
            oldperson.setPhone(phone);
        }

        if (!id_card.equals("")) {
            oldperson.setIdCard(id_card);
        }

        if (checkDate(birthday) != null) {
            oldperson.setBirthday(checkDate(birthday));
        }

        if (checkDate(checkin_date) != null) {
            oldperson.setCheckinDate(checkDate(checkin_date));
        }
        if (checkDate(checkout_date) != null) {
            oldperson.setCheckoutDate(checkDate(checkout_date));
        }
        if (!imgset_dir.equals("")) {
            oldperson.setImgsetDir(imgset_dir);
        }
        if (!profile_photo.equals("")) {
            oldperson.setProfilePhoto(profile_photo);
        }
        if (!room_number.equals("")) {
            oldperson.setRoomNumber(room_number);
        }
        if (!firstguardian_name.equals("")) {
            oldperson.setFirstguardianName(firstguardian_name);
        }
        if (!firstguardian_relationship.equals("")) {
            oldperson.setFirstguardianRelationship(firstguardian_relationship);
        }
        if (!firstguardian_phone.equals("")) {
            oldperson.setFirstguardianPhone(firstguardian_phone);
        }
        if (!firstguardian_wechat.equals("")) {
            oldperson.setFirstguardianWechat(firstguardian_wechat);
        }
        if (!secondguardian_name.equals("")) {
            oldperson.setSecondguardianName(secondguardian_name);
        }
        if (!secondguardian_relationship.equals("")) {
            oldperson.setSecondguardianRelationship(secondguardian_relationship);
        }
        if (!secondguardian_phone.equals("")) {
            oldperson.setSecondguardianPhone(secondguardian_phone);
        }
        if (!secondguardian_wechat.equals("")) {
            oldperson.setSecondguardianWechat(secondguardian_wechat);
        }
        if (!health_state.equals("")) {
            oldperson.setHealthState(health_state);
        }
        if (!DESCRIPTION.equals("")) {
            oldperson.setDescription(DESCRIPTION);
        }
        if (!ISACTIVE.equals("")) {
            oldperson.setIsactive(ISACTIVE);
        }


        oldperson.setUpdated(new Date());

        //修改数据
        OldpersonInfo oldperson1 = this.oldpersonInfoService.update(oldperson);
        if (oldperson1.getId() != 0) {
            return BaseResponse.ok(null, "老人信息修改成功");
        } else {
            return BaseResponse.fail("老人信息修改失败");
        }
    }

    /**
     * 根据ID精确查询
     *
     * @param id 主键
     * @return RESTful api
     */

    @ApiOperation(value = "根据ID精确查询老人信息查询接口", notes = "根据ID精确查询老人信息查询")


    @ApiImplicitParam(paramType = "query", name = "id", value = "老人ID", dataType = "Integer", required = true)

    @GetMapping("/querybyid")
    public BaseResponse querybyid(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "id", required = true) Integer id) {

        if (!id.equals(0)) {
            OldpersonInfo oldperson = this.oldpersonInfoService.queryById(id);
            if (oldperson.getId() != 0) {
                return BaseResponse.ok(oldperson);
            } else {
                return BaseResponse.fail("未查到相关信息");
            }
        }

        return BaseResponse.fail("请输入老人id");
    }

    /**
     * 根据身份证精确查询
     *
     * @param id_card 身份证
     * @return RESTful api
     */

    @ApiOperation(value = "根据身份证精确查询老人信息查询接口", notes = "根据身份证精确查询老人信息查询")


    @ApiImplicitParam(paramType = "form", name = "id_card", value = "老人身份证号码", dataType = "String", required = false)

    @PostMapping("/querybycard")
    public BaseResponse querybycard(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "id_card", defaultValue = "", required = true) String id_card) {

        if (!id_card.equals("")) {
            OldpersonInfo oldperson = this.oldpersonInfoService.queryByCard(id_card);
            if (oldperson.getId() != 0) {
                return BaseResponse.ok(oldperson);
            } else {
                return BaseResponse.fail("未查到相关信息");
            }
        }

        return BaseResponse.fail("请输入老人身份证信息");
    }

    /**
     * 查询指定数量的老人信息
     *
     * @param limit 查询条数
     * @return RESTful api
     */

    @ApiOperation(value = "查询指定数量的老人信息查询接口", notes = "查询指定数量的老人信息")

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "offset", value = "起始位置", dataType = "int", required = false),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "查询条数", dataType = "int", required = true)
    })
    @GetMapping("/querybylimit")
    public BaseResponse querybylimit(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "9") int limit) {

        List<OldpersonInfo> oldpersons = this.oldpersonInfoService.queryAllByLimit(offset, limit);
        return BaseResponse.ok(oldpersons);
    }

    /**
     * 删除指定的老人信息
     *
     * @param id 主键
     * @return RESTful api
     */

    @ApiOperation(value = "删除指定的老人信息", notes = "删除指定的老人信息")


    @ApiImplicitParam(paramType = "query", name = "id", value = "老人ID", dataType = "Integer", required = true)

    @GetMapping("/delete")
    public BaseResponse delete(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "id", defaultValue = "5") Integer id) {
        if (this.oldpersonInfoService.queryById(id) != null) {
            this.oldpersonInfoService.deleteById(id);
            return BaseResponse.ok(null, "删除成功");
        }
        return BaseResponse.fail("删除失败，未找到老人信息。");

    }

    /**
     * 老人数量数据
     * 1.老人总数
     * 2.男性女性数量
     * 3.老人各年龄的人数
     * 4.老人数量（按入院日期分，每一个月计算成一个数据）
     * 5.老人数量（按健康状况分）
     *
     * @return RESTful api
     */

    @ApiOperation(value = "老人数量数据", notes = "老人数量数据")

    @GetMapping("/numbers")
    public BaseResponse getNumbers() {
        Map map = new LinkedHashMap();
        Map map1 = new LinkedHashMap();
        Map map2 = new LinkedHashMap();
        Map map3 = new LinkedHashMap();
        Map map4 = new LinkedHashMap();
        //1.老人总数
        map.put("totalnumber", this.oldpersonInfoService.count());

        //2.男性女性数量
        //使用迭代器进行相关遍历

        Iterator it1 = this.oldpersonInfoService.countBySex().iterator();
        while (it1.hasNext())//判断下一个元素之后有值
        {
            Map p = (Map) it1.next();
            map1.put(p.get("gender"), p.get("number"));
        }


        //3.老人各年龄段的人数

        List it2 = this.oldpersonInfoService.countByAge();
        List list1 = new ArrayList();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");
        list1.add("five");
        for (int i = 0; i < 5; i++) {

            Map p = (Map) it2.get(i);
            map2.put(list1.get(i), p.get("number"));
        }

        //4.老人数量（按入院日期分，每一个月计算成一个数据）

        List it3 = this.oldpersonInfoService.countByDate();
        List list2 = new ArrayList();
        list2.add("2020-1");
        list2.add("2020-2");
        list2.add("2020-3");
        list2.add("2020-4");
        list2.add("2020-5");
        list2.add("2020-6");
        list2.add("2020-7");

        for (int i = 0; i < 7; i++) {
            Map p = (Map) it3.get(i);
            map3.put(list2.get(i), p.get("number"));
        }

        //5.老人数量（按健康状况分）
        List it4 = this.oldpersonInfoService.countByState();
        List list3 = new ArrayList();
        list3.add("健康");
        list3.add("良好");
        list3.add("一般");
        list3.add("差");
        list3.add("很差");
        for (int i = 0; i < 5; i++) {
            Map p = (Map) it4.get(i);
            map4.put(list3.get(i), p.get("number"));
        }

        map.put("gender", map1);
        map.put("age", map2);
        map.put("date", map3);
        map.put("health_state", map4);

        return BaseResponse.ok(map);
    }

}

