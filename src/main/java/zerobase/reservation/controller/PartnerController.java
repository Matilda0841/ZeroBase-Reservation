package zerobase.reservation.controller;

import zerobase.reservation.entity.PartnerEntity;
import zerobase.reservation.service.PartnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/member")
@RestController
public class PartnerController {

  @Autowired
  private PartnerService partnerService;

  // 사용자 생성
  @PostMapping("/create")
  public PartnerEntity createPartner(@RequestBody PartnerEntity partnerEntity) {
    return partnerService.createPartner(partnerEntity);
  }

  // 모든 사용자 조회
  @GetMapping("/readAll")
  public List<PartnerEntity> getAllPartner() {
    return partnerService.readPartnerAll();
  }

  // 특정 사용자 조회
  @GetMapping("/read/{id}")
  public PartnerEntity getPartner(@PathVariable Long ptId){
    return partnerService.readPartner(ptId);
  }

  // 사용자 업데이트
  @PutMapping("/update/{id}")
  public PartnerEntity updateMember(@PathVariable Long ptId ,@RequestBody PartnerEntity partnerEntity){
    return partnerService.updatePartner(ptId,partnerEntity);
  }

  // 사용자 삭제하기
  @DeleteMapping("//delete/{id}")
  public void deleteMember(@PathVariable Long ptId){
    partnerService.deletePartner(ptId);
  }
}

