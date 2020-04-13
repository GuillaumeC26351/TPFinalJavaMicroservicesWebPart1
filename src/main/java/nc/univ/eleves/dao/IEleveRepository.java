package nc.univ.eleves.dao;

import nc.univ.eleves.models.Eleve;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEleveRepository extends CrudRepository<Eleve, Long> {
}
