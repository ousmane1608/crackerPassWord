import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BruteForceDict {
    public static String simpleDicCracher(String samaCle,int i){
        String pathcsv="dictionnnaire.csv";
        String cleFound;
        cleFound="password not found";
        String line="";
            try (BufferedReader br = new BufferedReader(new FileReader(pathcsv))) {
                while((line =br.readLine())!=null){
                    String dic=hashMD5(line,i);
                    // System.out.println(line.equals(samaCle));
                     if(dic.equals(samaCle)==true){
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

    //debut
        public static String hashMD5(String input,int i) {
            String reponse="";
            switch(i){
                case 32:
                try {
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
                    StringBuilder result = new StringBuilder();
                    for (byte b : hashBytes) {
                        result.append(String.format("%02x", b));
                    }
                   reponse= result.toString();
                   return reponse;
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                  return null;
                }
                case 40:  try {
                    MessageDigest md = MessageDigest.getInstance("SHA-1");
                    byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
                    StringBuilder result = new StringBuilder();
                    for (byte b : hashBytes) {
                        result.append(String.format("%02x", b));
                    }
                    return reponse= result.toString();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                    return null;
                }
                case 64: try {
                    MessageDigest md = MessageDigest.getInstance("SHA-256");
                    byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
                    StringBuilder result = new StringBuilder();
                    for (byte b : hashBytes) {
                        result.append(String.format("%02x", b));
                    }
                    return reponse= result.toString();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                    return null;
                }
                
            }
            return reponse;
            
        }
        //fin
     public static void main(String[] arg) {
        System.out.println(hashMD5("sowousam@12%$", 32));
        String teste="47bce5c74f589f4867dbd57e9ca9f808";
        String teste1="0935250a69afea228dc6e33da22c8bc4";
        System.out.println(simpleDicCracher(teste1,64));
      System.out.println(simpleDicCracher(teste,32));
    }
}
