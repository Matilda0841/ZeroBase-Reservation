package zerobase.reservation.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "store")
@Entity
public class StoreEntity  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("st_Id")
  private Long storeId;

  @JsonProperty("partner_entity")
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "partnerId")
  private PartnerEntity partnerEntity;

  @JsonProperty("st_name")
  @Column(name = "st_name")
  private String stName;

  @JsonProperty("st_loc")
  @Column(name = "st_loc")
  private String stLoc;

  @JsonProperty("st_desc")
  @Column(name = "st_desc")
  private String stDesc;

  @JsonProperty("st_openTime")
  @Column(name = "st_openTime")
  private String stOpenTime;

  @JsonProperty("st_closeTime")
  @Column(name = "st_closeTime")
  private String stCloseTime;
}
