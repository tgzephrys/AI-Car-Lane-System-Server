package cn.net.luoma.aicarsystemserver.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (OldpersonInfo)实体类
 *
 * @author makejava
 * @since 2020-07-01 12:26:58
 */
@Data
public class OldpersonInfo implements Serializable {
    private static final long serialVersionUID = -13048094518728132L;
    
    private Integer id;
    
    private Integer orgId;
    
    private Integer clientId;
    /**
    * 用户名
    */
    private String username;
    /**
    * 性别
    */
    private String gender;
    
    private String phone;
    
    private String idCard;
    
    private Date birthday;
    
    private Date checkinDate;
    
    private Date checkoutDate;
    
    private String imgsetDir;
    
    private String profilePhoto;
    
    private String roomNumber;
    
    private String firstguardianName;
    
    private String firstguardianRelationship;
    
    private String firstguardianPhone;
    
    private String firstguardianWechat;
    
    private String secondguardianName;
    
    private String secondguardianRelationship;
    
    private String secondguardianPhone;
    
    private String secondguardianWechat;
    
    private String healthState;
    
    private String description;
    
    private String isactive;
    
    private Date created;
    
    private Integer createby;
    
    private Date updated;
    
    private Integer updateby;
    
    private String remove;

}