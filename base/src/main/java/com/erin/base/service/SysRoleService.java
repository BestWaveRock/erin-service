package com.erin.base.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erin.base.domain.SysRole;
import com.erin.base.dto.request.api.SysRolePageQuery;
import com.erin.base.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@Service
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRole>{

    private final SysRoleMapper sysRoleMapper;

    public SysRoleService(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    public IPage<SysRole> getListPage(SysRolePageQuery sysRolePageQuery) {
        Page<SysRole> page = new Page<>(sysRolePageQuery.getCurrent(), sysRolePageQuery.getSize());

        IPage<SysRole> sysRoleIPage = sysRoleMapper.selectPage(page, new QueryWrapper<SysRole>()
                .eq(SysRole.ROLE_NAME, sysRolePageQuery.getRoleName())
                .eq(SysRole.ROLE_CODE, sysRolePageQuery.getRoleCode()));

        return sysRoleIPage;
    }

}