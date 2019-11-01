package agility.impl;

import agility.api.AddUpdateUserRequest;
import agility.api.StatusMessage;
import agility.data.model.User;
import agility.data.repository.AnswerDao;
import agility.data.repository.QuestionDao;
import agility.data.repository.UserDao;
import agility.exception.AgilityException;
import agility.services.AddService;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.JDBCException;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Optional;

@Service
public class AddServiceImpl implements AddService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private AnswerDao answerDao;

    @Override
    public ResponseEntity addUser(AddUpdateUserRequest request) {

        try {
            String email = request.getEmail();
            if (email == null ) {

                User user = new User();
                user.setUid(user.getUid());
                user.setFirstName(request.getFirstName());
                user.setLastName(request.getLastName());
                user.setUserRole(request.getUserRole());
                user.setEmail(request.getEmail());

                user = userDao.save(user);

            } else
                return new ResponseEntity("User Already Exists", HttpStatus.OK);
        } catch (AgilityException e) {
            return new ResponseEntity(e.getStatusMessage().getMessage(),HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity("User Saved", HttpStatus.OK );
    }


}
