package vn.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.book.Entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
