package zerobase.reservation.test.repository;

import org.springframework.data.repository.CrudRepository;
import zerobase.reservation.test.entity.Test;

public interface TestRepository extends CrudRepository<Test, Integer> {
}
