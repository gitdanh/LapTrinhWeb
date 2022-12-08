package vn.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.book.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
