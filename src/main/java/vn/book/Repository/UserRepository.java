package vn.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.book.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
