package org.mehtor.repository;

import org.mehtor.entity.Takim;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TakimRepository implements ICrud<Takim> {
	String sql;
	private final DatabaseHelper databaseHelper;
	
	public TakimRepository() {
		this.databaseHelper = new DatabaseHelper();
	}
	
	@Override
	public void save(Takim takim) {
		sql = "INSERT INTO tbltakim(takimad, baskan, kurulusyili, stadyum, sehir) VALUES ('%s','%s','%d','%s','%s')"
				.formatted(takim.getTakimad(),takim.getBaskan(),takim.getKurulusYili(), takim.getStadyum() ,
				           takim.getSehir());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void delete(int silinecekTakimId) {
	sql = "DELETE FROM tbltakim WHERE id = " + silinecekTakimId;
	databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void update(Takim takim) {
	sql = ("UPDATE tbltakim SET takimad='%s', baskan='%s',kurulusyili= %d, stadyum='%s', sehir='%s' WHERE id =%d")
			.formatted(takim.getTakimad(), takim.getBaskan(),takim.getKurulusYili(),takim.getStadyum(),
			           takim.getSehir(),takim.getId());
	databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public List<Takim> findAll() {
		sql = "SELECT * FROM tbltakim ORDER BY id DESC ";
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		List<Takim> takimList = new ArrayList<>();
		if (resultSet.isPresent()) {
			ResultSet rs = resultSet.get();
			try{
				while(rs.next()){
					takimList.add(getValueFromResultSet(rs));
				}
			}
			catch (SQLException e) {
				System.out.println("Takim listesi getirilirken bir sorun oluştu "+e.getMessage());
			}
		}
		return takimList;
	}
	
	@Override
	public Optional<Takim> findById(int bulunacakTakimId) {
		sql = "SELECT * FROM tbltakim WHERE id = " + bulunacakTakimId;
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		try{
			if(resultSet.isPresent()){
				ResultSet rs = resultSet.get();
				if (rs.next()){
					return Optional.of(getValueFromResultSet(rs));
				}
			}
		}catch (SQLException e){
			System.out.println("Takim bulmada sorun yasandi..."+ e.getMessage());
		}
		
		return Optional.empty();
	}
	
	private Takim getValueFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String takimad = rs.getString("takimad");
		String baskan = rs.getString("baskan");
		Integer kurulusYili = rs.getInt("kurulusyili");
		String stadyum = rs.getString("stadyum");
		String sehir = rs.getString("sehir");
		Integer state = rs.getInt("state");
		
		return new Takim(id,takimad,baskan,kurulusYili,stadyum,sehir,state);
	}
}