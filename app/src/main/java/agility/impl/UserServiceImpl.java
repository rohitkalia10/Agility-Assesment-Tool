package agility.impl;

import agility.data.model.Question;
import agility.data.model.User;
import agility.domain.repository.QuestionDao;
import agility.domain.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private QuestionDao questionDao;

    @Override
    public Iterable<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findUserById(String uid) {
        return userDao.findById(uid);
    }

    @Override
    public Iterable<Question> findAllQuestions() {
        return questionDao.findAll();
    }

    @Override
    public Optional<Question> findQuestionById(String id) {
        return questionDao.findById(id);
    }
}