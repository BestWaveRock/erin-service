package com.erin.base.controller;

import core.BaseController;
import entiry.Result;
import com.erin.base.dto.request.SysUserRequestDTO;
import com.erin.base.dto.response.SysUserResponseDTO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;
import com.erin.base.service.SysUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import utils.ResultUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 * 用户表  前端控制器
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/sysUser")
@Api(value = "用户表接口", description = "用户表接口")
public class SysUserController extends BaseController {

	@Autowired
	SysUserService sysuserService;

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "用户表详情", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object get(@PathVariable("id") Long id) {
        return ResultUtils.wrapSuccess(sysuserService.getById(id));
	}

	@SneakyThrows
	@PostMapping(value = "/login")
	@ApiOperation(value = "登录接口", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result<SysUserResponseDTO>> login(@RequestBody SysUserRequestDTO sysUserRequestDTO, HttpServletRequest httpServletRequest) {
		SysUserResponseDTO sysUserResponseDTO = sysuserService.login(sysUserRequestDTO);
		return ResultUtils.wrapSuccess(sysUserResponseDTO);
	}
}