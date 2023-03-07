package presentation;
import lombok.* ;
import metier.IMetierCredit;

@Data @AllArgsConstructor @NoArgsConstructor
public class CreditControleur implements ICreditControleur{


    IMetierCredit creditMetier ;


    @Override
    public void afficher_Mensualite(Long idCredit)throws Exception{
        var creditAvecMensualite  = creditMetier.calculer_Mensualite(idCredit) ;
        System.out.println(creditAvecMensualite);
    }

}
