package com.erin.base.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erin.base.domain.SysPermission;
import com.erin.base.domain.SysRole;
import com.erin.base.dto.request.api.SysPermissionPageQuery;
import com.erin.base.dto.request.api.SysRolePageQuery;
import com.erin.base.mapper.SysPermissionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@Service
public class SysPermissionService extends ServiceImpl<SysPermissionMapper, SysPermission>{

    private SysPermissionMapper sysPermissionMapper;

    public SysPermissionService (SysPermissionMapper sysPermissionMapper) {
        this.sysPermissionMapper = sysPermissionMapper;
    }


    public IPage<SysPermission> getListPage(SysPermissionPageQuery sysPermission) {
        Page<SysPermission> page = new Page(sysPermission.getCurrent(), sysPermission.getSize());

        IPage<SysRole> sysRoleIPage = sysPermissionMapper.selectPage(page, new QueryWrapper<SysPermission>()
                .eq(SysPermission.ROLE_NAME, sysPermission.getPermissionName())
                .eq(SysPermission.ROLE_CODE, sysPermission.getPermissionCode()));

        return sysRoleIPage;
    }

}