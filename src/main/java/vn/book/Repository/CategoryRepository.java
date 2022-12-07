package vn.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.book.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
