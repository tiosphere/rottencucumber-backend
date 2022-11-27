package tk.rottencucumber.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.rottencucumber.backend.model.WriterModel;

@Repository
public interface WriterRepository extends CrudRepository<WriterModel, Long> {
}