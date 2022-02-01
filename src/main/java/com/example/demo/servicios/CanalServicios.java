package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfacesService.ICService;
import com.example.demo.modelo.Canal;
import com.example.demo.repo.CanalRepo;

@Service
public class CanalServicios implements ICService {
	@Autowired
	private CanalRepo datos;

	@Override
	public List<Canal> listarCanal() {
		return (List<Canal>)datos.findAll();
	}

	@Override
	public Optional<Canal> listarCodigoCanal(int codigo_canal) {
		return datos.findById(codigo_canal);
	}

	@Override
	public Canal saveCanal(Canal canal) {
		datos.save(canal);
		return canal;
	}

	@Override
	public void deleteCanal(int codigo_canal) {
		datos.deleteById(codigo_canal);
		
	}
	
}
