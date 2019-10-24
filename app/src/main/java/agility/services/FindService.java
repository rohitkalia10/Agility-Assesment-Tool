package agility.services;

import agility.data.model.Question;
import agility.data.model.User;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FindService {
    public ResponseEntity findAllUsers();
    public Optional<User> findUserById(String s);
    public Iterable<Question> findAllQuestions();
    public Optional<Question> findQuestionById(String s);

}
