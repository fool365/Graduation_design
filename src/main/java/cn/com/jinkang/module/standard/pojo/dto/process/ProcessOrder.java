package cn.com.jinkang.module.standard.pojo.dto.process;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@ApiModel("流程订单")
@TableName("process_order")
@Data
public class ProcessOrder {
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
    @ApiModelProperty("报告编号")
    @TableField(exist = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getApproveNumber() {
        return approveNumber;
    }

    public void setApproveNumber(int approveNumber) {
        this.approveNumber = approveNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public boolean isReport() {
        return isReport;
    }

    public void setReport(boolean report) {
        isReport = report;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ProcessOrder() {
        super();
    }
}
