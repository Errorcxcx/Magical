package com.dadou.item.service;

import com.dadou.item.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryCategoriesByPid(Long pid);

    void saveCategory(Category category);

    void deleteCategory(Long cid);
}
