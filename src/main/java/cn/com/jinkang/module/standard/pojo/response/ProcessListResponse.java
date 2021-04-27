package cn.com.jinkang.module.standard.pojo.response;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ProcessListResponse {
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
    @ApiModelProperty("流程状态")
    private int status;

    private String statusName;
}
