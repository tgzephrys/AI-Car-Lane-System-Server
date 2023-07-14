package cn.net.luoma.aicarsystemserver.dao;

import cn.net.luoma.aicarsystemserver.entity.VolunteerInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (VolunteerInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-01 11:20:09
 */
public interface VolunteerInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    VolunteerInfo queryById(Integer id);
    VolunteerInfo queryByIdCard(String id_card);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<VolunteerInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param volunteerInfo 实例对象
     * @return 对象列表
     */
    List<VolunteerInfo> queryAll(VolunteerInfo volunteerInfo);

    /**
     * 新增数据
     *
     * @param volunteerInfo 实例对象
     * @return 影响行数
     */
    int insert(VolunteerInfo volunteerInfo);

    /**
     * 修改数据
     *
     * @param volunteerInfo 实例对象
     * @return 影响行数
     */
    int update(VolunteerInfo volunteerInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int countAll();

    int countAllMale();

    int countAllFemale();

    int countAllActive();

    int countLess18();
//
    int count19to25();
//
    int count26to35();
//
    int count36to45();
//
    int count46to55();
//
    int countOver55();


}