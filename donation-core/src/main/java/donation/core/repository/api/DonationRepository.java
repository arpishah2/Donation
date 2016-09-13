package donation.core.repository.api;
import donation.core.domain.Donation;
import java.util.List;

public interface DonationRepository {

	Donation getDonationById(final long donationId);

	List<Donation> getDonationListByUser(final long userId);

	List<Donation> getDonationListByUserAndYear(final long userId, final int year);

	Donation create(final Donation don);

	Donation update(Donation don);

	void remove(final Donation don);

}
