package com.erin.base.service;

import com.erin.base.domain.SysUser;
import com.erin.base.mapper.SysUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@DubboService
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser>{

}