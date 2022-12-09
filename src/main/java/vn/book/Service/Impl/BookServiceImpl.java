package vn.book.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.book.Entity.Book;
import vn.book.Repository.BookRepository;
import vn.book.Service.IBookService;


@Service
public class BookServiceImpl implements IBookService {
	@Autowired
	BookRepository bookRepo;

	public BookServiceImpl(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public <S extends Book> S save(S entity) {
		return bookRepo.save(entity);
	}

	@Override
	public List<Book> findAll() {
		return bookRepo.findAll();
	}

	@Override
	public Page<Book> findAll(Pageable pageable) {
		return bookRepo.findAll(pageable);
	}

	@Override
	public List<Book> findAll(Sort sort) {
		return bookRepo.findAll(sort);
	}

	@Override
	public List<Book> findAllById(Iterable<Long> ids) {
		return bookRepo.findAllById(ids);
	}

	@Override
	public Optional<Book> findById(Long id) {
		return bookRepo.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return bookRepo.existsById(id);
	}

	@Override
	public long count() {
		return bookRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		bookRepo.deleteById(id);
	}

	@Override
	public void delete(Book entity) {
		bookRepo.delete(entity);
	}
	
	
	
}