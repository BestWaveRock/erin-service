package com.erin.base.service;

import constant.HttpConstant;
import exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erin.base.domain.SysUser;
import com.erin.base.dto.request.SysUserRequestDTO;
import com.erin.base.dto.response.SysUserResponseDTO;
import com.erin.base.mapper.SysUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {

    @Autowired
    private SysUserMapper sysUserMapper;

    private final I18nService i18nService;

    public SysUserService(I18nService i18nService) {
        this.i18nService = i18nService;
    }

    /**
     * 简单的登录验证接口
     * @param sysUserRequestDTO
     * @return
     * @throws BusinessException
     */
    public SysUserResponseDTO login(SysUserRequestDTO sysUserRequestDTO) throws BusinessException {
        checkData(sysUserRequestDTO);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SysUser.ACCOUNT, sysUserRequestDTO.getAccount());
        queryWrapper.eq(SysUser.PSWORD, sysUserRequestDTO.getPsword());
        SysUser sysUser = this.getOne(queryWrapper);
        if (!Objects.isNull(sysUser)) {
            SysUserResponseDTO sysUserResponseDTO = new SysUserResponseDTO();
            BeanUtils.copyProperties(sysUser, sysUserResponseDTO);
            return sysUserResponseDTO;
        } else {
            throw new BusinessException(i18nService.getMessage("service.user.login.fail"), HttpConstant.ErrorCode.NOT_LOGIN);
        }
    }

    public Boolean register(SysUserRequestDTO sysUserRequestDTO) throws BusinessException {
        checkData(sysUserRequestDTO);

        return false;
    }

    public void checkData(SysUserRequestDTO sysUserRequestDTO) throws BusinessException {
        if (Objects.isNull(sysUserRequestDTO)) {
            throw new BusinessException(i18nService.getMessage("service.user.login.verification"), HttpConstant.ErrorCode.ERROR);
        }
    }

}