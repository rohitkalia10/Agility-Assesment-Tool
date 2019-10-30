package agility.impl;

import agility.api.ShowAnswersResponse;
import agility.api.ShowQuestionResponse;
import agility.api.ShowUserResponse;
import agility.data.model.Answer;
import agility.data.model.Question;
import agility.data.model.User;
import agility.data.repository.AnswerDao;
import agility.data.repository.QuestionDao;
import agility.data.repository.UserDao;
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

    @Autowired
    private AnswerDao answerDao;

    @Override
    public ResponseEntity findAllUsers() {

        Iterable<User> user = userDao.findAll();

        List responses = new ArrayList<>();
        user.forEach(user1 -> {
            ShowUserResponse response = new ShowUserResponse();
            response.setUid (user1.getUid());
            response.setFirstName(user1.getFirstName());
            response.setLastName(user1.getLastName());
            response.setEmail(user1.getEmail());
            response.setUserRole(user1.getUserRole());
            response.setSubmit(user1.getSubmit());
            responses.add(response);

        });

        return new ResponseEntity(responses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity findUserById(String uid) {

        Optional<User> user = userDao.findById(uid);
//        List responses = new ArrayList<>();
        ShowUserResponse response = new ShowUserResponse();
            response.setUid(user.get().getUid());
            response.setFirstName(user.get().getFirstName());
            response.setLastName(user.get().getLastName());
            response.setEmail(user.get().getEmail());
            response.setSubmit(user.get().getSubmit());
            response.setUserRole(user.get().getUserRole());

            return new ResponseEntity(response, HttpStatus.OK);
        }


    @Override
    public ResponseEntity findAllQuestions() {

        Iterable<Question> questions = questionDao.findAll();

        List responses = new ArrayList<>();
        questions.forEach(questionl -> {
            ShowQuestionResponse response = new ShowQuestionResponse();
            response.setQuestion (questionl.getQuestion());
            response.setQuestionCode(questionl.getQuestionCode());
            response.setTypeCode(questionl.getTypeCode());
            response.setTypeName(questionl.getTypeName());
            responses.add(response);
        });
        return new ResponseEntity(responses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity findAllAnswers() {

        Iterable<Answer> answers = answerDao.findAll();

        List responses = new ArrayList();
        answers.forEach( answerl -> {
            ShowAnswersResponse response = new ShowAnswersResponse();
            response.setTCode(answerl.gettCode());
            response.setQCode(answerl.getqCode());
            response.setAnswers(answerl.getAnswers());
            response.setSubmission(answerl.getSubmission());
            responses.add(response);

        });
        return new ResponseEntity(responses, HttpStatus.OK);
    }

}