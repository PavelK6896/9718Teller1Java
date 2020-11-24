package app.web.pavelk.teller1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReportsCustom {

    @PersistenceContext
    private EntityManager em;

    public List<Object[]> testQueryNativeRequest() {

        List<Object[]> list = em.createNativeQuery("SELECT cs.number, cs.active FROM cars as cs ").getResultList();

        list.forEach(o -> {
            System.out.println(o[0]);
            System.out.println(o[1]);
        });

        return list;
    }

    @Transactional
    public List<Object[]> testQueryNativeRequestInsert() {
        int i = em.createNativeQuery(
                "insert into cars (number, code, active) values ('555', '1111', true)")
                .executeUpdate();

        System.out.println("insert int " + i );
        return null;
    }


    public List<Object[]> testQueryNativeRequest2() {

        List<Object[]> list = em.createNativeQuery(
                "SELECT cs.number, " +
                        "sum(case when cs.active = true then 1 else 0 end) " +
                        "FROM cars as cs " +
                        "group by cs.number"

        ).getResultList();

        list.forEach(o -> {
            System.out.println(o[0]);
            System.out.println(o[1]);
        });
        return list;
    }
}
