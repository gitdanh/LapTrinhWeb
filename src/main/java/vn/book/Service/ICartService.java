package vn.book.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import vn.book.Entity.CartItem;
import vn.book.Entity.User;
import vn.book.Repository.CartItemRepository;

@Service
@SessionScope
public interface ICartService {

	int getAmmount();

	void update(int id, int quan);

	void clearCart();

	Collection<CartItem> listCartItem(User user);

	void remove(CartItem item);

	void addItem(CartItem item);
	
}
