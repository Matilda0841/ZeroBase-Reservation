package zerobase.reservation.repository;

import zerobase.reservation.entity.ReservationEntity;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReservationRepository extends JpaRepository <ReservationEntity, Long> {
}
