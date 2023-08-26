package zerobase.reservation.test.controller;

import zerobase.reservation.test.entity.Test;
import zerobase.reservation.test.dto.TestDto;
import zerobase.reservation.test.repository.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired
  private TestRepository testRepository;

  @GetMapping("/test")
  public Iterable<Test> get(){
    System.out.println("get");
    Iterable<Test> all = testRepository.findAll();
    return all;
  }

  @PostMapping("/test")
  public String post(@RequestBody TestDto testDto){
    System.out.println(testDto.toString());

    Test test = testDto.toEntity();
    System.out.println(test.toString());

    Test saved = testRepository.save(test);
    System.out.println(saved.toString());

    return "";
  }
}
