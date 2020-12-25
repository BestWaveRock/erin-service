package com.erin.base.service;

import com.erin.base.domain.SysPermission;
import com.erin.base.mapper.SysPermissionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@DubboService
public class SysPermissionService extends ServiceImpl<SysPermissionMapper, SysPermission>{

}