package vn.book.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.book.Entity.Book;
import vn.book.Entity.Store;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByStore(Store store);
	List<Book> findByStoreAndSellingTrue(Store store);
	List<Book> findByStoreAndSellingFalse(Store store);
	List<Book> findByBookNameContaining(String name);
	Page<Book> findByBookNameContaining(String name, Pageable pageable);
	
	Page<Book> findAllByStoreAndCategoryDeleteFalse(Optional<Store> store, Pageable pageable); 
	Page<Book> findAllByStoreAndBookNameContainingAndCategoryDeleteFalse(Optional<Store> store,String name, Pageable pageable);
}
