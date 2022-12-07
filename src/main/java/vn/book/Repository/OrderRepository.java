package vn.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.book.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
