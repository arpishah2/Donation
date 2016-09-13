package donation.core.repository.impl;

import donation.core.domain.Donation;
import donation.core.repository.api.DonationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import java.util.List;

@Repository
public class DonationRepositoryImpl implements DonationRepository {

  @PersistenceContext
	private EntityManager entityManager;

	public Donation getDonationById(final long id) {
		return entityManager.find(Donation.class, id);
	}

	public List<Donation> getDonationListByUser(final long userId) {
		TypedQuery<Donation> query = entityManager.createNamedQuery("findDonationsByUser", Donation.class);
		query.setParameter(1, userId);
		return query.getResultList();
	}

	public List<Donation> getDonationListByUserAndYear(final long userId, final int year){
		TypedQuery<Donation> query = entityManager.createNamedQuery("findDonationsByUserAndYear", Donation.class);
		query.setParameter(1, userId);
		query.setParameter(2, year);
		return query.getResultList();
	}

	public Donation create(Donation don) {
		entityManager.persist(don);
		return don;
	}

	@Override
	public Donation update(Donation don) {
		return entityManager.merge(don);
	}

	@Override
	public void remove(Donation don) {
		Donation d = entityManager.find(Donation.class, don.getId());
		entityManager.remove(d);
	}



}
