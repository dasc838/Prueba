package com.example.demo.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Distribuidor;
@Repository
public interface DistribuidorRepo extends CrudRepository<Distribuidor, Integer> {
		
}
