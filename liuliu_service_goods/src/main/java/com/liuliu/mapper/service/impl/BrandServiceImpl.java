package com.liuliu.mapper.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuliu.goods.IBrandService;
import com.liuliu.mapper.BrandMapper;
import com.liuliu.pojo.goods.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;

    //查询商品列表
    @Override
    public List<Brand> brandList() {
        return brandMapper.selectList(null);
    }

    //根据条件查询 根据name 进行模糊查询 根据首字母进行完全匹配
    @Override
    public List<Brand> brandListByCondition(Map<String, Object> queryMap) {
        return brandMapper.selectList(queryWrapper(queryMap));
    }

    //分页查询所有数据
    @Override
    public IPage<Brand> brandPage(Integer pageNum, Integer pageSize) {
        IPage<Brand> page = new Page<>();
        page = brandMapper.selectPage(page, null);
        return page;
    }

    //根据条件分页查询所有数据
    @Override
    public IPage<Brand> brandPageByCondition(Integer pageNum, Integer pageSize, Map<String, Object> queryMap) {
        IPage<Brand> page = new Page<>(pageNum,pageSize);
        page = brandMapper.selectPage(page, queryWrapper(queryMap));
        return page;
    }

    //根据id查询
    @Override
    public Brand brandbyId(Integer id) {
        return null;
    }

    //添加品牌信息
    @Override
    public Integer saveBrand(Brand brand) {
        return null;
    }

    //修改品牌的信息
    @Override
    public Integer modifyBrand(Brand brand) {
        return null;
    }

    //删除品牌的信息
    @Override
    public Integer removeBrand(Integer id) {
        return null;
    }

    private QueryWrapper<Brand> queryWrapper(Map<String, Object> queryMap){
        QueryWrapper<Brand> queryWrapper = null;
        if(queryMap != null){
            queryWrapper = new QueryWrapper<>();
            System.out.println("queryMap不为空！");
            if(!StringUtils.isEmpty(queryMap.get("name"))){
                System.out.println("name不为空！");
                queryWrapper.like("name", queryMap.get("name"));
            }
            if(!StringUtils.isEmpty(queryMap.get("letter"))){
                System.out.println("letter不为空！");
                queryWrapper.eq("letter", queryMap.get("letter"));
            }
        }
        return queryWrapper;
    }
}
