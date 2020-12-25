package com.erin.base.dto.response;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;


/**
 * <p>
 * 角色表响应类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@ApiModel("角色表响应类")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRoleResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;
    /**
     * 角色code
     */
    @ApiModelProperty(value = "角色code")
    private String roleCode;
    /**
     * 角色名字
     */
    @ApiModelProperty(value = "角色名字")
    private String roleName;
    /**
     * 是否管理员(1否，2是)
     */
    @ApiModelProperty(value = "是否管理员(1否，2是)")
    private Integer adminFlag;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private Long createOperator;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDatetime;
    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private Long updateOperator;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateDatetime;
}
