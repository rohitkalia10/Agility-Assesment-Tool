package agility.model;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@EntityScan
@Entity
//@Table(name = "question", uniqueConstraints=
//@UniqueConstraint(columnNames = {"typeCode", "questionCode"}))
@Table(name = "question")

	public class Question implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String typeCode;
	private String questionCode;
	@Column(unique = true)
	private String question;
    private String typeName;

	@OneToMany(mappedBy = "question")
	private Set<Answer> answer;


	// Getters and setters
	public Question() {
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getQuestionCode() {
		return questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
