package org.mehtor.repository;

import org.mehtor.entity.Futbolcu;
import org.mehtor.entity.Takim;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FutbolcuRepository implements ICrud<Futbolcu> {
	String sql;
	private final DatabaseHelper databaseHelper;
	
	public FutbolcuRepository() {
		this.databaseHelper = new DatabaseHelper();
	}
	
	@Override
	public void save(Futbolcu futbolcu) {
	sql = "INSERT INTO tblfutbolcu(takimid, ad, soyad, dtarih, pozisyon) VALUES ('%d','%s','%s','%s','%s') "
			.formatted(futbolcu.getTakimId(),futbolcu.getAd(),futbolcu.getSoyad(),futbolcu.getDtarih(),futbolcu.getPozisyon());
	databaseHelper.executeUpdate(sql);
	}
	
	//id, takimid, ad, soyad, dtarih, pozisyon, state)
	
	@Override
	public void delete(int silinecekFutbolcuId) {
	sql = "DELETE FROM tblfutbolcu WHERE id= "+silinecekFutbolcuId;
	databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void update(Futbolcu futbolcu) {
	sql = ("UPDATE tblfutbolcu SET takimid=%d, ad='%s', soyad='%s', dtarih='%s', pozisyon='%s' WHERE id=%d")
			.formatted(futbolcu.getTakimId(),futbolcu.getAd(),futbolcu.getSoyad(),futbolcu.getDtarih(),futbolcu.getPozisyon(),futbolcu.getId());
	databaseHelper.executeUpdate(sql);
	
	}
	
	@Override
	public List<Futbolcu> findAll() {
		sql = "SELECT * FROM tblfutbolcu ORDER BY id DESC";
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		List<Futbolcu> futbolcuList = new ArrayList<>();
		if (resultSet.isPresent()) {
			ResultSet rs = resultSet.get();
			try{
				while(rs.next()){
					futbolcuList.add(getValueFromResultSet(rs));
				}
			}
			catch (SQLException e){
				System.out.println("Futbolcu listesi getirilirken bir sorun oluştu "+e.getMessage());
			}
		}
		return futbolcuList;
	}
	
	@Override
	public Optional<Futbolcu> findById(int bulunacakFutbolcuId) {
		sql = "SELECT * FROM tblfutbolcu WHERE id= "+bulunacakFutbolcuId;
		Optional<ResultSet>resultSet = databaseHelper.executeQuery(sql);
		try{
			if(resultSet.isPresent()){
				ResultSet rs = resultSet.get();
				if(rs.next()){
					return Optional.of(getValueFromResultSet(rs));
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Futbolcu bulmada sorun yasandi..."+e.getMessage());
		}
		return Optional.empty();
	}
	
	private Futbolcu getValueFromResultSet(ResultSet rs) throws SQLException{
		int id = rs.getInt("id");
		Integer takimid = rs.getInt("takimid");
		String ad = rs.getString("ad");
		String soyad = rs.getString("soyad");
		String dtarih = rs.getString("dtarih");
		String pozisyon = rs.getString("pozisyon");
		Integer state = rs.getInt("state");
		
		return new Futbolcu(id, takimid, ad, soyad, LocalDate.parse(dtarih), pozisyon, state);
	}
}