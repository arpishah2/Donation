package donation.core.repository.impl;

import donation.core.domain.User;
import donation.core.repository.api.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import donation.core.domain.User;
import donation.core.repository.api.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public User getUserByEmail(String email) {
		TypedQuery<User> query = entityManager.createNamedQuery("findUserByEmail", User.class);
		query.setParameter("p_email", email);
		List<User> users = query.getResultList();
		return (users != null && !users.isEmpty()) ? users.get(0) : null;
	}


	public User create(User user) {
		entityManager.merge(user);
		return user;
	}

	public User update(User user) {
		return entityManager.merge(user);
	}

	public void remove(User user) {
		entityManager.createNativeQuery("DELETE FROM Donation d WHERE d.userId = " + user.getId()).executeUpdate();
		User u = entityManager.find(User.class, user.getId());
		entityManager.remove(u);		
	}

}
