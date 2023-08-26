package zerobase.reservation.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "partner")
public class PartnerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long partnerId;

  @JsonProperty("pt_email")
  @Column(unique = true, nullable = false)
  private String ptEmail;

  @JsonProperty("pt_password")
  private String ptPassword;

  @JsonProperty("pt_name")
  private String ptName;

  @JsonProperty("pt_contact")
  private String ptContact;
}
