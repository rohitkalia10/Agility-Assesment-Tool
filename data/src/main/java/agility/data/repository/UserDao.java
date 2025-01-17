package agility.data.repository;

import agility.data.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.Optional;

@RepositoryRestResource
@Transactional
public interface UserDao extends CrudRepository<User, String> {
    Optional<User> findByEmail(String email);
	
}