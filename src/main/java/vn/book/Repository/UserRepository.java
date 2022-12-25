package vn.book.Repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.book.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);
	public User findByResetPasswordToken(String token);
	//public User updatUser(User user);
	List<User> findByUsernameContaining(String name);
	Page<User> findByUsernameContaining(String name, Pageable pageable);
}	
