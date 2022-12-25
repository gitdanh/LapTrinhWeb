package vn.book.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.book.Entity.Order;
import vn.book.Entity.Store;

public interface IOrderService {

	void deleteById(Long id);

	long count();

	List<Order> findAll();

	<S extends Order> S save(S entity);

	Long countByStoreAndStatus(Store store, String status);

	List<Order> findByStoreAndStatus(Store store, String status);

	List<Order> findByStore(Store store);

	Optional<Order> findById(Long id);

	Page<Order> findAllByStoreAndUserUsernameContaining(Optional<Store> store, String name, Pageable pageable);

	Page<Order> findAllByStore(Optional<Store> store, Pageable pageable);

}
