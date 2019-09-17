package com.example.demo.ows.repository;

import com.example.demo.ows.model.UnitEntity;
import org.springframework.data.repository.CrudRepository;

public interface UnitRepository extends CrudRepository<UnitEntity, Long> {

    /**
     * 根据名称查找
     * @param name  名称
     * @return      对象
     */
    UnitEntity findByName(String name);

}