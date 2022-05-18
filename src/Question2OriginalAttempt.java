import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// DISCLAIMER: THIS ONLY WORKS ON THE FIRST EXAMPLE, THE OTHER EXAMPLES I DIDN'T HAVE TIME TO TEST IT ON


public class Question2OriginalAttempt {
    static String pathname = "src\\test.xml";
    Scanner x;

    public static void main(String[] args) {
        Stack tag = new Stack(); // Stack to contain the valid tags

        try{
            Scanner scanner = new Scanner(new File(pathname));
            scanner.useDelimiter("[ ,\n]");
            while(scanner.hasNext()){
                String scannedItem = scanner.next();
                System.out.println(scannedItem);
                if(!scannedItem.contains("</") && (scannedItem.contains("<") || scannedItem.contains(">"))){ // to only get the opening tags
                    if(!tag.peek().equals(scannedItem)){
                        tag.push(scannedItem);
                    }else{
                        System.out.println("Duplicate Root Element " + scannedItem);
                    }

                }
                if(scannedItem.contains("</")){ // to receive the closing tags
                    String topItem = tag.peek(); // to retrieve the top item in the stack
                    String topItemString = topItem.substring(1, topItem.length()-1); // to only retrieve the text
                                                                                     // of top stack, ex: from <html>
                                                                                     // becomes html only
                    String scannedItemString = scannedItem.substring(2, scannedItem.length()-1); // to see if the closing
                                                                                                 // tags have the same
                                                                                                 // text as the opening
                                                                                                 // texts which are
                                                                                                 // in the stack
                                                                                                 // ex: <html> and </html>
                                                                                                 // are the same tags due
                                                                                                 // to the same text inside
                    if(topItemString.equals(scannedItemString)){ // if they are equal, then its ok
                        tag.pop();
                    }
                    if(!topItemString.equals(scannedItemString)){
                        System.out.println("Begin Element: " + topItem + "Invalid ending element -> " + scannedItem);
                    } // if it's not, then it's an error.
                }
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
}
