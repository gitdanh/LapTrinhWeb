package vn.book.Service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;

import vn.book.Entity.User;


public interface IUserService {

	void deleteAll(Iterable<? extends User> entities);
	User getUser();
	
	User getCurrentlyLoggedInUser(Authentication authen);

	void deleteAllById(Iterable<? extends Long> ids);

	void deleteById(Long id);

	List<User> findAll(Sort sort);

	Page<User> findAll(Pageable pageable);

	List<User> findAll();

	<S extends User> S save(S entity);

	User findByUsername(String username);

	User findByEmail(String email);

	Optional<User> findById(Long id);
	
	void updateResetPasswordToken(String token, String email) throws CustomerNotFoundException ;
	
	User getByResetPasswordToken(String token);
	
	void updatePassword(User customer, String newPassword);
	
	//User updateUser(User user);
	
}
