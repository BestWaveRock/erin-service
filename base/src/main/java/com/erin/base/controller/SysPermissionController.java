package com.erin.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.erin.base.domain.SysPermission;
import com.erin.base.domain.SysRole;
import com.erin.base.dto.request.SysPermissionRequestDTO;
import com.erin.base.dto.request.SysRoleRequestDTO;
import com.erin.base.dto.request.api.SysPermissionPageQuery;
import com.erin.base.dto.request.api.SysRolePageQuery;
import core.BaseController;
import entiry.Result;
import lombok.SneakyThrows;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;
import com.erin.base.service.SysPermissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import utils.ResultUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


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
public class SysPermissionController extends BaseController {

	@Autowired
	SysPermissionService syspermissionService;

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "权限表详情", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object get(@PathVariable("id") Long id) {
        return ResultUtils.wrapSuccess(syspermissionService.getById(id));
	}

	@SneakyThrows
	@PostMapping(value = "/page")
	@ApiOperation(value = "列表", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result<IPage<SysPermission>>> page(@RequestBody SysPermissionPageQuery sysPermissionPageQuery, HttpServletRequest httpServletRequest) {
		return ResultUtils.wrapSuccess(syspermissionService.getListPage(sysPermissionPageQuery));
	}

	@SneakyThrows
	@PostMapping(value = "/create")
	@ApiOperation(value = "创建一个权限", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result<Long>> create(@RequestBody SysPermissionRequestDTO sysPermissionRequestDTO, HttpServletRequest httpServletRequest) {
		return ResultUtils.wrapSuccess(syspermissionService.create(sysPermissionRequestDTO));
	}
}