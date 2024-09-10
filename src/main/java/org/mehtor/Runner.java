package org.mehtor;

import org.mehtor.entity.Futbolcu;
import org.mehtor.entity.Takim;
import org.mehtor.repository.FutbolcuRepository;
import org.mehtor.repository.TakimRepository;

import java.time.LocalDate;
import java.util.Optional;

public class Runner {
	public static void main(String[] args) {
		TakimRepository takimRepository = new TakimRepository();
		/*
		Takim t1 = new Takim("Galatasaray","Dursun", 1905,"Rans Park","İstanbul");
		takimRepository.save(t1);
		*/
		
		/*
		takimRepository.delete(3);
		*/
		
		//takimRepository.findAll().forEach(System.out::println);
		
		//takimRepository.findById(2).ifPresent(System.out::println);
		
		/*
		Optional<Takim> guncellenecekTakim = takimRepository.findById(2);
		if(guncellenecekTakim.isPresent()){
			guncellenecekTakim.get().setBaskan("Ali Koç");
			takimRepository.update(guncellenecekTakim.get());
		}else {
			System.out.println("Güncellenecek müşteri bulunamadı.");
		}
		*/
		
		//-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
		
		
		FutbolcuRepository futbolcuRepository = new FutbolcuRepository();
		
		/*
		//Integer takimId, String ad, String soyad, Date dtarih, String pozisyon
		Futbolcu f1 = new Futbolcu(2, "Cenk", "Soyad", LocalDate.of(1995,3,4),"Kaleci");
		futbolcuRepository.save(f1);
		*/
		
		/*
		futbolcuRepository.delete(2);
		*/
		
		/*
		futbolcuRepository.findAll().forEach(System.out::println);
		 */
		
		/*
		futbolcuRepository.findById(3).ifPresent(System.out::println);
		*/
		
		Optional<Futbolcu> guncellenecekFutbolcu = futbolcuRepository.findById(3);
		if (guncellenecekFutbolcu.isPresent()) {
			guncellenecekFutbolcu.get().setSoyad("Tosun");
			futbolcuRepository.update(guncellenecekFutbolcu.get());
		}else {
			System.out.println("Güncellenecek futbolcu bulunamadı.");
		}
	}
}