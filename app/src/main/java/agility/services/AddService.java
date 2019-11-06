package agility.services;

import agility.api.AddUpdateQuestionRequest;
import agility.api.AddUpdateUserRequest;
import agility.data.model.User;
import org.springframework.http.ResponseEntity;

public interface AddService {

    ResponseEntity addUser(AddUpdateUserRequest request);
    ResponseEntity addQuestion(AddUpdateQuestionRequest request);


}
