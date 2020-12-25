package com.erin.base.service;

import com.erin.base.domain.SysRole;
import com.erin.base.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@DubboService
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRole>{

}