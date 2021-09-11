/**
 * 
 */
package ar.edu.programacion.backend.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.programacion.backend.users.model.User;

/**
 * @author daniel
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
