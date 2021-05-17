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
    public ResponseEntity<List<Branch>> getMany(){
        return ResponseEntity.ok(branchRepository.findAll());
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
