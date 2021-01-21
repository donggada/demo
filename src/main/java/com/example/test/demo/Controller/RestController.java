package com.example.test.demo.Controller;

import com.example.test.demo.DTO.BusinessTimesDTO;
import com.example.test.demo.DTO.ListDTO;
import com.example.test.demo.DTO.ListDetailDTO;
import com.example.test.demo.Entity.Store;
import com.example.test.demo.DTO.StoreDTO;
import com.example.test.demo.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController

public class RestController {
    @Autowired
    StoreService storeService;
    //점포추가API
    @PostMapping("/storesave")//,
    public Store save(@RequestBody StoreDTO storeDTO) {
        return storeService.save(storeDTO);

    }
    //점포휴무일등록API
    @PutMapping("/holidayssave")
    public int holidayssave(@RequestBody StoreDTO storeDTO ){
        return storeService.holidayssave(storeDTO);
    }
    //점포목록조회API
    @GetMapping("/list")
    public ArrayList<ListDTO> list ()throws Exception{
        return storeService.list();
    }
    //점포상세정보조회API
    @GetMapping("/listdetail/{id}")
    public ListDetailDTO listdetail(@PathVariable(name = "id") Long id)throws Exception{
        return storeService.listdetail(id);
    }
    //점포 삭제 API
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable(name = "id") Long id){
         storeService.delete(id);
    }

}
