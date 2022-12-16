package vn.book.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.book.Entity.Order;
import vn.book.Entity.Store;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByStore(Store store);
	List<Order> findByStoreAndStatus(Store store, String status);
	Long countByStoreAndStatus(Store store, String status);
}
