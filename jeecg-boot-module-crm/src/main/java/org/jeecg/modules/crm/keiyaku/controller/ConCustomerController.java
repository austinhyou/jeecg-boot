package org.jeecg.modules.crm.keiyaku.controller;

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
import org.jeecg.modules.crm.keiyaku.entity.ConCustomer;
import org.jeecg.modules.crm.keiyaku.service.IConCustomerService;

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
 * @Description: 契約情報
 * @Author: jeecg-boot
 * @Date:   2020-11-28
 * @Version: V1.0
 */
@Api(tags="契約情報")
@RestController
@RequestMapping("/keiyaku/conCustomer")
@Slf4j
public class ConCustomerController extends JeecgController<ConCustomer, IConCustomerService> {
	@Autowired
	private IConCustomerService conCustomerService;
	
	/**
	 * 分页列表查询
	 *
	 * @param conCustomer
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "契約情報-分页列表查询")
	@ApiOperation(value="契約情報-分页列表查询", notes="契約情報-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(ConCustomer conCustomer,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<ConCustomer> queryWrapper = QueryGenerator.initQueryWrapper(conCustomer, req.getParameterMap());
		Page<ConCustomer> page = new Page<ConCustomer>(pageNo, pageSize);
		IPage<ConCustomer> pageList = conCustomerService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param conCustomer
	 * @return
	 */
	@AutoLog(value = "契約情報-添加")
	@ApiOperation(value="契約情報-添加", notes="契約情報-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody ConCustomer conCustomer) {
		conCustomerService.save(conCustomer);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param conCustomer
	 * @return
	 */
	@AutoLog(value = "契約情報-编辑")
	@ApiOperation(value="契約情報-编辑", notes="契約情報-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody ConCustomer conCustomer) {
		conCustomerService.updateById(conCustomer);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "契約情報-通过id删除")
	@ApiOperation(value="契約情報-通过id删除", notes="契約情報-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		conCustomerService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "契約情報-批量删除")
	@ApiOperation(value="契約情報-批量删除", notes="契約情報-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.conCustomerService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "契約情報-通过id查询")
	@ApiOperation(value="契約情報-通过id查询", notes="契約情報-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		ConCustomer conCustomer = conCustomerService.getById(id);
		if(conCustomer==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(conCustomer);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param conCustomer
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ConCustomer conCustomer) {
        return super.exportXls(request, conCustomer, ConCustomer.class, "契約情報");
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
        return super.importExcel(request, response, ConCustomer.class);
    }

}
