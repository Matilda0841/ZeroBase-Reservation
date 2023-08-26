package zerobase.reservation.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "review")
@Data
@Entity
public class ReviewEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("review_id")
  private Long reviewId;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "store_id", nullable = false)
  @JsonProperty("store_entity")
  private StoreEntity storeEntity;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "member_id", nullable = false)
  @JsonProperty("member_entity")
  private MemberEntity memberEntity;

  @JsonProperty("rating")
  @Column(name = "rating")
  private Integer rating;

  @JsonProperty("re_content")
  @Column(name = "re_content", columnDefinition = "TEXT")
  private String reContent;

  @JsonProperty("re_time")
  @Column(name = "re_time")
  private LocalDateTime reTime;

  @JsonProperty("re_title")
  @Column(name = "re_title")
  private String reTitle;
}
