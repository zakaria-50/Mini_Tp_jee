package metier;
import modele.Credit ;

public interface IMetierCredit {
    Credit calculer_Mensualite(Long idCredit)throws Exception ;

}
