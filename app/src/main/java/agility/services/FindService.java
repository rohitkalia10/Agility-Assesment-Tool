package agility.services;

import org.springframework.http.ResponseEntity;

public interface FindService {
    public ResponseEntity findAllUsers();
    public ResponseEntity findUserById(String s);
    public ResponseEntity findAllQuestions();
    public ResponseEntity findQuestionsById(String s);
    public ResponseEntity findAllAnswers();

}
