package com.dadou.item.service;


import com.dadou.commom.pojo.PageResult;

public interface BrandService {
    PageResult queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);
}
