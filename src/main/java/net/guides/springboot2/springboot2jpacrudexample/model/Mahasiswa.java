package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(MahasiswaKey.class)
@Table(name = "mahasiswa")
public class Mahasiswa {
	
	@Id
	@Column(name ="id")
	private long id;
	
	@Id
	@Column(name="idmahasiswa")
	private long idmahasiswa;
	
	@Column(name="nama")
	private String nama;
	
	@Column(name="alamat")
	private String alamat;

	public Mahasiswa() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdmahasiswa() {
		return idmahasiswa;
	}
	public void setIdmahasiswa(long id_mahasiswa) {
		this.idmahasiswa = id_mahasiswa;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	@Override
	public String toString() {
		return "Mahasiswa [id=" + id + ", idmahasiswa=" + idmahasiswa + ", nama=" + nama + ", alamat=" + alamat + "]";
	}
	public Mahasiswa(long id, long idmahasiswa, String nama, String alamat) {
		super();
		this.nama = nama;
		this.alamat = alamat;
	}
	
	
	
}
