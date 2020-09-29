package net.guides.springboot2.springboot2jpacrudexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import net.guides.springboot2.springboot2jpacrudexample.model.MataKuliah;
import net.guides.springboot2.springboot2jpacrudexample.repository.MataKuliahRepository;

@RestController
@RequestMapping("/nashta/v1")
public class MataKuliahController {
	@Autowired
	private MataKuliahRepository matkulRepo;
	
	@GetMapping("/mataKuliah")
	public List<MataKuliah> getAllMatkul() {
		return matkulRepo.findAll();
	}
}
