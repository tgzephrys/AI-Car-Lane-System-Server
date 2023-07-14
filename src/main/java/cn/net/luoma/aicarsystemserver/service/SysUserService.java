package cn.net.luoma.aicarsystemserver.service;

import cn.net.luoma.aicarsystemserver.entity.SysUser;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-30 16:12:23
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);

    /**
     * 通过用户名查询管理员
     *
     * @param username 用户名
     *
     * @return 实例对象
     */
    SysUser queryByName(String username);

    /**
     * 通过用户名和密码查询管理员
     *
     * @param username 用户名
     * @param password 密码
     * @return 实例对象
     */
    SysUser queryByAccount(String username, String password);


    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);


}