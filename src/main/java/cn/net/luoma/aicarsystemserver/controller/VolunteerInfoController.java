package cn.net.luoma.aicarsystemserver.controller;

import cn.net.luoma.aicarsystemserver.entity.VolunteerInfo;
import cn.net.luoma.aicarsystemserver.response.BaseResponse;
import cn.net.luoma.aicarsystemserver.service.VolunteerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.map.LinkedMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (VolunteerInfo)表控制层
 *
 * @author makejava
 * @since 2020-07-01 11:20:09
 */
@RestController
@RequestMapping("volunteerInfo")
@Api(value = "义工相关操作接口", tags = "义工相关操作接口", description = "义工")
public class VolunteerInfoController {
    /**
     * 服务对象
     */
    @Resource
    private VolunteerInfoService volunteerInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */

    @ApiOperation(value = "义工信息接口", notes = "通过id查询义工信息")

    @ApiImplicitParam(paramType = "query", name = "id", value = "用户名", dataType = "Integer", required = true)

    @GetMapping("/selectOne")
    public BaseResponse selectOne(int id) {
        VolunteerInfo volunteerInfo = this.volunteerInfoService.queryById(id);

        if (volunteerInfo == null)
            return BaseResponse.fail("id不存在");
        else
            return BaseResponse.okMap("信息如下", volunteerInfo);
    }

    @ApiOperation(value = "删除指定的义工信息", notes = "删除指定的义工信息")


    @ApiImplicitParam(paramType = "query", name = "id", value = "义工ID", dataType = "Integer", required = true)

    @GetMapping("/delete")
    public BaseResponse delete(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "id", defaultValue = "") Integer id) {
        if (this.volunteerInfoService.queryById(id) != null) {
            this.volunteerInfoService.deleteById(id);
            return BaseResponse.ok(null, "删除成功");
        }
        return BaseResponse.fail("删除失败，未找到义工信息。");

    }

    /**
     * 根据身份证精确查询
     *
     * @param id_card 身份证
     * @return RESTful api
     */

    @ApiOperation(value = "根据身份证精确查询义工信息查询接口", notes = "根据身份证精确查询义工信息查询")


    @ApiImplicitParam(paramType = "form", name = "id_card", value = "义工身份证号码", dataType = "String", required = false)

    @PostMapping("/querybycard")
    public BaseResponse querybycard(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "id_card", defaultValue = "", required = true) String id_card) {

        if (!id_card.equals("")) {
            VolunteerInfo volunteerInfo = this.volunteerInfoService.queryByIdCard(id_card);
            if (volunteerInfo.getId() != 0) {
                return BaseResponse.ok(volunteerInfo);
            } else {
                return BaseResponse.fail("未查到相关信息");
            }
        }

        return BaseResponse.fail("请正确输入义工身份证信息");
    }

    /**
     * 查询指定数量的义工信息
     *
     * @param limit 查询条数
     * @return RESTful api
     */

    @ApiOperation(value = "查询指定数量的义工信息查询接口", notes = "查询指定数量的义工信息")

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

        List<VolunteerInfo> volunteers = this.volunteerInfoService.queryAllByLimit(offset, limit);
        return BaseResponse.ok(volunteers);
    }


    @ApiOperation(value = "添加义工")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "name", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "gender", value = "性别", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "phone", value = "电话", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "id_card", value = "身份证号", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "birthday", value = "生日", required = false, dataType = "string"),
            @ApiImplicitParam(paramType = "form", name = "checkin_date", value = "入职日期", required = false, dataType = "string"),
            @ApiImplicitParam(paramType = "form", name = "checkout_date", value = "离职日期", required = false, dataType = "string"),
            @ApiImplicitParam(paramType = "form", name = "description", value = "描述", required = false, dataType = "String"),
    })
    @PostMapping("/newVolunteer")
    public BaseResponse newVolunteer(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "name", defaultValue = "", required = true) String name,
            @RequestParam(value = "gender", defaultValue = "", required = false) String gender,
            @RequestParam(value = "phone", defaultValue = "", required = false) String phone,
            @RequestParam(value = "id_card", defaultValue = "", required = false) String id_card,
            @RequestParam(value = "birthday", defaultValue = "", required = false) String birthday,
            @RequestParam(value = "checkin_date", defaultValue = "", required = false) String checkin_date,
            @RequestParam(value = "checkout_date", defaultValue = "", required = false) String checkout_date,
            @RequestParam(value = "description", defaultValue = "", required = false) String description
    ) {
        if ("".equals(name)) {
            return BaseResponse.fail("参数不全！");
        }

        VolunteerInfo volunteerInfo = volunteerInfoService.queryByIdCard(id_card);
        if (volunteerInfo == null) {
            volunteerInfo = new VolunteerInfo();
        } else {
            return BaseResponse.fail("义工已存在");
        }

        volunteerInfo.setName(name);
        if (!"".equals(gender))
            volunteerInfo.setGender(gender);
        if (!"".equals(phone))
            volunteerInfo.setPhone(phone);
        if (!"".equals(id_card))
            volunteerInfo.setIdCard(id_card);

        if (checkDate(birthday) != null)
            volunteerInfo.setBirthday(checkDate(birthday));
        if (checkDate(checkin_date) != null)
            volunteerInfo.setCheckinDate(checkDate(checkin_date));
        if (checkDate(checkout_date) != null)
            volunteerInfo.setCheckoutDate(checkDate(checkout_date));

        volunteerInfo.setImgsetDir("volunteerPhoto/" + id_card);
        volunteerInfo.setProfilePhoto(volunteerInfo.getImgsetDir() + "/" + name);

        if (!"".equals(description))
            volunteerInfo.setDescription(description);

        if (volunteerInfoService.insert(volunteerInfo) == null) {
            return BaseResponse.fail("添加失败");
        }

        return BaseResponse.ok();
    }

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

    @ApiOperation(value = "修改义工")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "name", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "gender", value = "性别", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "phone", value = "电话", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "id_card", value = "身份证号", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "birthday", value = "生日", required = false, dataType = "string"),
            @ApiImplicitParam(paramType = "form", name = "checkin_date", value = "入职日期", required = false, dataType = "string"),
            @ApiImplicitParam(paramType = "form", name = "checkout_date", value = "离职日期", required = false, dataType = "string"),
            @ApiImplicitParam(paramType = "form", name = "imgset_dir", value = "采集图像目录", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "profile_photo", value = "人脸图片路径", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "description", value = "描述", required = false, dataType = "String"),
    })
    @PostMapping("/changeVolunteer")
    public BaseResponse changeVolunteer(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "id", defaultValue = "", required = true) int vid,
            @RequestParam(value = "name", defaultValue = "", required = true) String name,
            @RequestParam(value = "gender", defaultValue = "", required = false) String gender,
            @RequestParam(value = "phone", defaultValue = "", required = false) String phone,
            @RequestParam(value = "id_card", defaultValue = "", required = false) String id_card,
            @RequestParam(value = "birthday", defaultValue = "", required = false) String birthday,
            @RequestParam(value = "checkin_date", defaultValue = "", required = false) String checkin_date,
            @RequestParam(value = "checkout_date", defaultValue = "", required = false) String checkout_date,
            @RequestParam(value = "imgset_dir", defaultValue = "", required = false) String imgset_dir,
            @RequestParam(value = "profile_photo", defaultValue = "", required = false) String profile_photo,
            @RequestParam(value = "description", defaultValue = "", required = false) String description
    ) {
        if ("".equals(vid) || "".equals(name)) {
            return BaseResponse.fail("参数不全！");
        }
        System.out.println(vid);
        VolunteerInfo volunteerInfo = volunteerInfoService.queryById(vid);
        if (volunteerInfo == null) {
            return BaseResponse.fail("义工不存在！！请先创建!");
        }


        if (!name.isEmpty()) {
            volunteerInfo.setName(name);
        }
        if (!gender.isEmpty()) {
            volunteerInfo.setGender(gender);
        }
        if (!phone.isEmpty()) {
            volunteerInfo.setPhone(phone);
        }
        if (!id_card.isEmpty()) {
            volunteerInfo.setIdCard(id_card);
        }

        if (checkDate(birthday) != null)
            volunteerInfo.setBirthday(checkDate(birthday));
        if (checkDate(checkin_date) != null)
            volunteerInfo.setCheckinDate(checkDate(checkin_date));
        if (checkDate(checkout_date) != null)
            volunteerInfo.setCheckoutDate(checkDate(checkout_date));
        if (!imgset_dir.isEmpty()) {
            volunteerInfo.setImgsetDir(imgset_dir);
        }
        if (!profile_photo.isEmpty()) {
            volunteerInfo.setProfilePhoto(profile_photo);
        }
        if (!description.isEmpty()) {
            volunteerInfo.setDescription(description);
        }

        if (volunteerInfoService.update(volunteerInfo) == null) {
            return BaseResponse.fail("修改失败");
        } else {
            volunteerInfoService.update(volunteerInfo);
        }

        return BaseResponse.ok();
    }

    @ApiOperation(value = "返回义工总人数")
    @GetMapping("/countAll")
    public BaseResponse countAll() {
        return BaseResponse.okMap("义工总人数", this.volunteerInfoService.countAll());
    }


    @ApiOperation(value = "返回义工性别的统计情况")
    @GetMapping("/countByGender")
    public BaseResponse countByGender() {

        Map<String, Integer> map = new LinkedMap<String, Integer>();
        map.put("Male", this.volunteerInfoService.countAllMale());
        map.put("Female", this.volunteerInfoService.countAllFemale());
        return BaseResponse.okMap("volunteerByGender", map);
    }

    @ApiOperation(value = "返回当前在职的义工数量")
    @GetMapping("/countAllActive")
    public BaseResponse countAllActive() {
        return BaseResponse.okMap("在职义工数目", this.volunteerInfoService.countAllActive());
    }

    @ApiOperation(value = "返回义工的年龄情况")
    @GetMapping("/countByAge")
    public BaseResponse countByAge() {

        Map<String, Integer> map = new LinkedMap<String, Integer>();
        map.put("one", this.volunteerInfoService.countLess18());
        map.put("two", this.volunteerInfoService.count19to25());
        map.put("three", this.volunteerInfoService.count26to35());
        map.put("four", this.volunteerInfoService.count36to45());
        map.put("five", this.volunteerInfoService.count46to55());
        map.put("six", this.volunteerInfoService.countOver55());

        return BaseResponse.okMap("volunteerByAge", map);
    }
}