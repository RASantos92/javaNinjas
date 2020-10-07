package com.ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninjas.models.Ninja;
import com.ninjas.repository.NinjaRepository;

@Service
public class NinjaService {

	private static NinjaRepository ninjaRepo;

	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}

	public Ninja create(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}

	public List<Ninja> getAll() {
		return (List<Ninja>) ninjaRepo.findAll();
	}
}
