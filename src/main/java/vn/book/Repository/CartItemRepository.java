package vn.book.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.book.Entity.CartItem;
import vn.book.Entity.User;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	public List<CartItem> findByUser(User user);
}
