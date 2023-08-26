package zerobase.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zerobase.reservation.entity.StoreEntity;
import zerobase.reservation.repository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

  @Autowired
  private StoreRepository storeRepository;

  public StoreEntity createStore(StoreEntity storeEntity){
    return storeRepository.save(storeEntity);
  }

  public Optional<StoreEntity> getStoreById(Long stId){
    return storeRepository.findById(stId);
  }

  public List<StoreEntity> getAllStore(){
    return storeRepository.findAll();
  }

  public StoreEntity updateStore(Long stId, StoreEntity storeEntity){
    if (storeRepository.existsById(stId)){
      storeEntity.setStoreId(stId);
      return storeRepository.save(storeEntity);
    }
    return null;
  }

  public void deleteStore(Long stId){
    storeRepository.deleteById(stId);
  }
}
