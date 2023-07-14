package cn.net.luoma.aicarsystemserver.service.impl;

import cn.net.luoma.aicarsystemserver.entity.EventInfo;
import cn.net.luoma.aicarsystemserver.dao.EventInfoDao;
import cn.net.luoma.aicarsystemserver.service.EventInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EventInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-07-01 11:19:48
 */
@Service("eventInfoService")
public class EventInfoServiceImpl implements EventInfoService {
    @Resource
    private EventInfoDao eventInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EventInfo queryById(Integer id) {
        return this.eventInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<EventInfo> queryAllByLimit(int offset, int limit) {
        return this.eventInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param eventInfo 实例对象
     * @return 实例对象
     */
    @Override
    public EventInfo insert(EventInfo eventInfo) {
        this.eventInfoDao.insert(eventInfo);
        return eventInfo;
    }

    /**
     * 修改数据
     *
     * @param eventInfo 实例对象
     * @return 实例对象
     */
    @Override
    public EventInfo update(EventInfo eventInfo) {
        this.eventInfoDao.update(eventInfo);
        return this.queryById(eventInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.eventInfoDao.deleteById(id) > 0;
    }

    @Override
    public int countAll() {
        return this.eventInfoDao.countAll();
    }

    @Override
    public int count0() {
        return this.eventInfoDao.count0();
    }

    @Override
    public int count1() {
        return this.eventInfoDao.count1();
    }

    @Override
    public int count2() {
        return this.eventInfoDao.count2();
    }

    @Override
    public int count3() {
        return this.eventInfoDao.count3();
    }

    @Override
    public int count4() {
        return this.eventInfoDao.count4();
    }

    @Override
    public int countByTime(int type, String startTime, String endTime) {
        return this.eventInfoDao.countByTime(type, startTime, endTime);
    }

    @Override
    public int countByLocation(int type, String location) {
        return this.eventInfoDao.countByLocation(type,location);
    }

//    @Override
//    public Map<Integer, Integer> countByType() {
//        return this.eventInfoDao.countByType();
//    }
}