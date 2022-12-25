package vn.book.Service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.book.Entity.Order;
import vn.book.Entity.Store;
import vn.book.Entity.User;
import vn.book.Repository.OrderRepository;
import vn.book.Service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	OrderRepository orderRepo;

	public OrderServiceImpl(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}

	@Override
	public List<Order> findByStore(Store store) {
		return orderRepo.findByStore(store);
	}

	@Override
	public List<Order> findByStoreAndStatus(Store store, String status) {
		return orderRepo.findByStoreAndStatus(store, status);
	}

	@Override
	public Long countByStoreAndStatus(Store store, String status) {
		return orderRepo.countByStoreAndStatus(store, status);
	}

	@Override
	public <S extends Order> S save(S entity) {
		if (entity.getOrderId() != null) {
			Date date = new Date(System.currentTimeMillis());
			entity.setUpdateAt(date);
			return orderRepo.save(entity);
		}
		return orderRepo.save(entity);
	}

	@Override
	public List<Order> findAll() {
		return orderRepo.findAll();
	}

	@Override
	public long count() {
		return orderRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		orderRepo.deleteById(id);
	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderRepo.findById(id);
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return orderRepo.findAll(pageable);
	}

	@Override
	public Page<Order> findAllByUser(User user, Pageable pageable) {
		// TODO Auto-generated method stub
		return orderRepo.findAllByuser(user, pageable);
	}
	
	
}
