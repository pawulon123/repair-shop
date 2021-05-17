package com.wsiiz.repairshop.enterprise.application;

import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import com.wsiiz.repairshop.enterprise.domain.branch.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class BranchController {
    @Autowired
    BranchRepository branchRepository;

    @PostMapping("/branch")
    public ResponseEntity<Branch> addNew(@RequestBody Branch branch) {
//      userAccount.getRoles().forEach(r -> r.setUserAccount(userAccount));
        return ResponseEntity.created(null).body(branchRepository.save(branch));
    }
    @GetMapping("/branch/{id}")
    public Optional<Branch> getOne(@PathVariable("id") Long id) {
        return branchRepository.findById(id);
    }

   @GetMapping("/branch")
   public ResponseEntity<List<Branch>> getMany(
           @RequestParam(value = "city", required = false) String city,
           @RequestParam(value = "parent", required = false) Long parentId
   ) {
        if (city == null && parentId == null) {
            return ResponseEntity.ok(branchRepository.findAll());
        }else if (city != null && parentId == null){
            return ResponseEntity.ok(branchRepository.findByCity(city));
        }else if (parentId != null && city == null){
            return ResponseEntity.ok(branchRepository.findByParentId(parentId));
        }else{
            return ResponseEntity.ok(branchRepository.findByParentIdAndCity(parentId, city));
        }
   }
    @DeleteMapping("/branch/{id}")
    public ResponseEntity<ResponseEntity> remove(@PathVariable("id") Long id) {
        Optional<Branch> branch = branchRepository.findById(id);
        if (branch.isPresent()) {
            branchRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
