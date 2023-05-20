import java.security.MessageDigest;
import java.util.Scanner;

import javax.print.event.PrintEvent;

public class Force {
    public static boolean compare(String chaine, char[] tableau) {
        if (tableau.length != chaine.length()) {
            return false;
        }

        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] != chaine.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean combinaisonLetter(char[] combine, int length, int position, String password) {
        if (position == length) {
            return compare(password, combine);
        } else {
            boolean cle = false;

            // Variable de contrôle
            boolean codeExecute = false;

            for (int i = 97; i < 97 + 26; i++) {
                combine[position] = (char) i;
                cle = combinaisonLetter(combine, length, position + 1, password);

                if (!codeExecute && cle) {
                    System.out.println(!codeExecute);
                    codeExecute = true;
                }
            }

            return cle;
        }
    }

    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);
        System.out.println(".....>donner le mode de passe a cracker");
        String motDePasse= scanner.next();
         scanner.close();

        char[] letre = new char[motDePasse.length()];
        combinaisonLetter(letre, motDePasse.length(), 0, motDePasse);
    }
}

    
   




 
       
  