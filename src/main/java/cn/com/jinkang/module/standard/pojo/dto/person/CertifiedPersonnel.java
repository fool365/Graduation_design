package cn.com.jinkang.module.standard.pojo.dto.person;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel("用户")
@Data
@TableName(value = "certified_personnel")
public class CertifiedPersonnel {
    @ApiModelProperty("id")
    @TableId(type = IdType.AUTO)
    private Long id;
    @ApiModelProperty("持证人员编号")
    private String serialNumber;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("级别")
    private String level;
    @ApiModelProperty("专业")
    private String professional;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("入职时间")
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date hiredate;
    @ApiModelProperty("初次领证时间")
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date cardTime;
    @ApiModelProperty("到期时间")
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date dueTime;
    @ApiModelProperty("起始时间")
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date startTime;
    @ApiModelProperty("是否注册(0为没有，1为注册)")
    private Boolean registered;
    @ApiModelProperty("注册时间")
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date registrationTime;
    @ApiModelProperty("离职时间")
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date departureTime;
    @ApiModelProperty("创建时间")
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @ApiModelProperty("更新时间")
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
