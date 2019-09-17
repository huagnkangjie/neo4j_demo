package com.example.demo.ows.repository;

import com.example.demo.ows.model.ScoreEntity;
import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<ScoreEntity, Long> {

    /**
     * 根据名称查找
     * @param name  名称
     * @return      对象
     */
    ScoreEntity findByName(String name);

}