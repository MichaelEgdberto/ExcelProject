package org.um.excel.model;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class ASalFldgSpecification implements Specification<ASalFldg> {

    private ASalFldg filtro;

    public      ASalFldgSpecification(ASalFldg filtro){
        super();
        this.filtro = filtro;

    }

    @Override
    public Predicate toPredicate(Root<ASalFldg> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        Predicate p = criteriaBuilder.disjunction();

        Predicate p1 = null, p2 = null, p3 = null;

        if(filtro.getAccntCode()!=null){
            p1 = criteriaBuilder.like(root.get("accntCode"),filtro.getAccntCode().getAcntCode()+"%");
        }

        if(filtro.getAnalT0()!=null){
            p2 = criteriaBuilder.like(root.get("analT0"), filtro.getAnalT0()+"%");
        }
        if(filtro.getAnalT1()!=null){
            p2 = criteriaBuilder.like(root.get("analT1"), filtro.getAnalT1()+"%");
        }
        if(filtro.getAnalT6()!=null){
            p2 = criteriaBuilder.like(root.get("analT6"), filtro.getAnalT6()+"%");
        }

        if(filtro.getFini()!=null && filtro.getFfin()!=null){
            p3 = criteriaBuilder.between(root.<Date>get("transDatetime"),filtro.getFini(),filtro.getFfin());
        }

        p = criteriaBuilder.and(p2,p3);

        return p;
    }
}
