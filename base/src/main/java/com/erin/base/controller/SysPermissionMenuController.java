package com.erin.base.controller;

import core.BaseController;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import com.erin.base.service.SysPermissionMenuService;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import utils.ResultUtils;

import javax.annotation.Resource;


/**
 * <p>
 * 权限菜单关联表  前端控制器
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/sysPermissionMenu")
@Api(value = "权限菜单关联表接口", description = "权限菜单关联表接口")
public class SysPermissionMenuController extends BaseController {

	@Autowired
	SysPermissionMenuService syspermissionmenuService;

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "权限菜单关联表详情", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object get(@PathVariable("id") Long id) {
        return ResultUtils.wrapSuccess(syspermissionmenuService.getById(id));
	}
}