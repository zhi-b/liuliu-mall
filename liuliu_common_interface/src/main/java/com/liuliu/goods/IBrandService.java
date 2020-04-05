package com.liuliu.goods;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liuliu.pojo.goods.Brand;

import java.util.List;
import java.util.Map;

public interface IBrandService {
    //品牌信息列表
    List<Brand> brandList();
    //根据条件查询 根据name 进行模糊查询 根据首字母进行完全匹配
//    List<Brand> brandListByCondition(String name,String letter);
    List<Brand> brandListByCondition(Map<String,Object> queryMap);
    //分页查询所有数据
    IPage<Brand> brandPage(Integer pageNum, Integer pageSize);

    //根据条件分页查询所有数据
    IPage<Brand> brandPageByCondition(Integer pageNum,Integer pageSize,Map<String,Object> queryMap);
    //根据id查询
    Brand brandbyId(Integer id);
    //添加品牌信息
    Integer saveBrand(Brand brand);
    //修改品牌的信息
    Integer modifyBrand(Brand brand);
    //删除品牌的信息
    Integer removeBrand(Integer id);
}
