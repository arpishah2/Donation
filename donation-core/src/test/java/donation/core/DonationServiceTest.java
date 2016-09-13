package donation.core;

import java.util.List;

import donation.core.domain.Donation;
import donation.core.service.api.DonationService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/application-context.xml"})
public class DonationServiceTest {

    @Autowired
    private DonationService donationService;

    @Test
    public void testGetDonationById() {
        Donation donation = donationService.getDonationById(1);
        assertNotNull(donation);
        assertEquals(1, donation.getId());
    }
    
    @Test
    public void testGetDonationsByUser() {
    	List<Donation> list = donationService.getDonationListByUser(2);
    	assertNotNull(list);
    	assertEquals(3, list.size());
    }

}
