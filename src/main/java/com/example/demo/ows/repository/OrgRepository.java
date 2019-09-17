package com.example.demo.ows.repository;

import com.example.demo.ows.model.OrgEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrgRepository extends CrudRepository<OrgEntity, Long> {

    /**
     * 根据名称查找
     * @param name  名称
     * @return      对象
     */
    OrgEntity findByName(String name);
    
}