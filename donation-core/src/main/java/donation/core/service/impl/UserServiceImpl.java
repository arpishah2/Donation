package donation.core.service.impl;
import donation.core.domain.User;
import donation.core.repository.api.UserRepository;
import donation.core.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User create(final User user) {
		return userRepository.create(user);
	} 

	public User update(User user) {
		return userRepository.update(user);
	}

	public void remove(final User user) {
		userRepository.remove(user);
	}

	@Transactional(readOnly = true)
	public User getUserByEmail(final String email) {
		return userRepository.getUserByEmail(email);
	}

}
