package vn.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.book.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
