package cn.net.luoma.aicarsystemserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (VolunteerInfo)实体类
 *
 * @author makejava
 * @since 2020-07-01 11:20:08
 */
public class VolunteerInfo implements Serializable {
    private static final long serialVersionUID = 260600546410951375L;
    
    private Integer id;
    
    private Integer orgId;
    
    private Integer clientId;
    /**
    * 姓名
    */
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
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