package donation.core.service.impl;

import donation.core.domain.Donation;
import donation.core.repository.api.DonationRepository;
import donation.core.service.api.DonationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DonationServiceImpl implements DonationService {

	@Autowired
	private DonationRepository donationRepository;

	@Override
	public Donation getDonationById(long donationId) {
		return donationRepository.getDonationById(donationId);
	}

	@Override
	public List<Donation> getDonationListByUser(long userId) {
		return donationRepository.getDonationListByUser(userId);
	}

	@Override
	public List<Donation> getDonationListByUserAndYear(long userId, int year) {
		return donationRepository.getDonationListByUserAndYear(userId, year);
	}
	
	@Override
	@Transactional
	public Donation update(Donation don) {
		return donationRepository.update(don);
	}

	@Override
	public Donation create(Donation don) {
		return donationRepository.create(don);
	}

	@Override
	public void remove(Donation don) {
		donationRepository.remove(don);
	}

}
