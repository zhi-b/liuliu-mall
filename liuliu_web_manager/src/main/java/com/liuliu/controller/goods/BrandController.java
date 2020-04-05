package com.liuliu.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liuliu.entity.ResponseData;
import com.liuliu.goods.IBrandService;
import com.liuliu.pojo.goods.Brand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "商品品牌管理接口")
@RestController
@RequestMapping("/goods")
public class BrandController {
    @Reference
    private IBrandService brandService;

    @ApiOperation(value = "品牌列表",notes = "获取所有品牌")
    @GetMapping("/brandList")
    public ResponseData<Brand> brandList(){
        List<Brand> brandList = brandService.brandList();
        if (brandList != null){
            return ResponseData.success().putDataVal("brandList", brandList);
        }else {
            return ResponseData.serverError();
        }
    }

    @PostMapping("/brandQuery")
    @ApiOperation(value = "条件查询品牌列表",notes = "根据条件查询品牌列表信息")
    @ApiImplicitParam(value = "查询条件" ,name = "queryMap",required = false,dataType = "object",paramType = "body")
    public ResponseData<Brand> brandListQuery(@RequestBody Map<String,Object> queryMap){
        List<Brand> brandList = brandService.brandListByCondition(queryMap);
        if(brandList != null){
            return ResponseData.success().putDataVal("brandList", brandList);
        }else {
            return ResponseData.serverError();
        }
    }

    @GetMapping("/brandPage")
    @ApiOperation(value = "分页查询",notes = "分页查询所有品牌信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页数",name = "pagenum",required = false,dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(value = "每页条数",name = "pagesize",required = false,dataType = "Integer",paramType = "query")
    })
    public ResponseData<Brand> brandPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        IPage<Brand> brandPage = brandService.brandPage(pageNum, pageSize);
        return ResponseData.success().putDataVal("total", brandPage.getTotal())
                                     .putDataVal("pages", brandPage.getPages())
                                     .putDataVal("brandList", brandPage.getRecords());
    }


    @PostMapping("/brandPage")
    @ApiOperation(value = "分页条件查询",notes = "根据条件分页查询品牌信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页数",name = "pagenum",required = false,dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(value = "每页条数",name = "pagesize",required = false,dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(value = "查询条件",name = "queryMap",required = false,dataType = "Map",paramType = "body")
    })
    public ResponseData<Brand> brandPageList(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestBody Map<String,Object> queryMap){
        IPage<Brand> brandPage = brandService.brandPageByCondition(pageNum, pageSize, queryMap);
        return ResponseData.success().putDataVal("total", brandPage.getTotal())
                .putDataVal("pages", brandPage.getPages())
                .putDataVal("brandList", brandPage.getRecords());
    }
}
