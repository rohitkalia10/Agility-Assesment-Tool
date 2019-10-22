package agility.data.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.io.Serializable;

@EntityScan
@Entity
@Table(name = "answer")
public class Answer implements Serializable  {


//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private long id;
	@Id
	private String userId;
	private String tCode;
	private String qCode;
	private String answers;

	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "uid", updatable=false,insertable=false)
	private User user;

	@ManyToOne
	@JoinColumns ({
		@JoinColumn(name = "qCode", referencedColumnName = "questionCode", updatable=false,insertable=false),
		@JoinColumn(name = "tCode", referencedColumnName = "typeCode", updatable=false,insertable=false)
	})
	private Question question;

	public Answer() {
	}

	// Getters and setters


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String gettCode() {
		return tCode;
	}

	public void settCode(String tCode) {
		this.tCode = tCode;
	}

	public String getqCode() {
		return qCode;
	}

	public void setqCode(String qCode) {
		this.qCode = qCode;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}
}
