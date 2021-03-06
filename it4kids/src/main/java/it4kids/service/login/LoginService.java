package it4kids.service.login;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it4kids.dao.indatabase.login.UserDAO;
import it4kids.domain.UserLogin;
import it4kids.service.ValidationException;

@Service
public class LoginService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	@Qualifier("JdbcTemplateUserDAO")
	private UserDAO userDAO;

	public boolean isRegistered(UserLogin userLogin) {
    	LOGGER.debug("userLoginService tries to authenticate " + userLogin.getUserName());
    	
		boolean isValid = false;
		
		if(userDAO.userIsRegistered(userLogin.getUserName(), userLogin.getPassword())) {
			LOGGER.debug("user " + userLogin.getUserName() + " is registered");
			isValid = true;
		}
	
		return isValid;
	}

	public void validate(String userName, String password) throws ValidationException {
		checkAuthentication(userName, password);
	}

	private void checkAuthentication(String userName, String password) throws ValidationException {
		List<String> errors = new LinkedList<String>();
		
		if (userName.isEmpty()) {
			errors.add("Numele de utilizator nu poate fi gol.");
		}

		if (password.isEmpty()) {
			errors.add("Parola nu poate fi goala.");
		}
		
		if(!userDAO.userIsRegistered(userName, password)) {
			errors.add("Numele de utilizator si parola sunt invalide.");
		}

		if (!errors.isEmpty()) {
			throw new ValidationException(errors.toArray(new String[] {}));
		}
	}
}
