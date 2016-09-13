package donation.core.service.api;

import donation.core.domain.User;

public interface UserService {

	User getUserByEmail(final String email);

	User create(final User user);

	User update(User user);

	void remove(final User user);
}
