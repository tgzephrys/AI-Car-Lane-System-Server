package cn.net.luoma.aicarsystemserver.dao;

import cn.net.luoma.aicarsystemserver.entity.EventPic;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (EventPic)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-08 14:03:09
 */
public interface EventPicDao {

    /**
     * 通过ID查询单条数据
     *
     * @param eventId 主键
     * @return 实例对象
     */
    EventPic queryById(Integer eventId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EventPic> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param eventPic 实例对象
     * @return 对象列表
     */
    List<EventPic> queryAll(EventPic eventPic);

    /**
     * 新增数据
     *
     * @param eventPic 实例对象
     * @return 影响行数
     */
    int insert(EventPic eventPic);

    /**
     * 修改数据
     *
     * @param eventPic 实例对象
     * @return 影响行数
     */
    int update(EventPic eventPic);

    /**
     * 通过主键删除数据
     *
     * @param eventId 主键
     * @return 影响行数
     */
    int deleteById(Integer eventId);

}