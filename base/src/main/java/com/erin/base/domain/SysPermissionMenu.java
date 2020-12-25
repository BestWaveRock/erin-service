package com.erin.base.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限菜单关联表
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@ApiModel("权限菜单关联表")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermissionMenu extends Model<SysPermissionMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
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


    public static final String ID = "id";

    public static final String PERMISSION_ID = "permission_id";

    public static final String MENU_ID = "menu_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
