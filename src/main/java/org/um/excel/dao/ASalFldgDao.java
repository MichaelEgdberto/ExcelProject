package org.um.excel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.um.excel.model.ASalFldg;
import org.um.excel.model.ASalFldgId;


import java.util.List;

public interface ASalFldgDao extends JpaRepository<ASalFldg, ASalFldgId> {

        List<ASalFldg> findByJrnalNoAndAllocationNotOrderByJrnalLine(Integer jrnalNo, String allocation);

        @Query(value = "select * from dbo.[A3L_A_SALFLDG] WHERE [JRNAL_NO]= ?1 AND [ALLOCATION]<>'C' ORDER BY [JRNAL_LINE]", nativeQuery = true)
        List<ASalFldg> buscaPoliza(Integer jrnalNo);

}
