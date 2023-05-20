import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class BruteForce {
    public static boolean compare(String chaine1, String chaine2) {
        if (chaine1.length() != chaine2.length()) {
            return false;
        }

        for (int i = 0; i < chaine1.length(); i++) {
            if (chaine1.charAt(i)!= chaine2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean combinaisonLetter(char[] combine, int length, int position, String password) {
        String md5Hash ;
        if (position == length) {
            String candidate = new String(combine);
            md5Hash = hashMD5(candidate,password.length());
             return compare(md5Hash, password);// || sha1Hash.equals(password) || sha256Hash.equals(password);
        } else {
            boolean cle = false;
            boolean codeExecute = false;
            for (int i = 97; i < 97 + 20; i++) {
                combine[position] = (char) i;
                cle = combinaisonLetter(combine, length, position + 1, password);
                if (!codeExecute && cle) {
                    System.out.println(combine);
                    codeExecute = true;
                     // Si la combinaison a été trouvée, on arrête la récursion et renvoie true
                }
            }

            return cle;
        }
    }

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

    public static void main(String[] args) {
        char[] lettre;
        Scanner scanner=new Scanner(System.in);
        System.out.println(".....>donner le mode de passe a cracker");
        String motDePasse= scanner.next();
        System.out.println(".....>donner le nombre de caractere du mot de passe");
        int  longPassWord= scanner.nextInt();
         scanner.close();
         lettre=new char[longPassWord];
          combinaisonLetter(lettre,longPassWord, 0, motDePasse);
    //    System.out.println(hashMD5("aaa", 40)); 
    //     System.out.println(hashMD5("aaa", 64));
            // 47bce5c74f589f4867dbd57e9ca9f808
            // 7e240de74fb1ed08fa08d38063f6a6a91462a815
            // 9834876dcfb05cb167a5c24953eba58c4ac89b1adf57f28f2f9d09af107ee8f0
    }
}
