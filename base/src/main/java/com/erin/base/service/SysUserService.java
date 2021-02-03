package com.erin.base.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erin.base.constant.MessageConstant;
import com.erin.base.dto.request.api.SysUserPageQuery;
import constant.HttpConstant;
import exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.erin.base.domain.SysUser;
import com.erin.base.dto.request.SysUserRequestDTO;
import com.erin.base.dto.response.SysUserResponseDTO;
import com.erin.base.mapper.SysUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import utils.StringUtils;

import java.util.Objects;

import static com.erin.base.constant.UserConstant.LOGIN;
import static com.erin.base.constant.UserConstant.REGISTER;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@Slf4j
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {

    private final SysUserMapper sysUserMapper;

    private final I18nService i18nService;

    public SysUserService(I18nService i18nService, SysUserMapper sysUserMapper) {
        this.i18nService = i18nService;
        this.sysUserMapper = sysUserMapper;
    }

    /**
     * 登录验证接口
     * @param sysUserRequestDTO
     * @return
     * @throws BusinessException
     */
    public SysUserResponseDTO login(SysUserRequestDTO sysUserRequestDTO) throws BusinessException {
        checkData(sysUserRequestDTO, LOGIN);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SysUser.ACCOUNT, sysUserRequestDTO.getAccount());
        queryWrapper.eq(SysUser.PSWORD, sysUserRequestDTO.getPsword());
        SysUser sysUser = this.getOne(queryWrapper);
        if (!Objects.isNull(sysUser)) {
            SysUserResponseDTO sysUserResponseDTO = new SysUserResponseDTO();
            BeanUtils.copyProperties(sysUser, sysUserResponseDTO);
            return sysUserResponseDTO;
        } else {
            throw new BusinessException(i18nService.getMessage(MessageConstant.SERVICE_USER_LOGIN_FAIL), HttpConstant.ErrorCode.NOT_LOGIN);
        }
    }

    /**
     * register
     * @param sysUserRequestDTO
     * @return
     * @throws BusinessException
     */
    public Long register(SysUserRequestDTO sysUserRequestDTO) throws BusinessException {
        checkData(sysUserRequestDTO, REGISTER);
        SysUser user = new SysUser();
        BeanUtils.copyProperties(sysUserRequestDTO, user);
        boolean save = this.save(user);
        if (!save) {
            log.error("注册异常！{}", user.toString());
            throw new BusinessException(MessageConstant.SERVICE_USER_REGISTER_ERROR);
        } else {

            // TODO 发送邮箱验证链接，确认邮箱是否本人，不是本人的邮箱无法操作。

            return user.getId();
        }
    }

    public IPage<SysUser> getListPage(SysUserPageQuery sysUserPageQuery) {
        Page<SysUser> page = new Page(sysUserPageQuery.getCurrent(), sysUserPageQuery.getSize());

        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();

        sysUserQueryWrapper.eq(SysUser.NAME, sysUserPageQuery.getName());
        sysUserQueryWrapper.eq(SysUser.PHONE, sysUserPageQuery.getPhone());

        IPage<SysUser> sysUserIPage = sysUserMapper.selectPage(page, sysUserQueryWrapper);

        return sysUserIPage;
    }

    /* 以下开始方法为抽象或者验证对象的方法 */

    public void checkData(SysUserRequestDTO sysUserRequestDTO, Integer scene) throws BusinessException {
        if (Objects.isNull(sysUserRequestDTO)
                || StringUtils.isBlank(sysUserRequestDTO.getAccount())
                || StringUtils.isBlank(sysUserRequestDTO.getPsword())) {
            switch (scene) {
                case LOGIN:
                    throw new BusinessException(i18nService.getMessage(MessageConstant.SERVICE_USER_LOGIN_VERIFICATION), HttpConstant.ErrorCode.ERROR);
                case REGISTER:
                    throw new BusinessException(i18nService.getMessage(MessageConstant.SERVICE_USER_REGISTER_VERIFICATION), HttpConstant.ErrorCode.ERROR);
                default:
            }
        }
    }

    /* END */

}