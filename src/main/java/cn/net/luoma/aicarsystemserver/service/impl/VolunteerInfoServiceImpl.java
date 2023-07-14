package cn.net.luoma.aicarsystemserver.service.impl;

import cn.net.luoma.aicarsystemserver.entity.VolunteerInfo;
import cn.net.luoma.aicarsystemserver.dao.VolunteerInfoDao;
import cn.net.luoma.aicarsystemserver.service.VolunteerInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (VolunteerInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-07-01 11:20:09
 */
@Service("volunteerInfoService")
public class VolunteerInfoServiceImpl implements VolunteerInfoService {
    @Resource
    private VolunteerInfoDao volunteerInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public VolunteerInfo queryById(Integer id) {
        return this.volunteerInfoDao.queryById(id);
    }
    @Override
    public VolunteerInfo queryByIdCard(String id_card) {
        return this.volunteerInfoDao.queryByIdCard(id_card);
    }
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<VolunteerInfo> queryAllByLimit(int offset, int limit) {
        return this.volunteerInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param volunteerInfo 实例对象
     * @return 实例对象
     */
    @Override
    public VolunteerInfo insert(VolunteerInfo volunteerInfo) {
        this.volunteerInfoDao.insert(volunteerInfo);
        return volunteerInfo;
    }

    /**
     * 修改数据
     *
     * @param volunteerInfo 实例对象
     * @return 实例对象
     */
    @Override
    public VolunteerInfo update(VolunteerInfo volunteerInfo) {
        this.volunteerInfoDao.update(volunteerInfo);
        return this.queryById(volunteerInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.volunteerInfoDao.deleteById(id) > 0;
    }

    @Override
    public int countAll() {
        return this.volunteerInfoDao.countAll();
    }

    @Override
    public int countAllMale() {
        return this.volunteerInfoDao.countAllMale();
    }

    @Override
    public int countAllFemale() {
        return this.volunteerInfoDao.countAllFemale();
    }

    @Override
    public int countAllActive() {
        return this.volunteerInfoDao.countAllActive();
    }

    @Override
    public int countLess18() {
        return this.volunteerInfoDao.countLess18();
    }

    @Override
    public int count19to25() {
        return this.volunteerInfoDao.count19to25();
    }

    @Override
    public int count26to35() {
        return this.volunteerInfoDao.count26to35();
    }

    @Override
    public int count36to45() {
        return this.volunteerInfoDao.count36to45();
    }

    @Override
    public int count46to55() {
        return this.volunteerInfoDao.count46to55();
    }

    @Override
    public int countOver55() {
        return this.volunteerInfoDao.countOver55();
    }
}