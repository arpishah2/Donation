package donation.core.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@NamedQueries({
	@NamedQuery(name = "findDonationsByUser", query = "SELECT t FROM Donation t where t.userId = ?1 order by t.year"),
	@NamedQuery(name = "findDonationsByUserAndYear", query = "SELECT t FROM Donation t where t.userId = ?1 and t.year = ?2")
})
public class Donation implements Serializable {

	@Id
    @GeneratedValue
	private long id;
	
	private long userId;

  //todo -length > 512
	@Column(length = 512)
	private String description;
	private float estimate;
	private float tax_deductible;
	private int year;

  private static final float DEDUCTIBLE_RATE = 0.3f;

	public Donation() {
	}

	public Donation(long userId, String desc, float estimate) {
		this.userId = userId;
		this.description = desc;
		this.estimate = estimate;
		this.tax_deductible = estimate*DEDUCTIBLE_RATE;
	}

	public Donation(long userId, String desc, float estimate, int year) {
		this.userId = userId;
		this.description = desc;
		this.estimate = estimate;
		this.tax_deductible = estimate*DEDUCTIBLE_RATE;
		this.year = year;
	}

	public long getId() {
		return id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String title) {
		this.description = title;
	}

	public float getEstimate() {
		return estimate;
	}

	public void setEstimate(float estimate) {
		this.estimate = estimate;
		this.tax_deductible = estimate*DEDUCTIBLE_RATE;
	}

	public float getTaxDeductible() {
		return tax_deductible;
	}

	public int getYear(){
		return year;
	}

	public void setYear(int yyyy){
		year = yyyy;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Donation{");
		sb.append("id=").append(id);
		sb.append(", userId=").append(userId);
		sb.append(", description='").append(description).append('\'');
		sb.append(", estimatedValue=").append(estimate);
		sb.append(", taxDeductible=").append(tax_deductible);
		sb.append(", Year=").append(year);
		sb.append('}');
		return sb.toString();
	}

}
