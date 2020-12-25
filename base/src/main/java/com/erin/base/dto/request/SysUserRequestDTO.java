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
 * 用户表请求类
 * </p>
 *
 * @author ljx
 * @since 2020-12-25
 */
@ApiModel("用户表请求类")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
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
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String headImg;
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
