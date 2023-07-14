package cn.net.luoma.aicarsystemserver.dao;

import cn.net.luoma.aicarsystemserver.entity.OldpersonInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (OldpersonInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-01 12:26:58
 */
public interface OldpersonInfoDao {

    /**
     * 查询数据库中老人记录数量
     *
     * @return 记录条数
     */
     Integer count();

    /**
     * 查询老人性别相应数量
     *
     * @return
     */
    List<Map<String, Integer>> countBySex();

    /**
     * 查询根据不同年龄的老人数量
     *
     * @return
     */
    List<Map<String, Integer>> countByAge();

    /**
     * 查询根据不同入院日期的老人数量
     *
     * @return
     */
    List<Map<String, Integer>> countByDate();

    /**
     * 查询根据健康状态分类的老人数量
     *
     * @return
     */
    List<Map<String, Integer>> countByState();


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OldpersonInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OldpersonInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询数据
     *
     * @param username 老人姓名
     *
     * @return 对象列表
     */
    List<OldpersonInfo> queryByName(String username);

    /**
     * 查询数据
     *
     * @param id_card 身份证号码
     *
     * @return 对象
     */
    OldpersonInfo queryByCard(String id_card);

    /**
     * 新增数据
     *
     * @param oldpersonInfo 实例对象
     * @return 影响行数
     */
    int insert(OldpersonInfo oldpersonInfo);

    /**
     * 修改数据
     *
     * @param oldpersonInfo 实例对象
     * @return 影响行数
     */
    int update(OldpersonInfo oldpersonInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}