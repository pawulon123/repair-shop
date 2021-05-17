package com.wsiiz.repairshop.enterprise.domain.branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    @Query(value = "SELECT * FROM BRANCH WHERE STATIONING_CITY = :city", nativeQuery = true)
    List<Branch> findByCity(@Param("city")String  stationingCity );

    List<Branch> findByParentId(Long parentId);

    @Query(value = "SELECT * FROM BRANCH WHERE PARENT_ID = :id AND STATIONING_CITY = :city", nativeQuery = true)
    List<Branch> findByParentIdAndCity(@Param("id")Long id, @Param("city")String  stationingCity);
}
