package agility.controller;

import agility.data.model.Answer;
import agility.data.model.Question;
import agility.data.model.User;
import agility.domain.services.AnswerDao;
import agility.domain.services.QuestionDao;
import agility.domain.services.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@Controller
public class AgilityController {

    private static Logger logger = LoggerFactory.getLogger(AgilityController.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private AnswerDao answerDao;



    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("Core-Competencies", "Team", "Skills");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "Welcome"; //view
    }

    @GetMapping( { "/api/agility" })
    public HttpEntity<String> sanityCheck() {

        logger.info("SanityCheck entered...");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        String msg = "It's alive! It's alive!";

        return new HttpEntity<String>(msg, headers);
    }

    @GetMapping( value = "/api/agility/V1/getUser/{uid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Optional<User> getUser(@PathVariable("uid") String uid) {


        logger.info("getUser entered: uid= " + uid);

        Optional<User> user = userDao.findById(uid);

        return user;
    }

    @GetMapping(value = "/api/agility/V1/getUsers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<User> getUsers() {

        logger.info("findAll USERS entered...");

        return userDao.findAll();
    }

    @GetMapping(value = "/api/agility/V1/getQuestions", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Question> getQuestions() {

        logger.info("findAll QUESTIONS entered...");

        return questionDao.findAll();
    }

    @GetMapping(value = "/api/agility/V1/getAnswers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Answer> getAnswers() {

        logger.info("findAll Answers entered...");

        return answerDao.findAll();
    }

    @PostMapping(value = "/api/agility/V1/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User saveUser(@RequestBody User u) {

        logger.info("saveUser entered...");

        User newUser = new User();
        newUser = userDao.save(u);
        return newUser;
    }

    @PostMapping(value = "/api/agility/V1/saveQuestion", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Question saveQuestion(@RequestBody Question q) {

        logger.info("saveQuestion entered...");

        Question question = new Question();
        question = questionDao.save(question);
        return question;
    }

    @PostMapping(value = "/api/agility/V1/saveAnswer", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Answer saveAnswer(@RequestBody Answer a) {

        logger.info("saveAnswer entered...");

        Answer answer = new Answer();
        answer = answerDao.save(answer);
        return answer;
    }
}
