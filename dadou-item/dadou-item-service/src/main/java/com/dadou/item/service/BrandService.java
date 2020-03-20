package com.dadou.item.service;


import com.dadou.commom.pojo.PageResult;
import com.dadou.item.pojo.Brand;

import java.util.List;

public interface BrandService {
    PageResult queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);

    void saveBrand(Brand brand, List<Long> cids);
}
