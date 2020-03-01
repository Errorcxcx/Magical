package com.dadou.item.controller;

import com.dadou.item.pojo.Category;
import com.dadou.item.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;
    /**
     * 根据父节点id查询子节点
     * @param pid
     * @return
     */

    @GetMapping("/list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam(value = "pid", defaultValue = "0") Long pid) {
        if (pid == null || pid < 0) {
            //400:参数不合法
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().build();
        }
        List<Category> categories = this.categoryServiceImpl.queryCategoriesByPid(pid);
        if (CollectionUtils.isEmpty(categories)) {
            //404: 资源未找到
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.notFound().build();
        }
        //200: 查询成功
        return ResponseEntity.ok(categories);

    }


     /**
      *
      *
      */
     @PostMapping
    public ResponseEntity<Void> saveCategory(Category category){
         this.categoryServiceImpl.saveCategory(category);
         System.out.println(category.getId()+"controller");
         return ResponseEntity.status(HttpStatus.CREATED).build();
     }
    /**
     * 删除
     * @return
     */
    @DeleteMapping("/cid/{cid}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("cid") Long id){
        this.categoryServiceImpl.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

