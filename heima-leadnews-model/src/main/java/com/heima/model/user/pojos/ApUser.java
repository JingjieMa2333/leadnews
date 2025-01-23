package com.heima.model.user.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * APP用户信息表
 * </p>
 *
 * @author itheima
 */
@Data
@TableName("ap_user")
public class ApUser implements Serializable {

    //serialVersionUID的主要作用是标识类的版本，从而在序列化和反序列化过程中保持类的兼容性。
    /*
    序列化是将一个对象转换成字节流，以便存储到文件、数据库，或通过网络传输。
    反序列化是将字节流转换回对象。
    如果类的结构发生了改变，但 serialVersionUID 未改变，则反序列化仍然成功（可能需要处理新增字段的默认值）。
    如果类的结构发生了改变，且 serialVersionUID 不一致，反序列化会抛出异常。
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @TableId：指定字段是数据库主键。
     * value：主键列名。
     * type：主键生成策略（这里是数据库自增）。
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 密码、通信等加密盐
     * password+salt后再进行md5加密，更安全，salt可以是人工输入或者自动随机生成的字符串
     */
    @TableField("salt")
    private String salt;

    /**
     * 用户名
     */
    @TableField("name")
    private String name;

    /**
     * 密码,md5加密
     */
    @TableField("password")
    private String password;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 头像
     */
    @TableField("image")
    private String image;

    /**
     * 0 男
            1 女
            2 未知
     */
    @TableField("sex")
    private Boolean sex;

    /**
     * 0 未
            1 是
     */
    @TableField("is_certification")
    private Boolean certification;

    /**
     * 是否身份认证
     */
    @TableField("is_identity_authentication")
    private Boolean identityAuthentication;

    /**
     * 0正常
            1锁定
     */
    @TableField("status")
    private Boolean status;

    /**
     * 0 普通用户
            1 自媒体人
            2 大V
     */
    @TableField("flag")
    private Short flag;

    /**
     * 注册时间
     */
    @TableField("created_time")
    private Date createdTime;

}