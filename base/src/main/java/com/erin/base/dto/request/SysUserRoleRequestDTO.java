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
 * 用户角色关联表请求类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@ApiModel("用户角色关联表请求类")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserRoleRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private Long roleId;
}
