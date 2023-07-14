package cn.net.luoma.aicarsystemserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (EventInfo)实体类
 *
 * @author makejava
 * @since 2020-07-01 11:19:48
 */

public class EventInfo implements Serializable {
    private static final long serialVersionUID = 128202008702403105L;
    
    private Integer id;
    /**
    * 事件类型
    */
    private Integer eventType;
    
    private Date eventDate;
    
    private String eventLocation;
    
    private String eventDesc;
    
    private Integer oldpersonId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public Integer getOldpersonId() {
        return oldpersonId;
    }

    public void setOldpersonId(Integer oldpersonId) {
        this.oldpersonId = oldpersonId;
    }

}