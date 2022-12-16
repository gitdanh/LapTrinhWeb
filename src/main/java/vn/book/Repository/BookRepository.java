package vn.book.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;
import vn.book.Entity.Book;
import vn.book.Entity.Store;

@Repository
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByStore(Store store);
	List<Book> findByStoreAndSellingTrue(Store store);
	List<Book> findByStoreAndSellingFalse(Store store);

	List<Book> findBybookNameContaining(String name);
	Page<Book> findBybookNameContaining(String name,Pageable p);

}
