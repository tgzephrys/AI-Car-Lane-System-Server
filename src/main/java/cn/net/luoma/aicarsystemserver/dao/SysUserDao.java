package cn.net.luoma.aicarsystemserver.dao;

import cn.net.luoma.aicarsystemserver.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-30 16:46:23
 */
public interface SysUserDao {


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);


    /**
     * 通过用户名和密码查询管理员
     *
     * @param username 用户名
     * @param password 密码
     * @return 实例对象
     */
    SysUser queryByAccount(@Param("username") String username, @Param("password") String password);

    /**
     * 通过用户名查询管理员
     *
     * @param username 用户名
     *
     * @return 实例对象
     */
    SysUser queryByName(String username);

    /**
     * 新增一项数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int update(SysUser sysUser);


}