package com.erin.base.service;

import com.erin.base.domain.SysMenu;
import com.erin.base.mapper.SysMenuMapper;

import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SysMenuService extends ServiceImpl<SysMenuMapper, SysMenu>{

}