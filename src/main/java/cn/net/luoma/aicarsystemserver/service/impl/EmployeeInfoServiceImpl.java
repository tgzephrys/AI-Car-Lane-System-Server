package cn.net.luoma.aicarsystemserver.service.impl;

import cn.net.luoma.aicarsystemserver.entity.EmployeeInfo;
import cn.net.luoma.aicarsystemserver.dao.EmployeeInfoDao;
import cn.net.luoma.aicarsystemserver.service.EmployeeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmployeeInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-07-01 10:40:52
 */
@Service("employeeInfoService")
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
    @Resource
    private EmployeeInfoDao employeeInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EmployeeInfo queryById(Integer id) {
        return this.employeeInfoDao.queryById(id);
    }

    /**
     * 查询数据
     *
     * @param username 工作人员姓名
     * @return 对象列表
     */
    @Override
    public List<EmployeeInfo> queryByName(String username) {
        return this.employeeInfoDao.queryByName(username);
    }

    /**
     * 查询数据
     *
     * @param id_card 身份证号码
     * @return 对象
     */
    @Override
    public EmployeeInfo queryByCard(String id_card) {
        return this.employeeInfoDao.queryByCard(id_card);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<EmployeeInfo> queryAllByLimit(int offset, int limit) {
        return this.employeeInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param employeeInfo 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeInfo insert(EmployeeInfo employeeInfo) {
        this.employeeInfoDao.insert(employeeInfo);
        return employeeInfo;
    }

    /**
     * 修改数据
     *
     * @param employeeInfo 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeInfo update(EmployeeInfo employeeInfo) {
        this.employeeInfoDao.update(employeeInfo);
        return this.queryById(employeeInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employeeInfoDao.deleteById(id) > 0;
    }

    @Override
    public int countAll() {
        return this.employeeInfoDao.countAll();
    }

    @Override
    public int countAllMale() {
        return this.employeeInfoDao.countAllMale();
    }

    @Override
    public int countAllFemale() {
        return this.employeeInfoDao.countAllFemale();
    }

    @Override
    public int countAllActive() {
        return this.employeeInfoDao.countAllActive();
    }

    @Override
    public int countLess18() {
        return this.employeeInfoDao.countLess18();
    }

    @Override
    public int count19to25() {
        return this.employeeInfoDao.count19to25();
    }

    @Override
    public int count26to35() {
        return this.employeeInfoDao.count26to35();
    }

    @Override
    public int count36to45() {
        return this.employeeInfoDao.count36to45();
    }

    @Override
    public int count46to55() {
        return this.employeeInfoDao.count46to55();
    }

    @Override
    public int countOver55() {
        return this.employeeInfoDao.countOver55();
    }
}