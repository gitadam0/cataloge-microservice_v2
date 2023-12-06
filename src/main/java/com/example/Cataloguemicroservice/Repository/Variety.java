package com.example.Cataloguemicroservice.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class Variety {

        EntityManager em;

        // construc
    // to
        List<Variety> findVarietysByProductEmpty(Long idVariety) {

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Variety> cq = cb.createQuery(Variety.class);



        }



    }
}
