package vn.book.Service.Impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vn.book.Entity.CartItem;
import vn.book.Entity.User;
import vn.book.Service.ICartService;

public class CartServiceImpl implements ICartService {

	private Map<Integer, CartItem> map= new HashMap<Integer, CartItem>();
	
	@Override
	public void addItem(CartItem item)
	{
		
		Integer itemId = item.getId().intValue();
		CartItem existed = map.get(itemId);
		if(existed != null)
		{
			existed.setCount(item.getCount()+existed.getCount());
		}
		else {
			map.put(itemId, item);
		}	
	}
	@Override
	public void remove(CartItem item)
	{
		Integer itemId = item.getId().intValue();
		map.remove(itemId);
	}
	
	@Override
	public Collection<CartItem> listCartItem(User user) {
		// TODO Auto-generated method stub
		return map.values();
	}
	@Override
	public void clearCart() {
		map.clear();
	}
	@Override
	public void update(int id,int quan) {
		CartItem item = map.get(id);
		item.setCount(quan + item.getCount());
		if(item.getCount() <=0) {
			map.remove(id);
		}
	}
	@Override
	public int getAmmount()
	{
		return map.values().size();
	}
}
