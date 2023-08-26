package zerobase.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zerobase.reservation.entity.StoreEntity;
import zerobase.reservation.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {
  @Autowired
  private StoreService storeService;

  @PostMapping("/create")
  public ResponseEntity<StoreEntity> createStore(@RequestBody StoreEntity store) {
    return ResponseEntity.ok(storeService.createStore(store));
  }

  @GetMapping("/read/{id}")
  public ResponseEntity<StoreEntity> getStoreById(@PathVariable Long id) {
    return storeService.getStoreById(id)
        .map(store -> ResponseEntity.ok(store))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/readAll")
  public ResponseEntity<List<StoreEntity>> getAllStores() {
    return ResponseEntity.ok(storeService.getAllStore());
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<StoreEntity> updateStore(@PathVariable Long id, @RequestBody StoreEntity updatedStore) {
    StoreEntity store = storeService.updateStore(id, updatedStore);
    if (store != null) {
      return ResponseEntity.ok(store);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
    storeService.deleteStore(id);
    return ResponseEntity.noContent().build();
  }
}
