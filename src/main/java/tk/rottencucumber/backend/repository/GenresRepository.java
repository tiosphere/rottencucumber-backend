package tk.rottencucumber.backend.repository;

import org.springframework.data.repository.CrudRepository;
import tk.rottencucumber.backend.model.GenresModel;

public interface GenresRepository extends CrudRepository<GenresModel, Long> {
}