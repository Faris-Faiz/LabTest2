import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question2OriginalAttempt {
    static String pathname = "src\\test.xml";
    Scanner x;

    public static void main(String[] args) {
        Stack tag = new Stack();

        try{
            Scanner scanner = new Scanner(new File(pathname));
            scanner.useDelimiter("[ ,\n]");
            while(scanner.hasNext()){
                String scannedItem = scanner.next();
                System.out.println(scannedItem);
                if(!scannedItem.contains("</") && (scannedItem.contains("<") || scannedItem.contains(">"))){
                    if(!tag.peek().equals(scannedItem)){
                        tag.push(scannedItem);
                    }else{
                        System.out.println("Duplicate Root Element " + scannedItem);
                    }

                }
                if(scannedItem.contains("</")){
                    String topItem = tag.peek();
                    String topItemString = topItem.substring(1, topItem.length()-1);
                    String scannedItemString = scannedItem.substring(2, scannedItem.length()-1);
                    if(topItemString.equals(scannedItemString)){
                        tag.pop();
                    }
                    if(!topItemString.equals(scannedItemString)){
                        System.out.println("Begin Element: " + topItem + "Invalid ending element -> " + scannedItem);
                    }
                }
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
}
