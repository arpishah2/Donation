package donation.web.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class RegistrationForm {
	
	@NotEmpty(message = "{registration.error.email.required}")
	@Email(message = "{registration.error.email.invalid}")
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
