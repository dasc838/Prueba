package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Canal;

@Repository
public interface CanalRepo extends CrudRepository<Canal, Integer> {

}
