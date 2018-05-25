package com.allame.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.SessionFactory;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allame.dao.MusteriDAO;
import com.allame.model.Musteri;

@Repository
public class MusteriDaoImpl implements MusteriDAO{

	@Autowired
	//@Inject //**JSR330 LB EKLE
	private SessionFactory sessionFactory;
		
	public MusteriDaoImpl(){
		System.out.println("MusteriDaoImpl");
	}
	
	@Override
	public List<Musteri> findAllMusteri() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Musteri").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Musteri> findMusteriler(String arananmusteriAdi) {
		
		
			String sqlSorgu = "SELECT m.* FROM Musteri m WHERE m.musteriAdi LIKE '"+arananmusteriAdi+"'%";
			List<Object[]> musteriObjects = sessionFactory.getCurrentSession().createQuery(sqlSorgu).list();
			
			List<Musteri> musteriler = new ArrayList<Musteri>();
			
			for(Object[] musteriObject : musteriObjects)
			{
				
				long musteriId = ( (BigInteger) musteriObject[0]).longValue();
				String musteriAdi = (String)musteriObject[1];
				String musteriSoyadi = (String) musteriObject[2];
				int musteriNo = (int)musteriObject[3];
				
				Musteri musteri = new Musteri();
						musteri.setMusteriId(musteriId);
						musteri.setMusteriAdi(musteriAdi);
						musteri.setMusteriSoyadi(musteriSoyadi);
						musteri.setMusteriNo(musteriNo);
						
						musteriler.add(musteri);
			}
		return musteriler;
	}

	@Override
	public Musteri findMusteri(long musteriId) {
		return (Musteri) sessionFactory.getCurrentSession().get(Musteri.class, musteriId);
	}

	@Override
	public long createMusteri(Musteri musteri) {
		return (long) sessionFactory.getCurrentSession().save(musteri);
	}

	@Override
	public Musteri updateMusteri(Musteri musteri) {
		sessionFactory.getCurrentSession().update(musteri);
		return musteri;
	}

	@Override
	public void deleteMusteri(long musteriId) {
	
		Musteri musteri = new Musteri();
			    musteri.setMusteriId(musteriId);
			    
			    sessionFactory.getCurrentSession().delete(musteri);
	}

}
