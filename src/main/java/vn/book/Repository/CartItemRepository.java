package vn.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.book.Entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
