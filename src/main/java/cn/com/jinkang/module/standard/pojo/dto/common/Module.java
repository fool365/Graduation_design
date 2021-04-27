package cn.com.jinkang.module.standard.pojo.dto.common;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel("菜单模块")
@Data
@TableName(value = "module")
public class Module {
    @ApiModelProperty("id")
    @TableId(type = IdType.AUTO)
    private long id;
    @ApiModelProperty("模块名称")
    private String module_name;
    @ApiModelProperty("模块编码")
    private String module_bm;
    @ApiModelProperty("是否可用")
    private boolean enabled;
    @ApiModelProperty("排序号")
    private int sort;
    @ApiModelProperty("跳转地址")
    private String router;
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
