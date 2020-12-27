package com.erin.base.dto.request.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class SysRolePageQuery extends Page {

    String roleName;

    String roleCode;

}