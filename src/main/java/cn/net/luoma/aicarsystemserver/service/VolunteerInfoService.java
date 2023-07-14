package cn.net.luoma.aicarsystemserver.service;

import cn.net.luoma.aicarsystemserver.entity.VolunteerInfo;
import java.util.List;

/**
 * (VolunteerInfo)表服务接口
 *
 * @author makejava
 * @since 2020-07-01 11:20:09
 */
public interface VolunteerInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    VolunteerInfo queryById(Integer id);
    VolunteerInfo queryByIdCard(String id_card);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<VolunteerInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param volunteerInfo 实例对象
     * @return 实例对象
     */
    VolunteerInfo insert(VolunteerInfo volunteerInfo);

    /**
     * 修改数据
     *
     * @param volunteerInfo 实例对象
     * @return 实例对象
     */
    VolunteerInfo update(VolunteerInfo volunteerInfo);

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