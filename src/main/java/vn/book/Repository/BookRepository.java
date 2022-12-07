package vn.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.book.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
