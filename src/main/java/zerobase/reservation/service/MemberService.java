package zerobase.reservation.service;

import zerobase.reservation.entity.MemberEntity;
import zerobase.reservation.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

  @Autowired
  private MemberRepository memberRepository;

  public MemberEntity createMember(MemberEntity memberEntity) {

    //사용자 정보 유효성 검사
    //1. 이메일 필수
    //2. 이메일 유효성
    //3. 비밀번호 6자 이상
    //4. 이름 필수
    //5. 이미 등록된 이메일 인지 확인

    // 1. 이메일 필수
    if (memberEntity.getMbEmail() == null || memberEntity.getMbEmail().isEmpty()) {
      throw new IllegalArgumentException("이메일은 필수입니다.");
    }

    // 2. 이메일 유효성
    if (!memberEntity.getMbEmail().contains("@")) {
      throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
    }

    //3. 비밀번호 6자 이상
    if (memberEntity.getMbPassword() == null || memberEntity.getMbPassword().length() < 6) {
      throw new IllegalArgumentException("비밀번호는 6자 이상입니다.");
    }

    //4. 이름 필수
    if (memberEntity.getMbName() == null || memberEntity.getMbName().isEmpty()) {
      throw new IllegalArgumentException("이름은 필수입니다.");
    }

    //5. 이미 등록된 이메일 인지 확인
    if (memberRepository.findByMbEmail(memberEntity.getMbEmail()).isPresent()) {
      throw new IllegalArgumentException("이미 등록된 이메일입니다.");
    }

    // 비밀 번호 해시 처리하기
    // 나중에

    // 사용자 정보 반환하기
    return memberRepository.save(memberEntity);
  }

  // id로 멤버 조회 하기
  public MemberEntity readMember(Long mbId) {

    Optional<MemberEntity> memberEntity = memberRepository.findById(mbId);

    if (!memberEntity.isPresent()) {
      throw new IllegalArgumentException("존재하지 않는 회원입니다.");
    }
    return memberEntity.get();
  }

  // 모든 멤버 조회 하기
  public List<MemberEntity> readMemberAll() {
    return memberRepository.findAll();
  }

  // 멤버 수정하기
  public MemberEntity updateMember(Long mbId, MemberEntity newMemberEntity) {
    Optional<MemberEntity> memberEntity = memberRepository.findById(mbId);

    if (!memberEntity.isPresent()) {
      throw new IllegalArgumentException("존재하지 않는 회원입니다.");
    }

    MemberEntity existingMemberEntity = memberEntity.get();

    // 이름이 비거나, 이름이 다르면
    if (newMemberEntity.getMbName() != null && !newMemberEntity.getMbName().isEmpty()) {
      existingMemberEntity.setMbName(newMemberEntity.getMbName());
    }
    if (newMemberEntity.getMbEmail() != null && !newMemberEntity.getMbEmail().isEmpty()) {
      existingMemberEntity.setMbEmail(newMemberEntity.getMbEmail());
    }
    if (newMemberEntity.getMbPassword() != null && !newMemberEntity.getMbPassword().isEmpty()) {
      existingMemberEntity.setMbPassword(newMemberEntity.getMbPassword());
    }

    return memberRepository.save(existingMemberEntity);
  }

  // 멤버 삭제하기
  public void deleteMember(long memberId) {
    Optional<MemberEntity> memberEntity = memberRepository.findById(memberId);
    if (!memberEntity.isPresent()) {
      throw new IllegalArgumentException("존재하지 않는 회원입니다.");
    }
    // 사용자 삭제.
    memberRepository.deleteById(memberId);
  }
}
