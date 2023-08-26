package zerobase.reservation.repository;

import zerobase.reservation.entity.StoreEntity;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long> {
}
