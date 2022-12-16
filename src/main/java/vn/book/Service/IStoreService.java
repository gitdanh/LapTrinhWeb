package vn.book.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.book.Entity.Store;
import vn.book.Entity.User;

public interface IStoreService {

	Store findByOwner(User owner);


	void delete(Store entity);


	void deleteById(Long id);

	long count();


	<S extends Store> boolean exists(Example<S> example);

	Optional<Store> findById(Long id);

	List<Store> findAll();

	<S extends Store> S save(S entity);

	boolean existsById(Long id);

	List<Store> findAllById(Iterable<Long> ids);

	List<Store> findAll(Sort sort);

	Page<Store> findAll(Pageable pageable);

	List<Store> findBystoreNameContaining(String name);
	Page<Store> findBystoreNameContaining(String name,Pageable p);

}
