package vn.book.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import vn.book.Entity.Book;
import vn.book.Entity.Store;

@Repository
@EnableJpaRepositories
public interface StoreRepository extends JpaRepository<Store, Long> {
	List<Store> findBystoreNameContaining(String name);
	Page<Store> findBystoreNameContaining(String name,Pageable p);
}
