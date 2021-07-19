package org.um.excel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.um.excel.model.Acnt;

import java.util.List;

public interface AcntDao extends JpaRepository<Acnt, Integer> {

    List<Acnt> findByStatusOrderByAcntCodeAsc(Integer status);



    Acnt findByAcntCode(String acCode);

}
