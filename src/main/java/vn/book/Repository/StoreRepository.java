package vn.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.book.Entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
