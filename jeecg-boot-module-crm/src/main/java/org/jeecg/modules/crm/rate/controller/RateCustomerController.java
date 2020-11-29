package org.jeecg.modules.crm.rate.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.crm.rate.entity.RateCustomer;
import org.jeecg.modules.crm.rate.service.IRateCustomerService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 費用管理
 * @Author: jeecg-boot
 * @Date:   2020-11-28
 * @Version: V1.0
 */
@Api(tags="費用管理")
@RestController
@RequestMapping("/rate/rateCustomer")
@Slf4j
public class RateCustomerController extends JeecgController<RateCustomer, IRateCustomerService> {
	@Autowired
	private IRateCustomerService rateCustomerService;
	
	/**
	 * 分页列表查询
	 *
	 * @param rateCustomer
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "費用管理-分页列表查询")
	@ApiOperation(value="費用管理-分页列表查询", notes="費用管理-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(RateCustomer rateCustomer,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<RateCustomer> queryWrapper = QueryGenerator.initQueryWrapper(rateCustomer, req.getParameterMap());
		Page<RateCustomer> page = new Page<RateCustomer>(pageNo, pageSize);
		IPage<RateCustomer> pageList = rateCustomerService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param rateCustomer
	 * @return
	 */
	@AutoLog(value = "費用管理-添加")
	@ApiOperation(value="費用管理-添加", notes="費用管理-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody RateCustomer rateCustomer) {
		rateCustomerService.save(rateCustomer);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param rateCustomer
	 * @return
	 */
	@AutoLog(value = "費用管理-编辑")
	@ApiOperation(value="費用管理-编辑", notes="費用管理-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody RateCustomer rateCustomer) {
		rateCustomerService.updateById(rateCustomer);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "費用管理-通过id删除")
	@ApiOperation(value="費用管理-通过id删除", notes="費用管理-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		rateCustomerService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "費用管理-批量删除")
	@ApiOperation(value="費用管理-批量删除", notes="費用管理-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.rateCustomerService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "費用管理-通过id查询")
	@ApiOperation(value="費用管理-通过id查询", notes="費用管理-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		RateCustomer rateCustomer = rateCustomerService.getById(id);
		if(rateCustomer==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(rateCustomer);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param rateCustomer
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, RateCustomer rateCustomer) {
        return super.exportXls(request, rateCustomer, RateCustomer.class, "費用管理");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, RateCustomer.class);
    }

}
