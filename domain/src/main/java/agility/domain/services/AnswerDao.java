package agility.domain.services;


import agility.data.model.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource
@Transactional
public interface AnswerDao extends CrudRepository<Answer, String> {
	
}