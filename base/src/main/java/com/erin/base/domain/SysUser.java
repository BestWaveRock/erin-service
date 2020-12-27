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
 * 用户表
 * </p>
 *
 * @author ljx
 * @since 2020-12-27
 */
@ApiModel("用户表")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    private String account;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String psword;
    /**
     * 名字
     */
    @ApiModelProperty(value = "名字")
    private String name;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String headImg;
    /**
     * 是否启用(0启用，1不启用)
     */
    @ApiModelProperty(value = "是否启用(0启用，1不启用)")
    private Integer activeFlag;
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

    public static final String ACCOUNT = "account";

    public static final String PSWORD = "psword";

    public static final String NAME = "name";

    public static final String PHONE = "phone";

    public static final String EMAIL = "email";

    public static final String HEAD_IMG = "head_img";

    public static final String ACTIVE_FLAG = "active_flag";

    public static final String CREATE_OPERATOR = "create_operator";

    public static final String CREATE_DATETIME = "create_datetime";

    public static final String UPDATE_OPERATOR = "update_operator";

    public static final String UPDATE_DATETIME = "update_datetime";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
