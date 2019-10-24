package agility.impl;

import agility.api.ShowAllUsersResponse;
import agility.data.model.Question;
import agility.data.model.User;
import agility.data.repository.QuestionDao;
import agility.data.repository.UserDao;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import agility.services.FindService;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FindServiceImpl implements FindService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private QuestionDao questionDao;

    @Override
    public ResponseEntity findAllUsers() {
        ShowAllUsersResponse response = new ShowAllUsersResponse();
        Iterable<User> user = userDao.findAll();

        List responses = new ArrayList<>();
        user.forEach(user1 -> {
            response.setUid (user1.getUid());
            response.setFirstName(user1.getFirstName());
            response.setLastName(user1.getLastName());
            response.setEmail(user1.getEmail());
            response.setSubmit(user1.getSubmit());
            responses.add(response);

        });

        return new ResponseEntity(responses, HttpStatus.OK);
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