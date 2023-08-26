package zerobase.reservation.test.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "test")
public class Test {

  @Id
  @GeneratedValue()
  private Integer id;

  @Column
  private String text;

  public Test(Integer id, String text) {
    this.id = id;
    this.text = text;
  }

  public Test() {
  }
}
