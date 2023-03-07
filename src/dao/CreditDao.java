package dao;

import modele.Credit;

import java.util.*;

public class CreditDao implements IDao<Credit , Long>{

    public static Set<Credit> DBCredits() {

        return new HashSet<Credit>(
                Arrays.asList(
                        new Credit(1L, 10000.0, 120, 2.5, "amina", 0.0),
                        new Credit(2L, 850000.0, 240, 2.5, "Tarek", 0.0),
                        new Credit(3L, 020000.0, 030, 1.5, "sarah", 5.0),
                        new Credit(4L, 065000.0, 040, 2.0, "Tanae", 0.0)

                ));
    }

    @Override
    public Credit trouverParId(Long id){
        System.out.println("[DAO = DS volatile ] trouver le credit n' :"+ id);
        return      DBCredits()
                .stream()
                .filter(credit -> credit.getId() == id)
                .findFirst()
                .orElse(null) ;
    }



}
