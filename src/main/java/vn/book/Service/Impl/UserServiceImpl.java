package vn.book.Service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import vn.book.Entity.User;
import vn.book.Repository.UserRepository;
import vn.book.Service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepo;

	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public <S extends User> S save(S entity) {
		if(entity.getUserId() != null) {
			Optional<User> opt = findById(entity.getUserId());
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
		} else {
			Date date = new Date(System.currentTimeMillis()); 
			entity.setCreateAt(date);
		}
		return userRepo.save(entity);
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userRepo.findAll(pageable);
	}

	@Override
	public List<User> findAll(Sort sort) {
		return userRepo.findAll(sort);
	}

	@Override
	public void deleteById(Long id) {
		userRepo.deleteById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		userRepo.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		userRepo.deleteAll(entities);
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepo.findById(id);
	}

	@Override
	public List<User> findByUsernameContaining(String name) {
		return userRepo.findByUsernameContaining(name);
	}

	@Override
	public Page<User> findByUsernameContaining(String name, Pageable pageable) {
		return userRepo.findByUsernameContaining(name, pageable);
	}

	@Override
	public long count() {
		return userRepo.count();
	}
	
	
}	
