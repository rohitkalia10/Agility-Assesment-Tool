package services;

import agility.data.model.User;

import java.util.List;
import java.util.Optional;


public interface FindService {

    public Iterable<User> findAll();

    public Optional<User> findById();

}
