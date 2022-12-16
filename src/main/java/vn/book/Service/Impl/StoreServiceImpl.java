package vn.book.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import vn.book.Entity.Book;
import vn.book.Entity.Store;
import vn.book.Repository.StoreRepository;
import vn.book.Service.IStoreService;


@Service
public class StoreServiceImpl implements IStoreService{
	@Autowired StoreRepository store;
	@Override
	public void delete(Store entity) {
		// TODO Auto-generated method stub
		store.delete(entity);
	}



	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return store.existsById(id);
	}
	
	@Transactional
    public void addClient(Store store1){
        store.saveAndFlush(store1);
    }


	@Override
	public List<Store> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return store.findAllById(ids);
	}

	@Override
	public List<Store> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return store.findAll(sort);
	}

	@Override
	public Page<Store> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return store.findAll(pageable);
	}


	@Override
	public List<Store> findBystoreNameContaining(String name) {
		// TODO Auto-generated method stub
		return store.findBystoreNameContaining(name);
	}

	@Override
	public Page<Store> findBystoreNameContaining(String name, Pageable p) {
		// TODO Auto-generated method stub
		return store.findBystoreNameContaining(name, p);
	}




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
