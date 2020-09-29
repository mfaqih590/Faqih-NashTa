package net.guides.springboot2.springboot2jpacrudexample.service;

import org.springframework.stereotype.Service;

import net.guides.springboot2.springboot2jpacrudexample.dto.NilaiDTO;
import net.guides.springboot2.springboot2jpacrudexample.model.Nilai;

@Service
public class NilaiService {
	
	public NilaiDTO transformToDto(Nilai nilai) {
		NilaiDTO nilaiDTO = new NilaiDTO();
		
		nilaiDTO.setIdmatkul(nilai.getIdmatkul());
		nilaiDTO.setIdmahasiswa(nilai.getIdmahasiswa());
		nilaiDTO.setNama(nilai.getMhs().getNama());
		nilaiDTO.setMataKuliah(nilai.getMatkul().getMataKuliah());
		nilaiDTO.setKeterangan(nilai.getKeterangan());
		nilaiDTO.setNilai(nilai.getNilai());
		return nilaiDTO;
	}

}
