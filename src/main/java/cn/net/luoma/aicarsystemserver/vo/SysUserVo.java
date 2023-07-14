package cn.net.luoma.aicarsystemserver.vo;

import lombok.Data;

@Data
public class SysUserVo {
    private final String roles = "SystemUser";
    private String introduction;
    private String avatar;
    private String name;
    private String permission;
}
