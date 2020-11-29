package org.jeecg.modules.crm.ko.controller;

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
import org.jeecg.modules.crm.ko.entity.Koukyaku;
import org.jeecg.modules.crm.ko.service.IKoukyakuService;

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
 * @Description: 顧客情報
 * @Author: jeecg-boot
 * @Date:   2020-11-28
 * @Version: V1.0
 */
@Api(tags="顧客情報")
@RestController
@RequestMapping("/ko/koukyaku")
@Slf4j
public class KoukyakuController extends JeecgController<Koukyaku, IKoukyakuService> {
	@Autowired
	private IKoukyakuService koukyakuService;
	
	/**
	 * 分页列表查询
	 *
	 * @param koukyaku
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "顧客情報-分页列表查询")
	@ApiOperation(value="顧客情報-分页列表查询", notes="顧客情報-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(Koukyaku koukyaku,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Koukyaku> queryWrapper = QueryGenerator.initQueryWrapper(koukyaku, req.getParameterMap());
		Page<Koukyaku> page = new Page<Koukyaku>(pageNo, pageSize);
		IPage<Koukyaku> pageList = koukyakuService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param koukyaku
	 * @return
	 */
	@AutoLog(value = "顧客情報-添加")
	@ApiOperation(value="顧客情報-添加", notes="顧客情報-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody Koukyaku koukyaku) {
		koukyakuService.save(koukyaku);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param koukyaku
	 * @return
	 */
	@AutoLog(value = "顧客情報-编辑")
	@ApiOperation(value="顧客情報-编辑", notes="顧客情報-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody Koukyaku koukyaku) {
		koukyakuService.updateById(koukyaku);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "顧客情報-通过id删除")
	@ApiOperation(value="顧客情報-通过id删除", notes="顧客情報-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		koukyakuService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "顧客情報-批量删除")
	@ApiOperation(value="顧客情報-批量删除", notes="顧客情報-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.koukyakuService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "顧客情報-通过id查询")
	@ApiOperation(value="顧客情報-通过id查询", notes="顧客情報-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		Koukyaku koukyaku = koukyakuService.getById(id);
		if(koukyaku==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(koukyaku);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param koukyaku
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Koukyaku koukyaku) {
        return super.exportXls(request, koukyaku, Koukyaku.class, "顧客情報");
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
        return super.importExcel(request, response, Koukyaku.class);
    }

}
