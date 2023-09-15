package com.example.resource_project.Repository;


import com.example.resource_project.Entity.ResourcePriceInfoTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResourceInfoRepository extends JpaRepository<ResourcePriceInfoTb, Integer> {
    @Query("SELECT i, r, u " +
            "FROM ResourcePriceInfoTb i LEFT OUTER JOIN ResourceTb r on i.resourceIdMk = r " +
            "LEFT OUTER JOIN UnitTb u on i.unitIdFk = u"
            )
    List<ResourcePriceInfoTb> getInfoAll();

//    "SELECT b, w, count(r) " +
//            " FROM Board b LEFT JOIN b.writer w " +
//            " LEFT OUTER JOIN Reply r ON r.board = b" +
//            " WHERE b.bno = :bno"

}
