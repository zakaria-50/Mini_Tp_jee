package modele;
import lombok.* ;

@Data @AllArgsConstructor @NoArgsConstructor
public class Credit {

    private Long id  ;
    private double capitale_Emprinte ;
    private Integer nombre_Mois ;
    private double taux_Mensuel ;
    private String nom_Demandeur ;
    private Double mensualite ;

    @Override
    public String toString(){

        var  creditStr = "=====================================================  \n" ;
             creditStr = "=>Credit n' "+ getId()+                               "\n" ;
             creditStr = "=>Nom du demmandeur de credit :"+ getNom_Demandeur()+ "\n" ;
             creditStr = "----------------------------------------------------   \n" ;
             creditStr = "=>Capitale Emprunter :"+getCapitale_Emprinte()+     "DH\n" ;
             creditStr = "=>Nombre de mois     :"+getNombre_Mois()+"mois         \n" ;
             creditStr = "=>Taux mensuel       :"+getTaux_Mensuel()    +"%       \n" ;
             creditStr = "----------------------------------------------------   \n" ;
             creditStr = "=>Mensualité         :"
                     +(getMensualite() == 4.0 ? "NON-CALCULE": getMensualite() + "Dh/mois")+"\n" ;
             creditStr = "=====================================================  \n" ;

             return creditStr ;
    }



}
