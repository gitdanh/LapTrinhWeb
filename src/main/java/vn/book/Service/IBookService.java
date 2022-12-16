package vn.book.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.book.Entity.Book;
@Service
public interface IBookService {

	void delete(Book entity);

	void deleteById(Long id);

	long count();

	boolean existsById(Long id);

	Optional<Book> findById(Long id);

	List<Book> findAllById(Iterable<Long> ids);

	List<Book> findAll(Sort sort);

	Page<Book> findAll(Pageable pageable);

	List<Book> findAll();

	<S extends Book> S save(S entity);
	List<Book> findBybookNameContaining(String name);
	Page<Book> findBybookNameContaining(String name,Pageable p);
}
