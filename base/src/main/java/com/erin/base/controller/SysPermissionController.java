package com.erin.base.controller;

import com.mayi.core.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import com.erin.base.service.SysPermissionService;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.mayi.core.base.AbstractController;

/**
 * <p>
 * 权限表  前端控制器
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/sysPermission")
@Api(value = "权限表接口", description = "权限表接口")
public class SysPermissionController extends AbstractController {

	@Autowired
	SysPermissionService syspermissionService;

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "权限表详情", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object get(@PathVariable("id") Long id) {
        return ResultUtils.wrapSuccess(syspermissionService.getById(id));
	}
}