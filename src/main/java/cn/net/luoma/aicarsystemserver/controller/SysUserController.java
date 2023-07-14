package cn.net.luoma.aicarsystemserver.controller;

import cn.net.luoma.aicarsystemserver.common.ApiCode;
import cn.net.luoma.aicarsystemserver.common.TokenUtil;
import cn.net.luoma.aicarsystemserver.entity.SysUser;
import cn.net.luoma.aicarsystemserver.response.BaseResponse;
import cn.net.luoma.aicarsystemserver.service.SysUserService;
import cn.net.luoma.aicarsystemserver.vo.SysUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2020-06-30 16:12:23
 */
@RestController
@RequestMapping("sysUser")
@Api(value = "系统管理员相关操作接口", tags = "系统管理员相关操作接口", description = "系统管理员")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    @Autowired
    private RestTemplate restTemplate;

    private static final String baseUrl = "http://luoma.net.cn:12580/api/1/upload";
    private static final String key = "ef61b1c887c1c281d9df303fff8031b3";


    /**
     * 登录
     *
     * @param username 用户名
     * @param password 用户密码
     * @return RESTful api
     */

    @ApiOperation(value = "登录接口", notes = "")

    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "form", name = "map", value = "用户名", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "username", value = "用户名", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "form", name = "password", value = "用户密码", dataType = "String", required = true)
    })
    @PostMapping("/login")
    public BaseResponse login(
           // HttpServletRequest request
            HttpServletResponse response,
            @RequestParam(value = "username", required = true, defaultValue = "") String username,
            @RequestParam(value = "password", required = true, defaultValue = "") String password
//           @RequestBody Map<String, String> map
            ) {
        SysUser user = this.sysUserService.queryByAccount(username, password);
        if (user == null) {
            return BaseResponse.result(ApiCode.FAIL, "用户名或密码错误", null);
        } else {
            String token = TokenUtil.createToken(user);
            Cookie cookie = new Cookie("token", token);

            //设置生命周期以秒为单位
            cookie.setMaxAge(604800);

            cookie.setPath("/");

           // cookie.setSecure(SECURE);

            response.addCookie(cookie);

          //  response.setHeader("Set-Cookie", response.getHeader("Set-Cookie") + "; SameSite=strict");
            return BaseResponse.ok(token);
        }
    }

    /**
     * 注册
     *
     * @return RESTful api
     */

    @ApiOperation(value = "注册接口", notes = "管理员注册")

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "username", value = "用户名", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "form", name = "password", value = "用户密码", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "form", name = "sex", value = "性别", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "email", value = "邮箱", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "mobile", value = "移动电话", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "form", name = "logoimage", value = "头像logo", dataType = "String", required = false)
    })
    @PostMapping("/register")
    public BaseResponse register(
            // HttpServletRequest request,
            // HttpServletResponse response,
            @RequestParam(value = "username", required = true, defaultValue = "") String username,
            @RequestParam(value = "password", required = true, defaultValue = "") String password,
            @RequestParam(value = "sex", required = false, defaultValue = "") String sex,
            @RequestParam(value = "email", required = false, defaultValue = "") String email,
            @RequestParam(value = "mobile", required = false, defaultValue = "") String mobile,
            @RequestParam(value = "logoimage", defaultValue = "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif") String logoimage) {

        SysUser user1 = this.sysUserService.queryByName(username);

        if (user1 != null) {
            return BaseResponse.result(ApiCode.FAIL, "用户名重复", null);
        } else {
            SysUser user2 = new SysUser();
            user2.setUsername(username);
            user2.setPassword(password);
            user2.setSex(sex);
            user2.setEmail(email);
            user2.setMobile(mobile);
            user2.setCreated(new Date());
            user2.setLogoimage(logoimage);
            SysUser user3 = this.sysUserService.insert(user2);
            if(user3.getId() != 0) {
                return BaseResponse.ok(null,"注册成功");
            }else{
                return BaseResponse.result(ApiCode.FAIL, "注册失败", null);
            }
        }
    }

    /**
     * 修改密码
     *
     * @return RESTful api
     */

    @ApiOperation(value = "修改密码接口", notes = "")

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "ID", value = "用户id", dataType = "Integer", required = true),
            @ApiImplicitParam(paramType = "form", name = "password", value = "用户密码", dataType = "String", required = true)
    })
    @PostMapping("/modify")
    public BaseResponse modify(
            // HttpServletRequest request,
            // HttpServletResponse response,
            @RequestParam(value = "ID", required = true, defaultValue = "") Integer id,
            @RequestParam(value = "password", required = true, defaultValue = "") String password) {

        SysUser user = this.sysUserService.queryById(id);
        String oldpassword = user.getPassword();
        if(oldpassword.equals(password)){
            return BaseResponse.result(ApiCode.FAIL, "更改密码失败，新密码不能和旧密码相同", null);
        }else{
            user.setPassword(password);
            this.sysUserService.update(user);
            return BaseResponse.ok(null,"修改密码成功");
        }
    }

    /**
     * 设置头像
     *
     * @return RESTful api
     */

    @ApiOperation(value = "设置头像接口", notes = "设置头像")

    @ApiImplicitParam(paramType = "form", name = "base64", value = "头像base64编码字符串", dataType = "String", required = true)

    @PostMapping("/setImage")
    public BaseResponse image(
            //HttpServletRequest request,
            // HttpServletResponse response,
             @RequestParam(value = "base64", required = true, defaultValue = "") String base64,
             @CookieValue(value = "token" , required = true, defaultValue = "") String token
            ) {
      if(!TokenUtil.verifyToken(token)){
          return  BaseResponse.result(ApiCode.UNAUTHORIZED);
      }else
      {
        //将文件上传至图床，接收返回url
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("key", key);
        map.add("source", base64);
        map.add("format", "txt");

        String response = restTemplate.postForObject(baseUrl,map,String.class);

        if(response.startsWith("http")) {
            SysUser user = this.sysUserService.queryById(Integer.valueOf(TokenUtil.getId(token)));
            user.setLogoimage(response);
            this.sysUserService.update(user);
            if (this.sysUserService.update(user) != null) {
                return BaseResponse.ok(null,"更换头像成功");
            }
        }
        return  BaseResponse.fail("更换头像失败,头像不能和近期头像相同。");
      }

    }


    /**
     * 获取用户信息
     *
     * @return RESTful api
     */

    @ApiOperation(value = "获取用户信息接口", notes = "获取用户信息")

    @GetMapping("/getinfo")
    public BaseResponse getInfo(
            @RequestParam(value = "token", required = true, defaultValue = "") String token
//            @CookieValue(value = "token" , required = true ) String token
    ){
        if(!TokenUtil.verifyToken(token)){
            return  BaseResponse.result(ApiCode.UNAUTHORIZED);
        }
        SysUser user = this.sysUserService.queryById(Integer.valueOf(TokenUtil.getId(token)));
        SysUserVo sysUserVo = new SysUserVo();
        sysUserVo.setName(user.getRealName());
        sysUserVo.setPermission(user.getOrgId().toString());
        sysUserVo.setAvatar(user.getLogoimage());
        sysUserVo.setIntroduction(user.getDescription());
        return  BaseResponse.ok(sysUserVo);
    }

    /**
     * 登出
     *
     * @return RESTful api
     */

    @ApiOperation(value = "登出接口", notes = "登出")

    @GetMapping("/loginout")
    public BaseResponse loginOut(){
        return BaseResponse.ok();
    }


 }