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
 * 角色权限关联表
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@ApiModel("角色权限关联表")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRolePermission extends Model<SysRolePermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private Long roleId;
    /**
     * 权限ID
     */
    @ApiModelProperty(value = "权限ID")
    private Long permissionId;


    public static final String ID = "id";

    public static final String ROLE_ID = "role_id";

    public static final String PERMISSION_ID = "permission_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
