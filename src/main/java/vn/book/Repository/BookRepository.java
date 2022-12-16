package vn.book.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;
import vn.book.Entity.Book;

@Repository
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findBybookNameContaining(String name);
	Page<Book> findBybookNameContaining(String name,Pageable p);
}
