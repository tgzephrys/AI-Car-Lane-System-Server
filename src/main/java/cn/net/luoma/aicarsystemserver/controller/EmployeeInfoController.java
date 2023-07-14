package cn.net.luoma.aicarsystemserver.controller;

import cn.net.luoma.aicarsystemserver.entity.EmployeeInfo;
import cn.net.luoma.aicarsystemserver.response.BaseResponse;
import cn.net.luoma.aicarsystemserver.service.EmployeeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.map.LinkedMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (EmployeeInfo)表控制层
 *
 * @author makejava
 * @since 2020-07-01 10:40:52
 */
@RestController
@RequestMapping("employeeInfo")

@Api(value = "工作人员信息相关操作接口", tags = "工作人员信息相关操作接口", description = "工作人员信息")
public class EmployeeInfoController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeInfoService employeeInfoService;


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

    /**
     * 工作人员信息录入
     *
     * @param //太多了，不写了
     * @return RESTful api
     */

    @ApiOperation(value = "工作人员信息录入接口", notes = "工作人员信息录入")

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "username", value = "工作人员姓名", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "gender", value = "工作人员性别", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "phone", value = "工作人员电话", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "id_card", value = "工作人员身份证号码", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "birthday", value = "工作人员生日", dataType = "string", required = false),
            @ApiImplicitParam(paramType = "form", name = "hire_date", value = "工作人员入职日期", dataType = "string", required = false),
            @ApiImplicitParam(paramType = "form", name = "resign_date", value = "工作人员离职日期", dataType = "string", required = false),
            @ApiImplicitParam(paramType = "form", name = "imgset_dir", value = "工作人员图像目录", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "profile_photo", value = "工作人员头像路径", dataType = "String", required = false),
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
            @RequestParam(value = "hire_date", defaultValue = "",required = false) String hire_date,
            @RequestParam(value = "imgset_dir", defaultValue = "", required = false) String imgset_dir,
            @RequestParam(value = "profile_photo", defaultValue = "", required = false) String profile_photo,
            @RequestParam(value = "DESCRIPTION", defaultValue = "", required = false) String DESCRIPTION
//            @RequestParam(value = "CREATEBY", required = false) Integer CREATEBY
           ) {

        EmployeeInfo employeeInfo = new EmployeeInfo();
        //赋值
        if (!"".equals(username))
            employeeInfo.setUsername(username);
        if (!"".equals(gender))
            employeeInfo.setGender(gender);
        if (!"".equals(phone))
            employeeInfo.setPhone(phone);
        if (!"".equals(id_card))
            employeeInfo.setIdCard(id_card);
//        if(!"".equals(birthday))
        if (checkDate(birthday) != null)
            employeeInfo.setBirthday(checkDate(birthday));
//        if(!"".equals(username))
        if (checkDate(hire_date) != null)
            employeeInfo.setHireDate(checkDate(hire_date));
        if (!"".equals(imgset_dir))
            employeeInfo.setImgsetDir(imgset_dir);
        if (!"".equals(profile_photo))
            employeeInfo.setProfilePhoto(profile_photo);

        employeeInfo.setDescription(DESCRIPTION);
        employeeInfo.setIsactive("有效");
        employeeInfo.setCreated(new Date());
//        employeeInfo.setCreateby(CREATEBY);

        //插入数据
        EmployeeInfo employeeInfo1 = this.employeeInfoService.insert(employeeInfo);
        if (employeeInfo1.getId() != 0) {
            return BaseResponse.ok(null, "工作人员信息录入成功");
        } else {
            return BaseResponse.fail("工作人员信息录入失败");
        }
    }

    /**
     * 修改
     *
     * @param //太多了，不写了
     * @return RESTful api
     */

    @ApiOperation(value = "工作人员信息修改接口", notes = "工作人员信息修改")

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "id", value = "工作人员ID", dataType = "Integer", required = true),
            @ApiImplicitParam(paramType = "form", name = "username", value = "工作人员姓名", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "gender", value = "工作人员性别", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "phone", value = "工作人员电话", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "id_card", value = "工作人员身份证号码", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "birthday", value = "工作人员生日", dataType = "string", required = false),
            @ApiImplicitParam(paramType = "form", name = "hire_date", value = "工作人员入职日期", dataType = "string", required = false),
            @ApiImplicitParam(paramType = "form", name = "resign_date", value = "工作人员离职日期", dataType = "string", required = false),
            @ApiImplicitParam(paramType = "form", name = "imgset_dir", value = "工作人员图像目录", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "profile_photo", value = "工作人员头像路径", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "DESCRIPTION", value = "描述", dataType = "String", required = false)
           // @ApiImplicitParam(paramType = "form", name = "ISACTIVE", value = "是否有效", dataType = "String", required = false)
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
            @RequestParam(value = "hire_date", defaultValue = "",required = false) String hire_date,
            @RequestParam(value = "resign_date", defaultValue = "",required = false) String resign_date,
            @RequestParam(value = "imgset_dir", defaultValue = "", required = false) String imgset_dir,
            @RequestParam(value = "profile_photo", defaultValue = "", required = false) String profile_photo,
            @RequestParam(value = "DESCRIPTION", defaultValue = "", required = false) String DESCRIPTION
            //@RequestParam(value = "ISACTIVE", defaultValue = "", required = false) String ISACTIVE
             ) {

        EmployeeInfo employeeInfo = this.employeeInfoService.queryById(id);
        //赋值
        if (!username.equals("")) {
            employeeInfo.setUsername(username);
        }

        if (!gender.equals("")) {
            employeeInfo.setGender(gender);
        }
        if (!phone.equals("")) {
            employeeInfo.setPhone(phone);
        }

        if (!id_card.equals("")) {
            employeeInfo.setIdCard(id_card);
        }

        if (checkDate(birthday)!=null) {
            employeeInfo.setBirthday(checkDate(birthday));
        }

        if (checkDate(hire_date)!=null) {
            employeeInfo.setHireDate(checkDate(hire_date));
        }
        if (checkDate(resign_date)!=null) {
            employeeInfo.setResignDate(checkDate(resign_date));
        }
        if (!imgset_dir.equals("")) {
            employeeInfo.setImgsetDir(imgset_dir);
        }
        if (!profile_photo.equals("")) {
            employeeInfo.setProfilePhoto(profile_photo);
        }
        if (!DESCRIPTION.equals("")) {
            employeeInfo.setDescription(DESCRIPTION);
        }
//        if (!ISACTIVE.equals("")) {
//            employeeInfo.setIsactive(ISACTIVE);
//        }

        employeeInfo.setUpdated(new Date());

        //修改数据
        EmployeeInfo employeeInfo1 = this.employeeInfoService.update(employeeInfo);
        if (employeeInfo1.getId() != 0) {
            return BaseResponse.ok(null, "工作人员信息修改成功");
        } else {
            return BaseResponse.fail("工作人员信息修改失败");
        }
    }

    /**
     * 根据ID精确查询
     *
     * @param id 主键
     * @return RESTful api
     */

    @ApiOperation(value = "根据ID精确查询工作人员信息查询接口", notes = "根据ID精确查询工作人员信息")


    @ApiImplicitParam(paramType = "query", name = "id", value = "工作人员ID", dataType = "Integer", required = true)

    @GetMapping("/querybyid")
    public BaseResponse querybyid(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "id", required = true) Integer id) {

        if (!id.equals(0)) {
            EmployeeInfo employeeInfo = this.employeeInfoService.queryById(id);
            if (employeeInfo.getId() != 0) {
                return BaseResponse.ok(employeeInfo);
            } else {
                return BaseResponse.fail("未查到相关信息");
            }
        }

        return BaseResponse.fail("请输入工作人员id");
    }

    /**
     * 根据身份证精确查询
     *
     * @param id_card 身份证
     * @return RESTful api
     */

    @ApiOperation(value = "根据身份证精确查询工作人员信息查询接口", notes = "根据身份证精确查询工作人员信息查询")


    @ApiImplicitParam(paramType = "form", name = "id_card", value = "工作人员身份证号码", dataType = "String", required = false)

    @PostMapping("/querybycard")
    public BaseResponse querybycard(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "id_card", defaultValue = "", required = true) String id_card) {

        if (!id_card.equals("")) {
            EmployeeInfo employeeInfo = this.employeeInfoService.queryByCard(id_card);
            if (employeeInfo.getId() != 0) {
                return BaseResponse.ok(employeeInfo);
            } else {
                return BaseResponse.fail("未查到相关信息");
            }
        }

        return BaseResponse.fail("请正确输入工作人员身份证信息");
    }

    /**
     * 查询指定数量的工作人员信息
     *
     * @param limit 查询条数
     * @return RESTful api
     */

    @ApiOperation(value = "查询指定数量的工作人员信息查询接口", notes = "查询指定数量的工作人员信息")


    @ApiImplicitParam(paramType = "query", name = "limit", value = "查询条数", dataType = "int", required = true)

    @GetMapping("/querybylimit")
    public BaseResponse querybylimit(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "9") int limit) {

        List<EmployeeInfo> employeeInfos = this.employeeInfoService.queryAllByLimit(offset, limit);
        return BaseResponse.ok(employeeInfos);

    }

    /**
     * 删除指定的工作人员信息
     *
     * @param id 主键
     * @return RESTful api
     */

    @ApiOperation(value = "删除指定的工作人员信息", notes = "删除指定的工作人员信息")


    @ApiImplicitParam(paramType = "query", name = "id", value = "工作人员ID", dataType = "Integer", required = true)

    @GetMapping("/delete")
    public BaseResponse delete(
            // HttpServletRequest request
            // HttpServletResponse response,
            @RequestParam(value = "id", defaultValue = "5") Integer id) {
        if (this.employeeInfoService.queryById(id) != null) {
            this.employeeInfoService.deleteById(id);
            return BaseResponse.ok(null, "删除成功");
        }
        return BaseResponse.fail("删除失败，未找到工作人员信息。");

    }

    @ApiOperation(value = "返回工作人员总人数")
    @GetMapping("/countAll")
    public BaseResponse countAll() {
        return BaseResponse.okMap("工作人员总人数", this.employeeInfoService.countAll());
    }

    @ApiOperation(value = "返回工作人员性别的统计情况")
    @GetMapping("/countByGender")
    public BaseResponse countByGender() {

        Map<String, Integer> map = new LinkedMap<String, Integer>();
        map.put("Male", this.employeeInfoService.countAllMale());
        map.put("Female", this.employeeInfoService.countAllFemale());
        return BaseResponse.okMap("employeeByGender", map);
    }

    @ApiOperation(value = "返回当前在职的工作人员数量")
    @GetMapping("/countAllActive")
    public BaseResponse countAllActive() {
        return BaseResponse.okMap("在职工作人员数目", this.employeeInfoService.countAllActive());
    }

    @ApiOperation(value = "返回工作人员的年龄情况")
    @GetMapping("/countByAge")
    public BaseResponse countByAge() {

        Map<String, Integer> map = new LinkedMap<String, Integer>();
        map.put("one", this.employeeInfoService.countLess18());
        map.put("two", this.employeeInfoService.count19to25());
        map.put("three", this.employeeInfoService.count26to35());
        map.put("four", this.employeeInfoService.count36to45());
        map.put("five", this.employeeInfoService.count46to55());
        map.put("six", this.employeeInfoService.countOver55());

        return BaseResponse.okMap("employeeByAge", map);
    }

}