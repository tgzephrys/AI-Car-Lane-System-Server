package cn.net.luoma.aicarsystemserver.service;

import cn.net.luoma.aicarsystemserver.entity.EventInfo;
import java.util.List;

/**
 * (EventInfo)表服务接口
 *
 * @author makejava
 * @since 2020-07-01 11:19:48
 */
public interface EventInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EventInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EventInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param eventInfo 实例对象
     * @return 实例对象
     */
    EventInfo insert(EventInfo eventInfo);

    /**
     * 修改数据
     *
     * @param eventInfo 实例对象
     * @return 实例对象
     */
    EventInfo update(EventInfo eventInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    int countAll();

//    Map<Integer, Integer> countByType();

    int count0();

    int count1();

    int count2();

    int count3();

    int count4();

    int countByTime(int type, String startTime, String endTime);

    int countByLocation(int type, String location);
}