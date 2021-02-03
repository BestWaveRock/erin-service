package com.erin.base.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erin.base.domain.SysUserRole;
import com.erin.base.dto.request.SysUserRoleRequestDTO;
import com.erin.base.dto.response.SysUserRoleResponseDTO;
import com.erin.base.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@Service
public class SysUserRoleService extends ServiceImpl<SysUserRoleMapper, SysUserRole>{

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 更新关联数据
     * @param sysUserRoleRequestDTO
     * @return
     */
    public boolean updateAssociatedData(SysUserRoleRequestDTO sysUserRoleRequestDTO) {
        return true;
    }

    /**
     * 查询关联数据
     * @param sysUserRoleRequestDTO
     * @return
     */
    public List<SysUserRoleResponseDTO> list(SysUserRoleRequestDTO sysUserRoleRequestDTO) {
        return new ArrayList<>();
    }

}