package cn.net.luoma.aicarsystemserver.service.impl;

import cn.net.luoma.aicarsystemserver.entity.EventPic;
import cn.net.luoma.aicarsystemserver.dao.EventPicDao;
import cn.net.luoma.aicarsystemserver.service.EventPicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EventPic)表服务实现类
 *
 * @author makejava
 * @since 2020-07-08 14:03:09
 */
@Service("eventPicService")
public class EventPicServiceImpl implements EventPicService {
    @Resource
    private EventPicDao eventPicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param eventId 主键
     * @return 实例对象
     */
    @Override
    public EventPic queryById(Integer eventId) {
        return this.eventPicDao.queryById(eventId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<EventPic> queryAllByLimit(int offset, int limit) {
        return this.eventPicDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param eventPic 实例对象
     * @return 实例对象
     */
    @Override
    public EventPic insert(EventPic eventPic) {
        this.eventPicDao.insert(eventPic);
        return eventPic;
    }

    /**
     * 修改数据
     *
     * @param eventPic 实例对象
     * @return 实例对象
     */
    @Override
    public EventPic update(EventPic eventPic) {
        this.eventPicDao.update(eventPic);
        return this.queryById(eventPic.getEventId());
    }

    /**
     * 通过主键删除数据
     *
     * @param eventId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer eventId) {
        return this.eventPicDao.deleteById(eventId) > 0;
    }
}