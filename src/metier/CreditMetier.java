package metier;
import dao.IDao;
import lombok.* ;
import modele.Credit ;

@Data @AllArgsConstructor @NoArgsConstructor

public class CreditMetier implements IMetierCredit {
    IDao<Credit, Long> creditDao ;

    public Credit calculer_Mansualite(Long idCredit) throws Exception {
        var credit = creditDao.trouverParId(idCredit) ;
        if (credit == null)
        throw new Exception("L' id du credit est incorrect :: [Credit non trouvé]") ;
        else {
            double taux             = credit.getTaux_Mensuel() ;
                   taux             = taux / 1200  ;
            double capitale         = credit.getCapitale_Emprinte() ;
            int nbr_Mois            = credit.getNombre_Mois() ;

            double mensualité       = (capitale * taux)/(1-(Math.pow((1+taux) , -1 * nbr_Mois))) ;
                   mensualité       =Math.round(mensualité*100)/100 ;

                   credit.setMensualite(mensualité);
                   return credit ;

        }
    }

    @Override
    public Credit calculer_Mensualite(Long idCredit) throws Exception {
        return null;
    }
}
