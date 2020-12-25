package com.erin.base.service;

import com.erin.base.domain.SysUserRole;
import com.erin.base.mapper.SysUserRoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@DubboService
public class SysUserRoleService extends ServiceImpl<SysUserRoleMapper, SysUserRole>{

}