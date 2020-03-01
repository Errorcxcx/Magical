package com.dadou.item.service.impl;

import com.dadou.item.mapper.CategoryMapper;
import com.dadou.item.pojo.Category;
import com.dadou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {



    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * 根据父节点查询子节点
     * @param pid
     * @return
     */

    @Override
    public List<Category> queryCategoriesByPid(Long pid) {
        Category record = new Category();
        record.setParentId(pid);
        return this.categoryMapper.select(record);
    }

    @Override
    public void saveCategory(Category category) {
        /**
         * 将本节点插入到数据库中
         * 将此category的父节点的isParent设为true
         */

        //1.首先置id为null
        category.setId(null);
        System.out.println(category.getId()+"111");
        //2.保存
        this.categoryMapper.insert(category);
        System.out.println(category.getId()+"222");

        //3.修改父节点
        Category parent = new Category();
        parent.setId(category.getParentId());
        parent.setIsParent(true);
        this.categoryMapper.updateByPrimaryKeySelective(parent);

    }

    @Override
    public void deleteCategory(Long cid) {
        Category category = new Category();
        category.setId(cid);
        this.categoryMapper.delete(category);
    }
}
