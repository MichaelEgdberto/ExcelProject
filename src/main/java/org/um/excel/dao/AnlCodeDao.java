package org.um.excel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.um.excel.model.AnlCode;
import org.um.excel.model.AnlCodeId;


import java.util.List;

public interface AnlCodeDao extends JpaRepository<AnlCode, AnlCodeId> {

    List<AnlCode> findByAnlCatIdAndProhibitPostingOrderByAnlCode(String anlCatId, Integer noPost);

    @Query(value = "select * from A3H_ANL_CODE where ANL_CAT_ID= ?1 and PROHIBIT_POSTING = ?2 and ANL_CODE not in ?3", nativeQuery = true)
    List<AnlCode> codigosAnalisisA3H(String anlCatId, Integer noPost, List<String> noImclude);

    List<AnlCode> findByAnlCatIdAndProhibitPostingAndAnlCodeNotInOrderByAnlCode(String anlCatId, Integer noPost, List<String> noImclude);

    AnlCode findByAnlCatIdAndAnlCodeStartingWith(String id, String code);

    List<AnlCode> findByAnlCatIdAndAnlCodeIn(String id, List<String> code);

    AnlCode findByAnlCatIdAndAndLookupStartingWith(String id, String code);



}
