package com.example.demo.ows.repository;

import com.example.demo.ows.model.Study71Entity;
import org.springframework.data.repository.CrudRepository;

public interface Study71Repository extends CrudRepository<Study71Entity, Long> {

    /**
     * 根据名称查找
     * @param name  名称
     * @return      对象
     */
    Study71Entity findByName(String name);

}