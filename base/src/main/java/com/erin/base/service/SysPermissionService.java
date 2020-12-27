package com.erin.base.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erin.base.constant.MessageConstant;
import com.erin.base.domain.SysPermission;
import com.erin.base.domain.SysRole;
import com.erin.base.dto.request.SysPermissionRequestDTO;
import com.erin.base.dto.request.SysRoleRequestDTO;
import com.erin.base.dto.request.api.SysPermissionPageQuery;
import com.erin.base.dto.request.api.SysRolePageQuery;
import com.erin.base.mapper.SysPermissionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@Slf4j
@Service
public class SysPermissionService extends ServiceImpl<SysPermissionMapper, SysPermission>{

    private SysPermissionMapper sysPermissionMapper;

    public SysPermissionService (SysPermissionMapper sysPermissionMapper) {
        this.sysPermissionMapper = sysPermissionMapper;
    }

    public IPage<SysPermission> getListPage(SysPermissionPageQuery sysPermission) {
        Page<SysPermission> page = new Page(sysPermission.getCurrent(), sysPermission.getSize());

        IPage<SysPermission> sysPermissionIPage = sysPermissionMapper.selectPage(page, new QueryWrapper<SysPermission>()
                .eq(SysPermission.PERMISSION_NAME, sysPermission.getPermissionName())
                .eq(SysPermission.PERMISSION_CODE, sysPermission.getPermissionCode()));

        return sysPermissionIPage;
    }

    public Long create(SysPermissionRequestDTO sysPermissionRequestDTO) throws BusinessException {
        SysPermission sysPermission = new SysPermission();
        BeanUtils.copyProperties(sysPermissionRequestDTO, sysPermission);
        boolean save = this.save(sysPermission);
        if (!save) {
            log.error("保存失敗");
            throw new BusinessException(MessageConstant.SERVICE_USER_SAVE_FAIL);
        }
        return sysPermission.getId();
    }

}