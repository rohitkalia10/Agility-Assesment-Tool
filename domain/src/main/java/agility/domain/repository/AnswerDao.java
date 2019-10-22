package agility.domain.repository;


import agility.data.model.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AnswerDao extends CrudRepository<Answer, String> {
	
}