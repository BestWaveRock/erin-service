package com.erin.base.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import com.erin.base.service.SysRoleService;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import utils.ResultUtils;


/**
 * <p>
 * 角色表  前端控制器
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/sysRole")
@Api(value = "角色表接口", description = "角色表接口")
public class SysRoleController {

	@DubboReference
	SysRoleService sysroleService;

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "角色表详情", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object get(@PathVariable("id") Long id) {
        return ResultUtils.wrapSuccess(sysroleService.getById(id));
	}
}