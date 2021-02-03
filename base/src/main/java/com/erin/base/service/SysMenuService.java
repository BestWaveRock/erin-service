package com.erin.base.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erin.base.constant.UserMessageConstant;
import com.erin.base.domain.SysMenu;
import com.erin.base.domain.SysPermission;
import com.erin.base.dto.request.SysMenuRequestDTO;
import com.erin.base.dto.request.SysPermissionRequestDTO;
import com.erin.base.dto.request.api.SysMenuPageQuery;
import com.erin.base.dto.request.api.SysPermissionPageQuery;
import com.erin.base.mapper.SysMenuMapper;

import exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SysMenuService extends ServiceImpl<SysMenuMapper, SysMenu>{

    private SysMenuMapper sysMenuMapper;

    public SysMenuService (SysMenuMapper sysMenuMapper) {
        this.sysMenuMapper = sysMenuMapper;
    }

    public IPage<SysMenu> getListPage(SysMenuPageQuery sysMenuPageQuery) {
        Page<SysMenu> page = new Page(sysMenuPageQuery.getCurrent(), sysMenuPageQuery.getSize());

        IPage<SysMenu> sysPermissionIPage = sysMenuMapper.selectPage(page, new QueryWrapper<SysMenu>()
                .eq(SysMenu.MENU_NAME, sysMenuPageQuery.getMenuName()));

        return sysPermissionIPage;
    }

    public Long create(SysMenuRequestDTO sysMenuRequestDTO) throws BusinessException {
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuRequestDTO, sysMenu);
        boolean save = this.save(sysMenu);
        if (!save) {
            log.error("保存失敗");
            throw new BusinessException(UserMessageConstant.SERVICE_USER_SAVE_FAIL);
        }
        return sysMenu.getId();
    }

}