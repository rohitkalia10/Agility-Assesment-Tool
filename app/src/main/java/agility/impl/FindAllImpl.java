package agility.impl;

import agility.data.model.User;
import agility.domain.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import services.AddService;
import services.FindService;

import java.util.List;
import java.util.Optional;

public class FindAllImpl implements FindService {

    @Override
    public Iterable<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById() {
        return Optional.empty();
    }

    @Autowired
    private UserDao userDao;


}