package org.jeecg.modules.crm.cyu.entity;

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
 * @Description: 注文履歴
 * @Author: jeecg-boot
 * @Date:   2020-11-28
 * @Version: V1.0
 */
@Data
@TableName("ord_customer")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ord_customer对象", description="注文履歴")
public class OrdCustomer implements Serializable {
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
	/**番号*/
	@Excel(name = "番号", width = 15)
    @ApiModelProperty(value = "番号")
    private java.lang.Integer ordId;
	/**会社名*/
	@Excel(name = "会社名", width = 15)
    @ApiModelProperty(value = "会社名")
    private java.lang.String ordName;
	/**注文番号*/
	@Excel(name = "注文番号", width = 15)
    @ApiModelProperty(value = "注文番号")
    private java.lang.Integer ordNum;
	/**連絡先*/
	@Excel(name = "連絡先", width = 15)
    @ApiModelProperty(value = "連絡先")
    private java.lang.String ordPerson;
	/**注文日付*/
	@Excel(name = "注文日付", width = 15)
    @ApiModelProperty(value = "注文日付")
    private java.lang.String ordDate;
	/**終了日*/
	@Excel(name = "終了日", width = 15)
    @ApiModelProperty(value = "終了日")
    private java.lang.String ordFdate;
	/**前渡金*/
	@Excel(name = "前渡金", width = 15)
    @ApiModelProperty(value = "前渡金")
    private java.lang.String ordDeposit;
	/**注文金額*/
	@Excel(name = "注文金額", width = 15)
    @ApiModelProperty(value = "注文金額")
    private java.lang.String ordSum;
	/**注文状況*/
	@Excel(name = "注文状況", width = 15)
    @ApiModelProperty(value = "注文状況")
    private java.lang.String ordState;
	/**営業員*/
	@Excel(name = "営業員", width = 15)
    @ApiModelProperty(value = "営業員")
    private java.lang.String ordAssistant;
	/**入力時間*/
	@Excel(name = "入力時間", width = 15)
    @ApiModelProperty(value = "入力時間")
    private java.lang.String ordIntime;
	/**操作記録*/
	@Excel(name = "操作記録", width = 15)
    @ApiModelProperty(value = "操作記録")
    private java.lang.String ordNote;
}
