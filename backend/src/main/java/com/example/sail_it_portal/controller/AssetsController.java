package com.example.sail_it_portal.controller;

import com.example.sail_it_portal.dto.AssetsDTO;
import com.example.sail_it_portal.model.Assets;
import com.example.sail_it_portal.service.AssetsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/api/assets")
//@CrossOrigin(origins = "*")
//public class AssetsController {
//
//    @Autowired
//    private AssetsService assetsService;
//
//    @PostMapping("/api/assets")
//    public ResponseEntity<Assets> addAsset ( @RequestBody AssetsDTO dto) {
//
//        Assets createdAsset = assetsService.addAsset(dto);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdAsset);
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Assets> updateAsset(@PathVariable Integer id, @RequestBody AssetsDTO dto) {
//        Assets updatedAsset = assetsService.updateAsset(id,dto);
//        return ResponseEntity.ok(updatedAsset);
//    }
//    @GetMapping
//    public ResponseEntity<List<Assets>> getAllAssets() {
//        List<Assets> asset = assetsService.getAllAssets();
//        return ResponseEntity.ok(asset);
//
//    }
//    @GetMapping("{id}")
//    //id -> literal path , {id} -> variable path
//    public ResponseEntity<Assets> getAssetById(@PathVariable Integer id) {
//
//        Assets asset = assetsService.getAssetById(id);
//
//        return ResponseEntity.ok(asset);
//    }

//@RestController
//@RequestMapping("/api/assets")
//public class AssetsController {
//
//    @PostMapping
//    public String testPost(@RequestBody String rawBody) {
//        return "Backend is working! Received: " + rawBody;
//    }
//}


@RestController
@RequestMapping("/api/assets")
@CrossOrigin(origins = "*")
public class AssetsController {

    @Autowired
    private AssetsService assetsService;

    // POST: http://localhost:8080/api/assets
    @PostMapping
    @Transactional
    public ResponseEntity<Assets> addAsset(@RequestBody AssetsDTO dto) {
        // Yeh line aapke Service ke addAsset method ko trigger karegi
        Assets savedAsset = assetsService.addAsset(dto);
        return new ResponseEntity<>(savedAsset, HttpStatus.CREATED);
    }

    // GET: http://localhost:8080/api/assets
    @GetMapping
    public ResponseEntity<List<Assets>> getAllAssets() {
        return ResponseEntity.ok(assetsService.getAllAssets());
    }
}


