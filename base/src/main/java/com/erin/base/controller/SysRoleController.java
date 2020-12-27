package com.erin.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.erin.base.domain.SysRole;
import com.erin.base.domain.SysUser;
import com.erin.base.dto.request.SysRoleRequestDTO;
import com.erin.base.dto.request.api.SysRolePageQuery;
import com.erin.base.dto.request.api.SysUserPageQuery;
import core.BaseController;
import entiry.Result;
import lombok.SneakyThrows;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;
import com.erin.base.service.SysRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import utils.ResultUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


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
public class SysRoleController extends BaseController {

	@Autowired
	SysRoleService sysroleService;

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "角色表详情", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object get(@PathVariable("id") Long id) {
        return ResultUtils.wrapSuccess(sysroleService.getById(id));
	}

	@SneakyThrows
	@PostMapping(value = "/page")
	@ApiOperation(value = "列表", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result<IPage<SysRole>>> page(@RequestBody SysRolePageQuery sysRolePageQuery, HttpServletRequest httpServletRequest) {
		return ResultUtils.wrapSuccess(sysroleService.getListPage(sysRolePageQuery));
	}

	@SneakyThrows
	@PostMapping(value = "/create")
	@ApiOperation(value = "创建一个角色", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result<Long>> create(@RequestBody SysRoleRequestDTO sysRoleRequestDTO, HttpServletRequest httpServletRequest) {
		return ResultUtils.wrapSuccess(sysroleService.create(sysRoleRequestDTO));
	}
}