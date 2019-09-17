package com.example.demo.ows.repository;

import com.example.demo.ows.model.LeaderEntity;
import org.springframework.data.repository.CrudRepository;

public interface LeaderRepository extends CrudRepository<LeaderEntity, Long> {

    /**
     * 根据名称查找
     * @param name  名称
     * @return      对象
     */
    LeaderEntity findByName(String name);

}