package com.erin.base.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@ApiModel("角色表")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
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


    public static final String ID = "id";

    public static final String ROLE_CODE = "role_code";

    public static final String ROLE_NAME = "role_name";

    public static final String ADMIN_FLAG = "admin_flag";

    public static final String CREATE_OPERATOR = "create_operator";

    public static final String CREATE_DATETIME = "create_datetime";

    public static final String UPDATE_OPERATOR = "update_operator";

    public static final String UPDATE_DATETIME = "update_datetime";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
