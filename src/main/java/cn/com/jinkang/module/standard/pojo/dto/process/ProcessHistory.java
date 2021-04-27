package cn.com.jinkang.module.standard.pojo.dto.process;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@ApiModel("流程订单")
@TableName("process_history")
@Data
public class ProcessHistory {
    @ApiModelProperty("id")
    @TableId(type = IdType.AUTO)
    private Long id;
    @ApiModelProperty("流程编号")
    private int approveNumber;

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
    @ApiModelProperty("创建人")
    private String createBy;
    @ApiModelProperty("更改人")
    private String updateBy;
    @ApiModelProperty("是否生成报告")
    private boolean isReport;
    @ApiModelProperty("报告编号")
    private int reportId;
    @ApiModelProperty("报告状态")
    private int status;

}
