/**
 * Created by sebito on 26-05-16.
 */
public class MyUtils {
     public static char[] getCharacters(String input){
         boolean[] isItThere = new boolean[Character.MAX_VALUE];
         for (int i = 0; i < input.length(); i++) {
             isItThere[input.charAt(i)] = true;
         }

         int count = 0;
         for (int i = 0; i < isItThere.length; i++) {
             if (isItThere[i] == true){
                 count++;
             }
         }

         char[] chars = new char[count];
         int position = 0;
         for (int i = 0; i < isItThere.length; i++) {
             if (isItThere[i] == true){
                 chars[position] = (char) i;
                 position++;
             }
         }

         return chars;
     }
}
