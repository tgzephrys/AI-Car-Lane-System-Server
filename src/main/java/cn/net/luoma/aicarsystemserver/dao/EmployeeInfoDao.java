package cn.net.luoma.aicarsystemserver.dao;

import cn.net.luoma.aicarsystemserver.entity.EmployeeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (EmployeeInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-01 10:40:52
 */
public interface EmployeeInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeInfo queryById(Integer id);

    /**
     * 查询数据
     *
     * @param username 工作人员姓名
     *
     * @return 对象列表
     */
    List<EmployeeInfo> queryByName(String username);

    /**
     * 查询数据
     *
     * @param id_card 身份证号码
     *
     * @return 对象
     */
    EmployeeInfo queryByCard(String id_card);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EmployeeInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param employeeInfo 实例对象
     * @return 对象列表
     */
    List<EmployeeInfo> queryAll(EmployeeInfo employeeInfo);

    /**
     * 新增数据
     *
     * @param employeeInfo 实例对象
     * @return 影响行数
     */
    int insert(EmployeeInfo employeeInfo);

    /**
     * 修改数据
     *
     * @param employeeInfo 实例对象
     * @return 影响行数
     */
    int update(EmployeeInfo employeeInfo);

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