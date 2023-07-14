package cn.net.luoma.aicarsystemserver.service;

import cn.net.luoma.aicarsystemserver.entity.EmployeeInfo;

import java.util.List;

/**
 * (EmployeeInfo)表服务接口
 *
 * @author makejava
 * @since 2020-07-01 10:40:52
 */
public interface EmployeeInfoService {

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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EmployeeInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param employeeInfo 实例对象
     * @return 实例对象
     */
    EmployeeInfo insert(EmployeeInfo employeeInfo);

    /**
     * 修改数据
     *
     * @param employeeInfo 实例对象
     * @return 实例对象
     */
    EmployeeInfo update(EmployeeInfo employeeInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

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