package com.example.demo.interfacesService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Distribuidor;

public interface IDService {
	public List<Distribuidor>listarDistribuidor();
	public Optional<Distribuidor>listarCodigoDis(int codigo_dis);
	public Distribuidor saveDistribuidor(Distribuidor distribuidor);
	public void deleteDistribuidor(int codigo_dis);
	
}
