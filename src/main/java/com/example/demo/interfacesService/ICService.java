package com.example.demo.interfacesService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Canal;


public interface ICService {
	public List<Canal>listarCanal();
	public Optional<Canal>listarCodigoCanal(int codigo_canal);
	public Canal saveCanal(Canal canal);
	public void deleteCanal(int codigo_canal);
}
