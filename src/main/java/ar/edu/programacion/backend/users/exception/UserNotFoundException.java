/**
 * 
 */
package ar.edu.programacion.backend.users.exception;

import java.text.MessageFormat;

/**
 * @author daniel
 *
 */
public class UserNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2403553152554923472L;

	public UserNotFoundException(Long id) {
		super(MessageFormat.format("Cannot find User {0}", id));
	}

}
