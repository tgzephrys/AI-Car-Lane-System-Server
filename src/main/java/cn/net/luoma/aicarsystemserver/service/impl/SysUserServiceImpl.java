package cn.net.luoma.aicarsystemserver.service.impl;

import cn.net.luoma.aicarsystemserver.dao.SysUserDao;
import cn.net.luoma.aicarsystemserver.entity.SysUser;
import cn.net.luoma.aicarsystemserver.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-30 16:12:23
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer id) {
        return this.sysUserDao.queryById(id);
    }

    /**
     * 通过用户名查询管理员
     *
     * @param username 用户名
     * @return 实例对象
     */
    @Override
    public SysUser queryByName(String username) {
        return this.sysUserDao.queryByName(username);
    }

    /**
     * 通过用户名和密码查询管理员
     *
     * @param username 用户名
     * @param password 密码
     * @return 实例对象
     */
    @Override
    public SysUser queryByAccount(String username, String password) {
        return this.sysUserDao.queryByAccount(username, password);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getId());
    }

}