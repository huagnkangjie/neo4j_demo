package com.example.demo.ows.repository;

import com.example.demo.ows.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    /**
     * 根据名称查找
     * @param name  名称
     * @return      对象
     */
    UserEntity findByName(String name);

}