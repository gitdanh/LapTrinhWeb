package vn.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.book.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
