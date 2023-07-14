package cn.net.luoma.aicarsystemserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (EmployeeInfo)实体类
 *
 * @author makejava
 * @since 2020-07-01 10:40:52
 */
public class EmployeeInfo implements Serializable {
    private static final long serialVersionUID = 105606494795383620L;
    
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
    
    private Date hireDate;
    
    private Date resignDate;
    
    private String imgsetDir;
    
    private String profilePhoto;
    
    private String description;
    
    private String isactive;
    
    private Date created;
    
    private Integer createby;
    
    private Date updated;
    
    private Integer updateby;
    
    private String remove;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getResignDate() {
        return resignDate;
    }

    public void setResignDate(Date resignDate) {
        this.resignDate = resignDate;
    }

    public String getImgsetDir() {
        return imgsetDir;
    }

    public void setImgsetDir(String imgsetDir) {
        this.imgsetDir = imgsetDir;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getUpdateby() {
        return updateby;
    }

    public void setUpdateby(Integer updateby) {
        this.updateby = updateby;
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

}