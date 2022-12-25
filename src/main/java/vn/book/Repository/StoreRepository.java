package vn.book.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.book.Entity.Store;
import vn.book.Entity.User;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	Store findByOwner(User owner);
	List<Store> findByStoreNameContaining(String name);
	Page<Store> findByStoreNameContaining(String name, Pageable pageable);
}
