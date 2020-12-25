package com.erin.base.dto.request;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;


/**
 * <p>
 * 权限菜单关联表请求类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@ApiModel("权限菜单关联表请求类")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermissionMenuRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;
    /**
     * 权限ID
     */
    @ApiModelProperty(value = "权限ID")
    private Long permissionId;
    /**
     * 菜单ID
     */
    @ApiModelProperty(value = "菜单ID")
    private Long menuId;
}
