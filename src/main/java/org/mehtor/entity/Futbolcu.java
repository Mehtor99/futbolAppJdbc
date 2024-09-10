package org.mehtor.entity;

import java.time.LocalDate;
import java.util.Date;

public class Futbolcu extends BaseEntity {
	private Integer id;
	private Integer takimId;
	private String ad;
	private String soyad;
	private LocalDate dtarih;
	private String pozisyon;
	
	public Futbolcu() {
	}
	
	public Futbolcu(Integer id, Integer takimId, String ad, String soyad, LocalDate dtarih, String pozisyon) {
		this.id = id;
		this.takimId = takimId;
		this.ad = ad;
		this.soyad = soyad;
		this.dtarih = dtarih;
		this.pozisyon = pozisyon;
	}
	
	public Futbolcu(Integer takimId, String ad, String soyad, LocalDate dtarih, String pozisyon) {
		this.takimId = takimId;
		this.ad = ad;
		this.soyad = soyad;
		this.dtarih = dtarih;
		this.pozisyon = pozisyon;
	}
	
	public Futbolcu( Integer id, Integer takimId, String ad, String soyad, LocalDate dtarih,
	                String pozisyon,Integer state) {
		super(state);
		this.id = id;
		this.takimId = takimId;
		this.ad = ad;
		this.soyad = soyad;
		this.dtarih = dtarih;
		this.pozisyon = pozisyon;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getTakimId() {
		return takimId;
	}
	
	public void setTakimId(Integer takimId) {
		this.takimId = takimId;
	}
	
	public String getAd() {
		return ad;
	}
	
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	public String getSoyad() {
		return soyad;
	}
	
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	public LocalDate getDtarih() {
		return dtarih;
	}
	
	public void setDtarih(LocalDate dtarih) {
		this.dtarih = dtarih;
	}
	
	public String getPozisyon() {
		return pozisyon;
	}
	
	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}
	
	@Override
	public String toString() {
		return "Futbolcu{" + "id=" + getId() + ", takimId=" + getTakimId() + ", ad='" + getAd() + '\'' + ", soyad='" + getSoyad() + '\'' + ", dtarih=" + getDtarih() + ", pozisyon='" + getPozisyon() + '\'' + ", state=" + getState() + '}';
	}
}