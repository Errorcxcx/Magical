package com.dadou.item.mapper;

import com.dadou.item.pojo.Brand;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface BrandMapper extends Mapper<Brand>{

    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) values (#{cid}, #{bid})")
    void insertCategoryAndBrand(@Param("cid") Long cid,@Param("bid") Long id);
}
