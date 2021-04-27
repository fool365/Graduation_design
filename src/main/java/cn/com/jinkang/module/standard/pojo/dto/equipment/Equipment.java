package cn.com.jinkang.module.standard.pojo.dto.equipment;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel("工程信息")
@TableName("equipment_information")
public class Equipment {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("id")
    private long id;
    @ApiModelProperty("出厂编号")
    private long factoryNumber;
    @ApiModelProperty("凭证号")
    private long credentialNumber;
    @ApiModelProperty("发票号")
    private long invoiceNumber;

    @ApiModelProperty("设备金额")
    private double equipmentAmount;
    @ApiModelProperty("检定周期")
    private Date verificationCycle;
    @ApiModelProperty("检定单位")
    private String verificationUnit;
    @ApiModelProperty("检定日期")
    private Date verificationDate;
    @ApiModelProperty("保管人")
    private String depository;
    @ApiModelProperty("归属部门")
    private String attributionDepartment;
    @ApiModelProperty("编号")
    private String serialNumber;
    @ApiModelProperty("购买日期")
    private Date purchaseDate;
    @ApiModelProperty("制造厂")
    private String factory;
    @ApiModelProperty("规格型号")
    private String specifications;
    @ApiModelProperty("仪器名称")
    private String instrument_name;
    @ApiModelProperty("创建时间")
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @TableField(fill = FieldFill.INSERT_UPDATE)
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

    public Equipment() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFactoryNumber() {
        return factoryNumber;
    }

    public void setFactoryNumber(long factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    public long getCredentialNumber() {
        return credentialNumber;
    }

    public void setCredentialNumber(long credentialNumber) {
        this.credentialNumber = credentialNumber;
    }

    public long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getEquipmentAmount() {
        return equipmentAmount;
    }

    public void setEquipmentAmount(double equipmentAmount) {
        this.equipmentAmount = equipmentAmount;
    }

    public Date getVerificationCycle() {
        return verificationCycle;
    }

    public void setVerificationCycle(Date verificationCycle) {
        this.verificationCycle = verificationCycle;
    }

    public String getVerificationUnit() {
        return verificationUnit;
    }

    public void setVerificationUnit(String verificationUnit) {
        this.verificationUnit = verificationUnit;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Date verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getDepository() {
        return depository;
    }

    public void setDepository(String depository) {
        this.depository = depository;
    }

    public String getAttributionDepartment() {
        return attributionDepartment;
    }

    public void setAttributionDepartment(String attributionDepartment) {
        this.attributionDepartment = attributionDepartment;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getInstrument_name() {
        return instrument_name;
    }

    public void setInstrument_name(String instrument_name) {
        this.instrument_name = instrument_name;
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
}
