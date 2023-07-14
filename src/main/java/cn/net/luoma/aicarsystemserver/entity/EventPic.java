package cn.net.luoma.aicarsystemserver.entity;

import java.io.Serializable;

/**
 * (EventPic)实体类
 *
 * @author makejava
 * @since 2020-07-08 14:03:09
 */
public class EventPic implements Serializable {
    private static final long serialVersionUID = 218005717185053362L;
    
    private Integer eventId;
    
    private String url;


    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}