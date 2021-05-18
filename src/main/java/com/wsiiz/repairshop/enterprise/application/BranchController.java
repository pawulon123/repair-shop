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
    public ResponseEntity<Branch> addNew(
            @RequestBody Branch branch
    ) {
        branch.getEmployees().forEach(e -> e.setBranch(branch));
        return ResponseEntity.created(null).body(branchRepository.save(branch));
    }
    @GetMapping("/branch/{id}")
    public Optional<Branch> getOne(@PathVariable("id") Long id) {
        return branchRepository.findById(id);
    }

   @GetMapping("/branch/")
   public ResponseEntity<List<Branch>> getMany(
           @RequestParam(value = "city", required = false) String city,
           @RequestParam(value = "parent", required = false) Long parentId
   ) {
       List<Branch> Branches = this.familyForCityAndParentId(city, parentId);
       return ResponseEntity.ok(Branches);
   }
   private List<Branch> familyForCityAndParentId(String city, Long  parentId) {

       List<Branch> branches ;
       if (city == null && parentId == null) {
           branches = this.assignParent(branchRepository.findAll());
       }else if (city != null && parentId == null) {
           branches = branchRepository.findByCity(city);
       }else if (parentId != null && city == null) {
           branches= this.assignParent(branchRepository.findByParentId(parentId), branchRepository.findById(parentId));
       }else{
           branches = this.assignParent(branchRepository.findByParentIdAndCity(parentId, city), branchRepository.findById(parentId));
       }
       branches = this.assignChild(branches);
       return branches;
   }
    private List<Branch> assignChild(List<Branch> branches){
        branches.forEach(b -> { if (b.getChildId() != null) { b.setChild(branchRepository.findById(b.getChildId()));}});
        return  branches;
    }
   private List<Branch> assignParent(List<Branch> branches){
        branches.forEach(b -> { if (b.getParentId() != null) { b.setParent(branchRepository.findById(b.getParentId()));}});
        return  branches;
   }
    private List<Branch> assignParent(List<Branch> branches, Optional<Branch> branch){
        branches.forEach(b -> b.setParent(branch));
        return  branches;
    }
    @DeleteMapping("/branch/{id}")
    public ResponseEntity<ResponseEntity> remove(@PathVariable("id") Long id) {
        return this.deleteById(id);
//
    }
    private ResponseEntity<ResponseEntity> deleteById(Long id){
        Optional<Branch> branch = branchRepository.findById(id);
        if (branch.isPresent()) {
            branchRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
