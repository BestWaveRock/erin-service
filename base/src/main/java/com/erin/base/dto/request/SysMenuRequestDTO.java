package com.erin.base.dto.request;

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
 * 权限表请求类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@ApiModel("权限表请求类")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenuRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;
    /**
     * 菜单名字
     */
    @ApiModelProperty(value = "菜单名字")
    private String menuName;
    /**
     * 菜单url
     */
    @ApiModelProperty(value = "菜单url")
    private String menuUrl;
    /**
     * 菜单icon
     */
    @ApiModelProperty(value = "菜单icon")
    private String menuIcon;
    /**
     * 菜单层级(0root,1default,2submenu,3btn)
     */
    @ApiModelProperty(value = "菜单层级(0root,1default,2submenu,3btn)")
    private Integer hierarchy;
    /**
     * 父菜单
     */
    @ApiModelProperty(value = "父菜单")
    private Long parentId;
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
