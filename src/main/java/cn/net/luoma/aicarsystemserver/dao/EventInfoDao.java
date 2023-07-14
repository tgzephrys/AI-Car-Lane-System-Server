package cn.net.luoma.aicarsystemserver.dao;

import cn.net.luoma.aicarsystemserver.entity.EventInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (EventInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-01 11:19:48
 */
public interface EventInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EventInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EventInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param eventInfo 实例对象
     * @return 对象列表
     */
    List<EventInfo> queryAll(EventInfo eventInfo);

    /**
     * 新增数据
     *
     * @param eventInfo 实例对象
     * @return 影响行数
     */
    int insert(EventInfo eventInfo);

    /**
     * 修改数据
     *
     * @param eventInfo 实例对象
     * @return 影响行数
     */
    int update(EventInfo eventInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int countAll();

    int count0();

    int count1();

    int count2();

    int count3();

    int count4();

    int countByTime(int type, String startTime, String endTime);

    int countByLocation(int type, String location);

}