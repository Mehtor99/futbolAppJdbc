package org.mehtor.entity;

public class Takim extends BaseEntity {
	private Integer id;
	private String takimad;
	private String baskan;
	private Integer kurulusYili;
	private String stadyum;
	private String sehir;
	
	public Takim() {
	}
	
	public Takim(String takimad, String baskan, Integer kurulusYili, String stadyum, String sehir) {
		this.takimad = takimad;
		this.baskan = baskan;
		this.kurulusYili = kurulusYili;
		this.stadyum = stadyum;
		this.sehir = sehir;
	}
	
	public Takim(int id, String takimad, String baskan, Integer kurulusYili, String stadyum, String sehir) {
		this.id = id;
		this.takimad = takimad;
		this.baskan = baskan;
		this.kurulusYili = kurulusYili;
		this.stadyum = stadyum;
		this.sehir = sehir;
	}
	
	public Takim( int id, String takimad, String baskan, Integer kurulusYili, String stadyum,
	             String sehir,Integer state) {
		super(state);
		this.id = id;
		this.takimad = takimad;
		this.baskan = baskan;
		this.kurulusYili = kurulusYili;
		this.stadyum = stadyum;
		this.sehir = sehir;
	}
	
	public int getId() {
		return id;
	}
	
	
	public String getTakimad() {
		return takimad;
	}
	
	public void setTakimad(String takimad) {
		this.takimad = takimad;
	}
	
	public String getBaskan() {
		return baskan;
	}
	
	public void setBaskan(String baskan) {
		this.baskan = baskan;
	}
	
	public Integer getKurulusYili() {
		return kurulusYili;
	}
	
	public void setKurulusYili(Integer kurulusYili) {
		this.kurulusYili = kurulusYili;
	}
	
	public String getStadyum() {
		return stadyum;
	}
	
	public void setStadyum(String stadyum) {
		this.stadyum = stadyum;
	}
	
	public String getSehir() {
		return sehir;
	}
	
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	
	@Override
	public String toString() {
		return "Takim{" + "id=" + getId() + ", takimad='" + getTakimad() + '\'' + ", baskan='" + getBaskan() + '\'' + ", kurulusYili='" + getKurulusYili() + '\'' + ", stadyum='" + getStadyum() + '\'' + ", sehir='" + getSehir() + '\'' + ", state=" + getState() + '}';
	}
}