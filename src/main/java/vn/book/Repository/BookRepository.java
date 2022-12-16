package vn.book.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.book.Entity.Book;
import vn.book.Entity.Store;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByStore(Store store);
	List<Book> findByStoreAndSellingTrue(Store store);
	List<Book> findByStoreAndSellingFalse(Store store);
}
