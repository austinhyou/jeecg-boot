package org.jeecg.modules.crm.rate.entity;

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
 * @Description: 費用管理
 * @Author: jeecg-boot
 * @Date:   2020-11-28
 * @Version: V1.0
 */
@Data
@TableName("rate_customer")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="rate_customer对象", description="費用管理")
public class RateCustomer implements Serializable {
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
    private java.lang.String rateNum;
	/**会社名*/
	@Excel(name = "会社名", width = 15)
    @ApiModelProperty(value = "会社名")
    private java.lang.String rateName;
	/**収支日付*/
	@Excel(name = "収支日付", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "収支日付")
    private java.util.Date rateDate;
	/**収支タイプ*/
	@Excel(name = "収支タイプ", width = 15)
    @ApiModelProperty(value = "収支タイプ")
    private java.lang.String rateSyuushitype;
	/**費用タイプ*/
	@Excel(name = "費用タイプ", width = 15)
    @ApiModelProperty(value = "費用タイプ")
    private java.lang.String rateHiyoutype;
	/**総額*/
	@Excel(name = "総額", width = 15)
    @ApiModelProperty(value = "総額")
    private java.lang.Double rateTotal;
	/**詳細内容*/
	@Excel(name = "詳細内容", width = 15)
    @ApiModelProperty(value = "詳細内容")
    private java.lang.String rateThing;
	/**営業員*/
	@Excel(name = "営業員", width = 15)
    @ApiModelProperty(value = "営業員")
    private java.lang.String rateEigyou;
	/**入力時間*/
	@Excel(name = "入力時間", width = 15)
    @ApiModelProperty(value = "入力時間")
    private java.lang.String rateTime;
	/**操作記録*/
	@Excel(name = "操作記録", width = 15)
    @ApiModelProperty(value = "操作記録")
    private java.lang.String rateNote;
}
