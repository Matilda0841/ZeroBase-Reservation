package zerobase.reservation.service;

import zerobase.reservation.entity.PartnerEntity;
import zerobase.reservation.repository.PartnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerService {

  @Autowired
  private PartnerRepository partnerRepository;

  public PartnerEntity createPartner(PartnerEntity partnerEntity) {

    //사용자 정보 유효성 검사
    //1. 이메일 필수
    //2. 이메일 유효성
    //3. 비밀번호 6자 이상
    //4. 이름 필수
    //5. 이미 등록된 이메일 인지 확인

    // 1. 이메일 필수
    if (partnerEntity.getPtEmail() == null || partnerEntity.getPtEmail().isEmpty()) {
      throw new IllegalArgumentException("이메일은 필수입니다.");
    }

    // 2. 이메일 유효성
    if (!partnerEntity.getPtEmail().contains("@")) {
      throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
    }

    //3. 비밀번호 6자 이상
    if (partnerEntity.getPtPassword() == null || partnerEntity.getPtPassword().length() < 6) {
      throw new IllegalArgumentException("비밀번호는 6자 이상입니다.");
    }

    //4. 이름 필수
    if (partnerEntity.getPtName() == null || partnerEntity.getPtName().isEmpty()) {
      throw new IllegalArgumentException("이름은 필수입니다.");
    }

    //5. 이미 등록된 이메일 인지 확인
    if (partnerRepository.findByPtEmail(partnerEntity.getPtEmail()).isPresent()) {
      throw new IllegalArgumentException("이미 등록된 이메일입니다.");
    }

    // 비밀 번호 해시 처리하기
    // 나중에

    // 사용자 정보 반환하기
    return partnerRepository.save(partnerEntity);
  }

  // id로 멤버 조회 하기
  public PartnerEntity readPartner(Long ptId) {

    Optional<PartnerEntity> partnerEntity = partnerRepository.findById(ptId);

    if (!partnerEntity.isPresent()) {
      throw new IllegalArgumentException("존재하지 않는 회원입니다.");
    }
    return partnerEntity.get();
  }

  // 모든 멤버 조회 하기
  public List<PartnerEntity> readPartnerAll() {
    return partnerRepository.findAll();
  }

  // 멤버 수정하기
  public PartnerEntity updatePartner(Long ptId, PartnerEntity newPartnerEntity) {
    Optional<PartnerEntity> partnerEntity = partnerRepository.findById(ptId);

    if (!partnerEntity.isPresent()) {
      throw new IllegalArgumentException("존재하지 않는 회원입니다.");
    }

    PartnerEntity existingPartnerEntity = partnerEntity.get();

    // 이름이 비거나, 이름이 다르면
    if (newPartnerEntity.getPtName() != null && !newPartnerEntity.getPtName().isEmpty()) {
      existingPartnerEntity.setPtName(newPartnerEntity.getPtName());
    }
    if (newPartnerEntity.getPtEmail() != null && !newPartnerEntity.getPtEmail().isEmpty()) {
      existingPartnerEntity.setPtEmail(newPartnerEntity.getPtEmail());
    }
    if (newPartnerEntity.getPtPassword() != null && !newPartnerEntity.getPtPassword().isEmpty()) {
      existingPartnerEntity.setPtPassword(newPartnerEntity.getPtPassword());
    }

    return partnerRepository.save(existingPartnerEntity);
  }

  // 멤버 삭제하기
  public void deletePartner(long ptId) {
    Optional<PartnerEntity> partnerEntity = partnerRepository.findById(ptId);
    if (!partnerEntity.isPresent()) {
      throw new IllegalArgumentException("존재하지 않는 회원입니다.");
    }
    // 사용자 삭제.
    partnerRepository.deleteById(ptId);
  }
}
