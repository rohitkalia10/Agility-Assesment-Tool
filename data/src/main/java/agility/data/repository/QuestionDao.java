package agility.data.repository;

import agility.data.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource
@Transactional
public interface QuestionDao extends CrudRepository<Question, String> {
	
}