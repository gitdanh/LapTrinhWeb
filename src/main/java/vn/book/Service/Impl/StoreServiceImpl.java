package vn.book.Service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
		if(entity.getStoreId() != null) {
			Optional<Store> opt = findById(entity.getStoreId());
			Date date = new Date(System.currentTimeMillis()); 
			if(opt.isPresent()) {
				if(StringUtils.isEmpty(entity.getAvatar())) {
					entity.setAvatar(opt.get().getAvatar());
				}else {
					entity.setAvatar(entity.getAvatar());
				}
				entity.setCreateAt(opt.get().getCreateAt());
				entity.setUpdateAt(date);
			}
		}
		else {
			Date date = new Date(System.currentTimeMillis()); 
			entity.setCreateAt(date);
		}
		
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

	@Override
	public List<Store> findByStoreNameContaining(String name) {
		return storeRepo.findByStoreNameContaining(name);
	}

	@Override
	public Page<Store> findByStoreNameContaining(String name, Pageable pageable) {
		return storeRepo.findByStoreNameContaining(name, pageable);
	}

	@Override
	public Page<Store> findAll(Pageable pageable) {
		return storeRepo.findAll(pageable);
	}
	
	
}
