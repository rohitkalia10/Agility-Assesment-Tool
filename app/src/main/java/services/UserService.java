package services;

import agility.data.model.Question;
import agility.data.model.User;

import java.util.Optional;

public interface UserService {
    public Iterable<User> findAllUsers();
    public Optional<User> findUserById(String s);
    public Iterable<Question> findAllQuestions();
    public Optional<Question> findQuestionById(String s);

}
