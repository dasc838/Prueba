package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Producto;

@Repository
public interface ProductoRepo extends CrudRepository<Producto, Integer> {

}
