package zerobase.reservation.service;

import zerobase.reservation.entity.MemberEntity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

  @InjectMocks
  private MemberService memberService;

  @Test
  @DisplayName("이메일 필수")
  public void createMemberWithNullEmail() {
    // given 어떤 데이터가 있을때
    MemberEntity memberEntity = new MemberEntity();
    memberEntity.setMbEmail(null);

    // when 어떤 동작을 하면

    // then 어떤 결과가 나와야 한다
    Assertions.assertThrows(IllegalArgumentException.class, () -> memberService.createMember(memberEntity), "이메일은 필수입니다.");
  }

  @Test
  @DisplayName("이메일 형식 오류")
  public void createMemberNotEmail() {
    // given 어떤 데이터가 있을때
    MemberEntity memberEntity = new MemberEntity();
    memberEntity.setMbEmail("invalid-E-mail");
    // when 어떤 동작을 하면

    // then 어떤 결과가 나와야 한다
    Assertions.assertThrows(IllegalArgumentException.class, () -> memberService.createMember(memberEntity), "이메일 형식이 올바르지 않습니다.");
  }

}
