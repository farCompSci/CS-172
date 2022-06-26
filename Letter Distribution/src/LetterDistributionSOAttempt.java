import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LetterDistributionSOAttempt {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/para1.txt"));
/// find max letter
// draw rectangles
        int[] lettersArray = new int[26];
        int[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        while (input.hasNextLine()) {
            String text = input.nextLine();
            text = text.toLowerCase();
            char[] characters = text.toCharArray();

           /* for (int i = 0; i< characters.length ; i++) {
                if((characters[i] >='a') && (characters[i]<='z')) {
                    lettersArray[characters[i] -'a' ]++;
                }

            } */
            /// change ends.

            int i=0;
            while(i<characters.length){
                int j=0;
                while(j<letters.length){
                    if(characters[i]==letters[j]){
                        lettersArray[j]++;
                        j++;
                    }
                    else{
                        j++;
                    }
                }
                i++;
            }
        }

        for (int k=0; k<26; k++) {
            System.out.println((char)letters[k] + " : " + lettersArray[k]);
        }
    }
}