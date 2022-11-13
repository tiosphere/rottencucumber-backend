package tk.rottencucumber.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.rottencucumber.backend.model.MoviesModel;

@Repository
public interface MoviesRepository extends CrudRepository<MoviesModel, Long> {
}
