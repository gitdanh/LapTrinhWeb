package vn.book.Service;

import java.util.List;
import java.util.Optional;

import vn.book.Entity.Category;

public interface ICategoryService {

	void deleteById(Long id);

	long count();

	boolean existsById(Long id);

	Optional<Category> findById(Long id);

	List<Category> findAll();

	<S extends Category> S save(S entity);

}
