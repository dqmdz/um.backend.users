/**
 * 
 */
package ar.edu.programacion.backend.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.programacion.backend.users.model.User;
import ar.edu.programacion.backend.users.service.UserService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/")
	public ResponseEntity<List<User>> findAll() {
		return new ResponseEntity<List<User>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return new ResponseEntity<User>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<User> add(@RequestBody User user) {
		return new ResponseEntity<User>(service.add(user), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
		return new ResponseEntity<User>(service.update(user, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
