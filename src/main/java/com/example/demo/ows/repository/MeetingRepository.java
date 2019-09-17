package com.example.demo.ows.repository;

import com.example.demo.ows.model.MeetingEntity;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<MeetingEntity, Long> {

    /**
     * 根据名称查找
     * @param name  名称
     * @return      对象
     */
    MeetingEntity findByName(String name);

}