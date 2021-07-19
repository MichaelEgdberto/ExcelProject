package org.um.excel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.um.excel.model.ASalFldg;
import org.um.excel.model.ASalFldgId;


public interface MovimientosSPCustom extends JpaRepository<ASalFldg, ASalFldgId>, JpaSpecificationExecutor<ASalFldg> {


}
