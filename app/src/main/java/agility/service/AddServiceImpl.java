package agility.service;

import agility.domain.services.AddService;
import org.springframework.stereotype.Service;

@Service
public class AddServiceImpl implements AddService {

    public String getResponse(String request) {
        return "Success12345";
    }

}
