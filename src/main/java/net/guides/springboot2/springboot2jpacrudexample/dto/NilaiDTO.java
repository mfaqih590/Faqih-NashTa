package net.guides.springboot2.springboot2jpacrudexample.dto;

import lombok.Data;

@Data
public class NilaiDTO {
	private long idmahasiswa;
	private long idmatkul;
	private Integer nilai;
	private String keterangan;
//Relasi
	private String nama;
	private String mataKuliah;
}
