package vn.book.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;

import vn.book.Entity.Store;
import vn.book.Entity.User;

public interface IStoreService {

	Store findByOwner(User owner);

	void deleteById(Long id);

	long count();

	<S extends Store> boolean exists(Example<S> example);

	Optional<Store> findById(Long id);

	List<Store> findAll();

	<S extends Store> S save(S entity);

}
