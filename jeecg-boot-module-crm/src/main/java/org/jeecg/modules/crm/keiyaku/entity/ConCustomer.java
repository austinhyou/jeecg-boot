package org.jeecg.modules.crm.keiyaku.entity;

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
 * @Description: 契約情報
 * @Author: jeecg-boot
 * @Date:   2020-11-28
 * @Version: V1.0
 */
@Data
@TableName("con_customer")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="con_customer对象", description="契約情報")
public class ConCustomer implements Serializable {
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
    private java.lang.String conNum;
	/**会社名*/
	@Excel(name = "会社名", width = 15)
    @ApiModelProperty(value = "会社名")
    private java.lang.String conName;
	/**契約名*/
	@Excel(name = "契約名", width = 15)
    @ApiModelProperty(value = "契約名")
    private java.lang.String conContract;
	/**開始時間*/
	@Excel(name = "開始時間", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "開始時間")
    private java.util.Date conStartdate;
	/**終了時間*/
	@Excel(name = "終了時間", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "終了時間")
    private java.util.Date conFindate;
	/**総額*/
	@Excel(name = "総額", width = 15)
    @ApiModelProperty(value = "総額")
    private java.lang.String conTotal;
	/**支払完了*/
	@Excel(name = "支払完了", width = 15)
    @ApiModelProperty(value = "支払完了")
    private java.lang.String conAr;
	/**掛金*/
	@Excel(name = "掛金", width = 15)
    @ApiModelProperty(value = "掛金")
    private java.lang.String conDebt;
	/**契約状況*/
	@Excel(name = "契約状況", width = 15)
    @ApiModelProperty(value = "契約状況")
    private java.lang.String conCondition;
	/**審査*/
	@Excel(name = "審査", width = 15)
    @ApiModelProperty(value = "審査")
    private java.lang.String conReview;
	/**入力時間*/
	@Excel(name = "入力時間", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "入力時間")
    private java.util.Date conStarttime;
	/**操作記録*/
	@Excel(name = "操作記録", width = 15)
    @ApiModelProperty(value = "操作記録")
    private java.lang.String conNote;
}
