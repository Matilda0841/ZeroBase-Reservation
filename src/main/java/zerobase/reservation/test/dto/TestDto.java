package zerobase.reservation.test.dto;

import lombok.Data;
import zerobase.reservation.test.entity.Test;

@Data
public class TestDto {
  private String text;

  public Test toEntity() {
    return new Test(null, text);
  }
}
