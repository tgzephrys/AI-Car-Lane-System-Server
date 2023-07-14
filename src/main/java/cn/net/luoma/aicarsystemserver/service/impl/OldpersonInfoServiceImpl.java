package cn.net.luoma.aicarsystemserver.service.impl;

import cn.net.luoma.aicarsystemserver.entity.OldpersonInfo;
import cn.net.luoma.aicarsystemserver.dao.OldpersonInfoDao;
import cn.net.luoma.aicarsystemserver.service.OldpersonInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (OldpersonInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-07-01 12:26:58
 */
@Service("oldpersonInfoService")
public class OldpersonInfoServiceImpl implements OldpersonInfoService {

    @Resource
    private OldpersonInfoDao oldpersonInfoDao;


    /**
     * 查询数据库中老人记录数量
     *
     * @return 记录条数
     */
    @Override
    public Integer count() {
        return this.oldpersonInfoDao.count();
    }

    /**
     * 查询老人性别相应数量
     *
     * @return
     */
    @Override
    public List<Map<String, Integer>> countBySex() {
        return this.oldpersonInfoDao.countBySex();
    }

    /**
     * 查询根据不同年龄的老人数量
     *
     * @return
     */
    @Override
    public List<Map<String, Integer>> countByAge() {
        return this.oldpersonInfoDao.countByAge();
    }

    /**
     * 查询根据不同入院日期的老人数量
     *
     * @return
     */
    @Override
    public List<Map<String, Integer>> countByDate() {
        return this.oldpersonInfoDao.countByDate();
    }

    /**
     * 查询根据健康状态分类的老人数量
     *
     * @return
     */
    @Override
    public List<Map<String, Integer>> countByState() {
        return this.oldpersonInfoDao.countByState();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OldpersonInfo queryById(Integer id) {
        return this.oldpersonInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OldpersonInfo> queryAllByLimit(int offset, int limit) {
        return this.oldpersonInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询数据
     *
     * @param username 老人姓名
     * @return 对象列表
     */
    @Override
    public List<OldpersonInfo> queryByName(String username) {
        return this.oldpersonInfoDao.queryByName(username);
    }

    /**
     * 查询数据
     *
     * @param id_card 身份证号码
     * @return 对象
     */
    @Override
    public OldpersonInfo queryByCard(String id_card) {
        return this.oldpersonInfoDao.queryByCard(id_card);
    }

    /**
     * 新增数据
     *
     * @param oldpersonInfo 实例对象
     * @return 实例对象
     */
    @Override
    public OldpersonInfo insert(OldpersonInfo oldpersonInfo) {
        this.oldpersonInfoDao.insert(oldpersonInfo);
        return oldpersonInfo;
    }

    /**
     * 修改数据
     *
     * @param oldpersonInfo 实例对象
     * @return 实例对象
     */
    @Override
    public OldpersonInfo update(OldpersonInfo oldpersonInfo) {
        this.oldpersonInfoDao.update(oldpersonInfo);
        return this.queryById(oldpersonInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.oldpersonInfoDao.deleteById(id) > 0;
    }
}