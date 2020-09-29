package net.guides.springboot2.springboot2jpacrudexample.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.guides.springboot2.springboot2jpacrudexample.helper.UploadHelper;
import net.guides.springboot2.springboot2jpacrudexample.model.Mahasiswa;
import net.guides.springboot2.springboot2jpacrudexample.repository.MahasiswaRepository;

@Service
public class ExcelService {
	
	@Autowired
	private MahasiswaRepository MahasiswaRepo;
	
	public void save(MultipartFile file) {
		try {
			List<Mahasiswa> mahasiswa = UploadHelper.excelToTutorials(file.getInputStream());
			MahasiswaRepo.saveAll(mahasiswa);
		} catch (IOException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	}
	
	public List<Mahasiswa> getAllMhs() {
		return MahasiswaRepo.findAll();
	}

}
