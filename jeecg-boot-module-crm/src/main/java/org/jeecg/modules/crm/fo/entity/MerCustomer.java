package org.jeecg.modules.crm.fo.entity;

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
 * @Description: 注文フォローマスタ
 * @Author: jeecg-boot
 * @Date:   2020-11-28
 * @Version: V1.0
 */
@Data
@TableName("mer_customer")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="mer_customer对象", description="注文フォローマスタ")
public class MerCustomer implements Serializable {
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
	/**注文フォローID*/
	@Excel(name = "注文フォローID", width = 15)
    @ApiModelProperty(value = "注文フォローID")
    private java.lang.Integer merId;
	/**会社名*/
	@Excel(name = "会社名", width = 15)
    @ApiModelProperty(value = "会社名")
    private java.lang.String merName;
	/**登録時間*/
	@Excel(name = "登録時間", width = 15)
    @ApiModelProperty(value = "登録時間")
    private java.lang.String merTime;
	/**次回連絡*/
	@Excel(name = "次回連絡", width = 15)
    @ApiModelProperty(value = "次回連絡")
    private java.lang.String merDate;
	/**詳細内容*/
	@Excel(name = "詳細内容", width = 15)
    @ApiModelProperty(value = "詳細内容")
    private java.lang.String merThing;
	/**フォロー対象*/
	@Excel(name = "フォロー対象", width = 15)
    @ApiModelProperty(value = "フォロー対象")
    private java.lang.String merPerson;
	/**操作記録*/
	@Excel(name = "操作記録", width = 15)
    @ApiModelProperty(value = "操作記録")
    private java.lang.String merNote;
}
