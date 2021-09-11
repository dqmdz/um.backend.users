/**
 * 
 */
package ar.edu.programacion.backend.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.programacion.backend.users.exception.UserNotFoundException;
import ar.edu.programacion.backend.users.model.User;
import ar.edu.programacion.backend.users.repository.UserRepository;

/**
 * @author daniel
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	public User add(User user) {
		user = repository.save(user);
		return user;
	}

	public User update(User newUser, Long id) {
		return repository.findById(id).map(user -> {
			user = new User(id, newUser.getName(), newUser.getEmail(), newUser.getPassword());
			user = repository.save(user);
			return user;
		}).orElseThrow(() -> new UserNotFoundException(id));
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
