import dao.CreditDao ;
import dao.IDao;
import metier.CreditMetier ;
import metier.IMetierCredit;
import modele.Credit;
import presentation.CreditControleur ;
import presentation.ICreditControleur;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner ;
public class SimulateurDeCredit_App {
    static ICreditControleur creditControleur ;

    public static void test2 () throws Exception{
        String daoClass ;
        String serviceClass ;
        String controllerClass ;

        Properties properties = new Properties() ;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader() ;
        InputStream propertiesFile = classLoader.getResourceAsStream("config-properties") ;

        if (propertiesFile == null) throw new Exception("fichier config introuvable!!!") ;
        else {
            try {
                properties.load(propertiesFile) ;
                daoClass        =properties.getProperty("DAO");
                serviceClass    = properties.getProperty("SERVICE");
                controllerClass = properties.getProperty("CONTROLLER");
                propertiesFile.close();
            }
            catch (IOException e){
                throw new Exception("Probleme du chargement des propriétaire du fichier config ") ;
            }
            finally {
                properties.clear();
            }
        }
        try {
            Class cDao              = Class.forName(daoClass) ;
            Class cMetier           = Class.forName(serviceClass) ;
            Class cControleur       = Class.forName(controllerClass) ;

            var dao              = (IDao<Credit , Long>)cDao.getDeclaredConstructor().newInstance() ;
            var metier           = (IMetierCredit)   cMetier.getDeclaredConstructor().newInstance() ;
            creditControleur     = (ICreditControleur) cControleur.getDeclaredConstructor().newInstance() ;

            Method setDao  = cMetier.getMethod("setCreditDao" , IMetierCredit.class) ;
            setDao.invoke(metier , dao) ;


            Method setMetier     = cControleur.getMethod("setCreditMetier" , IMetierCredit.class) ;
            setMetier.invoke(creditControleur , metier) ;


            creditControleur.afficher_Mensualite(1L);


        }
        catch (Exception e){
            e.printStackTrace();
        }
        /*

        var dao = new CreditDao() ;
        var metier = new CreditMetier() ;
        var controleur =  new CreditControleur() ;

        metier          .setCreditDao(dao);
        controleur      .setCreditMetier(metier);

        String rep = "";
        do {
            System.out.println("=> [Test 1] calcule de Menbsualité de credit <=\n");
            try {
                String input = "";
                while (true){
                    System.out.println("=> Entrer l'id du crédit : ");
                    input = clavier.nextLine() ;
                    if (estUnNombre(input)) break;
                    System.err.println("Entrer non valide !!!");
                }
                long id = Long.parseLong(input) ;
                controleur.afficher_Mensualite(id);
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            System.out.println("Voulez vous quitter (oui/non) ? "); rep = clavier.nextLine() ;
        }while (! rep.equalsIgnoreCase("oui")) ;
        System.out.println("Au revoir o_o");
*/
    }

    public static void main (String[] args)throws Exception{ test2();}




    static Scanner clavier  = new Scanner(System.in) ;
    private static boolean estUnNombre(String input){
        try                 {Integer.parseInt(input) ; return true ;}
        catch (Exception e) {return false ;} }

    public static void test1(){
        var dao = new CreditDao() ;
        var metier = new CreditMetier() ;
        var controleur =  new CreditControleur() ;

        metier          .setCreditDao(dao);
        controleur      .setCreditMetier(metier);

        String rep = "";
        do {
            System.out.println("=> [Test 1] calcule de Menbsualité de credit <=\n");
            try {
                String input = "";
                while (true){
                    System.out.println("=> Entrer l'id du crédit : ");
                    input = clavier.nextLine() ;
                    if (estUnNombre(input)) break;
                    System.err.println("Entrer non valide !!!");
                }
                long id = Long.parseLong(input) ;
                controleur.afficher_Mensualite(id);
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            System.out.println("Voulez vous quitter (oui/non) ? "); rep = clavier.nextLine() ;
        }while (! rep.equalsIgnoreCase("oui")) ;
        System.out.println("Au revoir o_o");

    }

}
