package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfacesService.IDService;
import com.example.demo.modelo.Distribuidor;
import com.example.demo.repo.DistribuidorRepo;

@Service
public class DisttribuidorServicios implements IDService{
	@Autowired
	private DistribuidorRepo datos;
	@Override
	public List<Distribuidor> listarDistribuidor() {
		return (List<Distribuidor>)datos.findAll();
	}

	@Override
	public Optional<Distribuidor> listarCodigoDis(int codigo_dis) {
		return datos.findById(codigo_dis);
	}

	@Override
	public Distribuidor saveDistribuidor(Distribuidor distribuidor) {
		datos.save(distribuidor);
		return distribuidor;
	}

	@Override
	public void deleteDistribuidor(int codigo_dis) {
		datos.deleteById(codigo_dis);
		
	}
	
}
