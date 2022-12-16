package vn.book.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.book.Entity.Store;
@Service
public interface IStoreService {
	void delete(Store entity);

	void deleteById(Long id);

	long count();

	boolean existsById(Long id);

	Optional<Store> findById(Long id);

	List<Store> findAllById(Iterable<Long> ids);

	List<Store> findAll(Sort sort);

	Page<Store> findAll(Pageable pageable);

	List<Store> findAll();

	<S extends Store> S save(S entity);
	List<Store> findBystoreNameContaining(String name);
	Page<Store> findBystoreNameContaining(String name,Pageable p);
}
