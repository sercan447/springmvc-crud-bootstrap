package com.allame.repository.service.impl;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allame.dao.MusteriDAO;
import com.allame.model.Musteri;
import com.allame.service.MusteriService;

@Transactional
@Service
public class MusteriServiceDAOImpl implements MusteriService {

	@Autowired
	//@Inject
	private MusteriDAO musteriDao;
	
	 public MusteriServiceDAOImpl() {
		System.out.println("MusteriServiceDAOImpl");
	}
	
	@Override
	public List<Musteri> findAllMusteri() {
		
		return musteriDao.findAllMusteri();
	}

	@Override
	public List<Musteri> findMusteriler(String musteriAdi) {
		
		return musteriDao.findMusteriler(musteriAdi);
	}

	@Override
	public Musteri findMusteri(long musteriId) {
	
		return musteriDao.findMusteri(musteriId);
	}

	@Override
	public long createMusteri(Musteri musteri) {
		
		return musteriDao.createMusteri(musteri);
	}

	@Override
	public Musteri updateMusteri(Musteri musteri) {
		
		return musteriDao.updateMusteri(musteri);
	}

	@Override
	public void deleteMusteri(long musteriId) {
		musteriDao.deleteMusteri(musteriId);
	}

}
