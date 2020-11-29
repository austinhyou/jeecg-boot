package org.jeecg.modules.crm.ko.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 顧客情報
 * @Author: jeecg-boot
 * @Date:   2020-11-28
 * @Version: V1.0
 */
@Data
@TableName("koukyaku")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="koukyaku对象", description="顧客情報")
public class Koukyaku implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**顧客ID*/
	@Excel(name = "顧客ID", width = 15)
    @ApiModelProperty(value = "顧客ID")
    private java.lang.Integer cusId;
	/**顧客名*/
	@Excel(name = "顧客名", width = 15)
    @ApiModelProperty(value = "顧客名")
    private java.lang.String cusName;
	/**会社住所*/
	@Excel(name = "会社住所", width = 15)
    @ApiModelProperty(value = "会社住所")
    private java.lang.String cusAddress;
	/**連絡先*/
	@Excel(name = "連絡先", width = 15)
    @ApiModelProperty(value = "連絡先")
    private java.lang.String cusPername;
	/**電話番号*/
	@Excel(name = "電話番号", width = 15)
    @ApiModelProperty(value = "電話番号")
    private java.lang.String cusPhonenum;
	/**項目分類*/
	@Excel(name = "項目分類", width = 15)
    @ApiModelProperty(value = "項目分類")
    private java.lang.String cusSort;
	/**顧客級別*/
	@Excel(name = "顧客級別", width = 15)
    @ApiModelProperty(value = "顧客級別")
    private java.lang.String cusSen;
	/**顧客タイプ*/
	@Excel(name = "顧客タイプ", width = 15)
    @ApiModelProperty(value = "顧客タイプ")
    private java.lang.String cusType;
	/**項目内容*/
	@Excel(name = "項目内容", width = 15)
    @ApiModelProperty(value = "項目内容")
    private java.lang.String cusHeadline;
	/**備考*/
	@Excel(name = "備考", width = 15)
    @ApiModelProperty(value = "備考")
    private java.lang.String cusMemos;
	/**操作記録*/
	@Excel(name = "操作記録", width = 15)
    @ApiModelProperty(value = "操作記録")
    private java.lang.String cusNote;
}
