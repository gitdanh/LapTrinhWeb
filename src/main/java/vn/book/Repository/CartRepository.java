package vn.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.book.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
