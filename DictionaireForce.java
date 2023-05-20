import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaireForce {
    public static String simpleDicCracher(String samaCle){
        String pathcsv="dictionnnaire.csv";
        String cleFound;
        cleFound="password not found";
        String line="";
            try (BufferedReader br = new BufferedReader(new FileReader(pathcsv))) {
                while((line =br.readLine())!=null){
                   
                     if(line.equals(samaCle)==true){
                        System.out.print("mot de passe retrouver: ");
                        cleFound=line;
                    //     return cleFound;
                     }
                    // System.out.println(line);
                   
                }
            }catch (IOException e) {
                e.printStackTrace();
                // return cleFound;
            }
            return cleFound;
        } 
     public static void main(String[] arg) {
        String teste="aaa";
      System.out.println(simpleDicCracher(teste));
    }
}
