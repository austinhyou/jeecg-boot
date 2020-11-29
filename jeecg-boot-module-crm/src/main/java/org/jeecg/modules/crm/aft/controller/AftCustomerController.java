package org.jeecg.modules.crm.aft.controller;

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
import org.jeecg.modules.crm.aft.entity.AftCustomer;
import org.jeecg.modules.crm.aft.service.IAftCustomerService;

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
 * @Description: アフターサービス
 * @Author: jeecg-boot
 * @Date:   2020-11-28
 * @Version: V1.0
 */
@Api(tags="アフターサービス")
@RestController
@RequestMapping("/aft/aftCustomer")
@Slf4j
public class AftCustomerController extends JeecgController<AftCustomer, IAftCustomerService> {
	@Autowired
	private IAftCustomerService aftCustomerService;
	
	/**
	 * 分页列表查询
	 *
	 * @param aftCustomer
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "アフターサービス-分页列表查询")
	@ApiOperation(value="アフターサービス-分页列表查询", notes="アフターサービス-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(AftCustomer aftCustomer,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<AftCustomer> queryWrapper = QueryGenerator.initQueryWrapper(aftCustomer, req.getParameterMap());
		Page<AftCustomer> page = new Page<AftCustomer>(pageNo, pageSize);
		IPage<AftCustomer> pageList = aftCustomerService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param aftCustomer
	 * @return
	 */
	@AutoLog(value = "アフターサービス-添加")
	@ApiOperation(value="アフターサービス-添加", notes="アフターサービス-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody AftCustomer aftCustomer) {
		aftCustomerService.save(aftCustomer);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param aftCustomer
	 * @return
	 */
	@AutoLog(value = "アフターサービス-编辑")
	@ApiOperation(value="アフターサービス-编辑", notes="アフターサービス-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody AftCustomer aftCustomer) {
		aftCustomerService.updateById(aftCustomer);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "アフターサービス-通过id删除")
	@ApiOperation(value="アフターサービス-通过id删除", notes="アフターサービス-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		aftCustomerService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "アフターサービス-批量删除")
	@ApiOperation(value="アフターサービス-批量删除", notes="アフターサービス-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.aftCustomerService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "アフターサービス-通过id查询")
	@ApiOperation(value="アフターサービス-通过id查询", notes="アフターサービス-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		AftCustomer aftCustomer = aftCustomerService.getById(id);
		if(aftCustomer==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(aftCustomer);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param aftCustomer
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, AftCustomer aftCustomer) {
        return super.exportXls(request, aftCustomer, AftCustomer.class, "アフターサービス");
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
        return super.importExcel(request, response, AftCustomer.class);
    }

}
