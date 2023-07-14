package cn.net.luoma.aicarsystemserver.service;

import cn.net.luoma.aicarsystemserver.entity.EventPic;
import java.util.List;

/**
 * (EventPic)表服务接口
 *
 * @author makejava
 * @since 2020-07-08 14:03:09
 */
public interface EventPicService {

    /**
     * 通过ID查询单条数据
     *
     * @param eventId 主键
     * @return 实例对象
     */
    EventPic queryById(Integer eventId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EventPic> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param eventPic 实例对象
     * @return 实例对象
     */
    EventPic insert(EventPic eventPic);

    /**
     * 修改数据
     *
     * @param eventPic 实例对象
     * @return 实例对象
     */
    EventPic update(EventPic eventPic);

    /**
     * 通过主键删除数据
     *
     * @param eventId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer eventId);

}