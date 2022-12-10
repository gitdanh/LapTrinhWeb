package vn.book.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.book.Entity.Category;
import vn.book.Repository.CategoryRepository;
import vn.book.Service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	CategoryRepository cateRepo;

	public CategoryServiceImpl(CategoryRepository cateRepo) {
		this.cateRepo = cateRepo;
	}

	@Override
	public <S extends Category> S save(S entity) {
		return cateRepo.save(entity);
	}

	@Override
	public List<Category> findAll() {
		return cateRepo.findAll();
	}

	@Override
	public Optional<Category> findById(Long id) {
		return cateRepo.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return cateRepo.existsById(id);
	}

	@Override
	public long count() {
		return cateRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		cateRepo.deleteById(id);
	}
	
	
}
