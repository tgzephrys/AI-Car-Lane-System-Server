package cn.net.luoma.aicarsystemserver.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2020-06-30 16:12:17
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = 176152884839231700L;
    
    private Integer id;
    
    private Integer orgId;
    
    private Integer clientId;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    
    private String realName;
    
    private String sex;
    
    private String email;
    
    private String phone;
    
    private String mobile;
    
    private String description;
    
    private String isactive;
    
    private Date created;
    
    private Integer createby;
    
    private Date updated;
    
    private Integer updateby;
    
    private String remove;
    
    private String datafilter;
    
    private String theme;
    /**
    * 登录成功页面
    */
    private String defaultpage;
    /**
    * 显示不同logo
    */
    private String logoimage;
    /**
    * 第三方登录的凭证
    */
    private String qqopenid;
    /**
    * 检测app的版本号
    */
    private String appversion;
    /**
    *  app权限控制
    */
    private String jsonauth;

}