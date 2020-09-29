package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@IdClass(MataKuliahKey.class)
@Table(name = "mata_kuliah")
public class MataKuliah {
	@Id
	private long id;
	@Id
	private long idmatkul;
	private String mataKuliah;
	private long idmahasiswa;

}
