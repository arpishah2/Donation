package donation.core.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
  @NamedQuery(name = "findUserByEmail", query = "SELECT u FROM User u where u.email = :p_email")
})
public class User implements Serializable{

  @Id
  @GeneratedValue
	private Long id;
	private String email;

	public User() {
	}

	public User(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User[" +
				"id=" + id +
				", email='" + email + '\'' +
				']';
	}

}

