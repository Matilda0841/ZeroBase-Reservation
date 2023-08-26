package zerobase.reservation.controller;

import zerobase.reservation.entity.MemberEntity;
import zerobase.reservation.service.MemberService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequestMapping("/member")
@RestController
public class MemberController {

  @Autowired
  private MemberService memberService;

  // 사용자 생성
  @PostMapping("/create")
  public MemberEntity createMember(@RequestBody MemberEntity memberEntity) {
    return memberService.createMember(memberEntity);
  }

  // 모든 사용자 조회
  @GetMapping("/readAll")
  public List<MemberEntity> getAllMember() {
    return memberService.readMemberAll();
  }

  // 특정 사용자 조회
  @GetMapping("/read")
  public MemberEntity getMember(@PathVariable Long mbId){
    return memberService.readMember(mbId);
  }

  // 사용자 업데이트
  @PutMapping("/update")
  public MemberEntity updateMember(@PathVariable Long mbId ,@RequestBody MemberEntity memberEntity){
    return memberService.updateMember(mbId,memberEntity);
  }

  // 사용자 삭제하기
  @DeleteMapping("/delete")
  public void deleteMember(@PathVariable Long mbId){
    memberService.deleteMember(mbId);
  }
}

