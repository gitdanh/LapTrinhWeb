package vn.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.book.Entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
