package vn.book.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.book.Entity.Order;
import vn.book.Entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	List<OrderItem> findByOrderIn(Collection<Order> orders);
	List<OrderItem> findByOrder(Order order);
}
