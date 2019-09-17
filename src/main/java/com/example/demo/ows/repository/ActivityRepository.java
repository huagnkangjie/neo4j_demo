package com.example.demo.ows.repository;

import com.example.demo.ows.model.ActivityEntity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<ActivityEntity, Long> {

    /**
     * 根据名称查找
     * @param name  名称
     * @return      对象
     */
    ActivityEntity findByName(String name);

}