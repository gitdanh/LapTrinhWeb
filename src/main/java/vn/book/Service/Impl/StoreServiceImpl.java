package vn.book.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import vn.book.Entity.Store;
import vn.book.Entity.User;
import vn.book.Repository.StoreRepository;
import vn.book.Service.IStoreService;

@Service
public class StoreServiceImpl implements IStoreService{
	@Autowired
	StoreRepository storeRepo;

	public StoreServiceImpl(StoreRepository storeRepo) {
		this.storeRepo = storeRepo;
	}

	@Override
	public <S extends Store> S save(S entity) {
		return storeRepo.save(entity);
	}

	@Override
	public List<Store> findAll() {
		return storeRepo.findAll();
	}

	@Override
	public Optional<Store> findById(Long id) {
		return storeRepo.findById(id);
	}

	@Override
	public <S extends Store> boolean exists(Example<S> example) {
		return storeRepo.exists(example);
	}

	@Override
	public long count() {
		return storeRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		storeRepo.deleteById(id);
	}

	@Override
	public Store findByOwner(User owner) {
		return storeRepo.findByOwner(owner);
	}
	
	
}
