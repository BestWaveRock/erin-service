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
 * 用户角色关联表
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@ApiModel("用户角色关联表")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
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


    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String ROLE_ID = "role_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
