package org.jeecg.modules.crm.aft.entity;

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
 * @Description: アフターサービス
 * @Author: jeecg-boot
 * @Date:   2020-11-28
 * @Version: V1.0
 */
@Data
@TableName("aft_customer")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="aft_customer对象", description="アフターサービス")
public class AftCustomer implements Serializable {
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
    private java.lang.String aftNum;
	/**会社名*/
	@Excel(name = "会社名", width = 15)
    @ApiModelProperty(value = "会社名")
    private java.lang.String aftName;
	/**解決要否*/
	@Excel(name = "解決要否", width = 15)
    @ApiModelProperty(value = "解決要否")
    private java.lang.String atfYouhi;
	/**フィードバック*/
	@Excel(name = "フィードバック", width = 15)
    @ApiModelProperty(value = "フィードバック")
    private java.lang.String aftFeedback;
	/**連絡先*/
	@Excel(name = "連絡先", width = 15)
    @ApiModelProperty(value = "連絡先")
    private java.lang.String aftPerson;
	/**フィードバック日付*/
	@Excel(name = "フィードバック日付", width = 15)
    @ApiModelProperty(value = "フィードバック日付")
    private java.lang.String aftDate;
	/**処理*/
	@Excel(name = "処理", width = 15)
    @ApiModelProperty(value = "処理")
    private java.lang.String aftCare;
	/**操作記録*/
	@Excel(name = "操作記録", width = 15)
    @ApiModelProperty(value = "操作記録")
    private java.lang.String aftNote;
}
