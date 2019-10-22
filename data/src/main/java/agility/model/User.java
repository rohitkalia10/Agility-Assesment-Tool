package agility.model;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.Set;

@EntityScan
@Entity
@Table(name = "user")

	public class User implements Serializable {

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private long id;

	@Id
	@Column(unique = true)
	private String uid;
    private String firstName;
    private String lastName;
    private String email;
	private String userRole;
	private String submit;

	@OneToOne(mappedBy = "user")
	private Answer answer;

// Getters and setters

    public User() {
    }

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {this.email = email;	}

	public String getUserRole() { return userRole; }

	public void setUserRole(String userRole) { this.userRole = userRole;}

	public String getSubmit() { return submit;}

	public void setSubmit(String submit) { this.submit = submit;}

}
