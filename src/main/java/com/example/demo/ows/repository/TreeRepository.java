package com.example.demo.ows.repository;

import com.example.demo.ows.model.TreeEntity;
import org.springframework.data.repository.CrudRepository;

public interface TreeRepository extends CrudRepository<TreeEntity, Long> {

    /**
     * 根据名称查找
     * @param name  名称
     * @return      对象
     */
    TreeEntity findByName(String name);

}