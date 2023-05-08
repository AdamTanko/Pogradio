package sk.marai.radio.model;

import javax.persistence.*;

@Entity
public class Musorvezeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nev;
	private String leiras;
	private String kep;
	
	public Musorvezeto() {
		
	}
	
	public Musorvezeto(String nev, String leiras, String kep) {
		this.nev = nev;
		this.leiras = leiras;
		this.kep = kep;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	
	public String getLeiras() {
		return leiras;
	}
	public void setLeiras(String leiras) {
		this.leiras = leiras;
	}
	
	public String getKep() {
		return kep;
	}
	public void setKep(String kep) {
		this.kep = kep;
	}
	
	
}
