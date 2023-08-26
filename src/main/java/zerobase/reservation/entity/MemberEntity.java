package zerobase.reservation.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "member")
public class MemberEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberId;

  @JsonProperty("mb_email")
  @Column(unique = true, nullable = false)
  private String mbEmail;

  @JsonProperty("mb_password")
  private String mbPassword;

  @JsonProperty("mb_name")
  private String mbName;

  @JsonProperty("mb_contact")
  private String mbContact;
}
