package agility.controller;

import agility.api.AddUpdateUserRequest;
import agility.data.model.Answer;
import agility.data.model.Question;
import agility.data.model.User;
import agility.data.repository.AnswerDao;
import agility.data.repository.QuestionDao;
import agility.services.AddService;
import org.codehaus.jackson.map.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import agility.services.FindService;


import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@Controller
public class AgilityController {

    private static Logger logger = LoggerFactory.getLogger(AgilityController.class);

    @Autowired
    private FindService findService;

    @Autowired
    private AddService addService;

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
    public ResponseEntity getUser(@PathVariable("uid") String uid) {

        logger.info("getUser entered: uid= " + uid);

        return findService.findUserById(uid);
    }

    @GetMapping( value = "/api/agility/V1/getUsers", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getUsers() {

        logger.info("findAll USERS entered...");

        return findService.findAllUsers();
    }

    @GetMapping(value = "/api/agility/V1/getQuestions", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getQuestions() {

        logger.info("findAll QUESTIONS entered...");

        return findService.findAllQuestions();
    }

    @GetMapping( value = "/api/agility/V1/getQuestion/{tCode}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getQuestions(@PathVariable("tCode") String tCode) {

        logger.info("getQuestions entered: type code= " + tCode);

        return findService.findQuestionsById(tCode);
    }

    @GetMapping(value = "/api/agility/V1/getAnswers", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getAnswers() {

        logger.info("findAll Answers entered...");

        return findService.findAllAnswers();
    }

    @PostMapping(value = "/api/agility/V1/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity saveUser(@Valid @RequestBody final AddUpdateUserRequest request) {

        logger.info("saveUser entered...");

        return addService.addUser(request);
    }

    @PostMapping(value = "/api/agility/V1/saveQuestion", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Question saveQuestion(@RequestBody Question q) {

        logger.info("saveQuestion entered...");
        return null;
    }



//    @PostMapping(value = "/api/agility/V1/saveAnswer", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Answer saveAnswer(@RequestBody Answer a) {
//
//        logger.info("saveAnswer entered...");
//
//        Answer answer = new Answer();
//        answer = answerDao.save(answer);
//        return answer;
//    }
}
