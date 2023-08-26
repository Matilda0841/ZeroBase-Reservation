package zerobase.reservation.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.naming.Name;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reservation")
public class ReservationEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("res_id")
  private Long resId;

  @JsonProperty("store_entity")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn (name = "storeId", nullable = false)
  private StoreEntity storeEntity;

  @JsonProperty("member_entity")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "memberId",nullable = false)
  private MemberEntity memberEntity;

  @JsonProperty("res_time")
  @Column(name = "res_time")
  private LocalDateTime resTime;

  @JsonProperty("res_status")
  @Column(name = "res_status")
  private String resStatus;
}
