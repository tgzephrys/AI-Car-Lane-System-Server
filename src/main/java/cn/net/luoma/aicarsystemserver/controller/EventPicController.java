package cn.net.luoma.aicarsystemserver.controller;

import cn.net.luoma.aicarsystemserver.entity.EventPic;
import cn.net.luoma.aicarsystemserver.service.EventPicService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (EventPic)表控制层
 *
 * @author makejava
 * @since 2020-07-08 14:03:09
 */
@RestController
@RequestMapping("eventPic")
public class EventPicController {
    /**
     * 服务对象
     */
    @Resource
    private EventPicService eventPicService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public EventPic selectOne(Integer id) {
        return this.eventPicService.queryById(id);
    }

}