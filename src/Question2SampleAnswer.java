import java.io.*;
import java.util.Scanner;

public class Question2SampleAnswer {
    static String pathname = "src\\test.xml";

    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new BufferedReader(new FileReader(pathname)));
            StringBuffer sb = new StringBuffer();
            while(sc.hasNext()){
                sb.append(sc.next());
            }
            String result = sb.toString();
            System.out.println("Contents of XML file");
            System.out.println(result);
            if(isXMLMatched(result))
                System.out.println("Valid");
            System.out.println("Not Valid");
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    public static boolean isXMLMatched(String xml){
        Stack buffer = new Stack();
        int j = xml.indexOf('<'); //find first '<' character
        while(j != 1){
            int k = xml.indexOf('>', j+1);
            if(k == -1){
                return false;
            }
            String tag = xml.substring(j+1, k); //to strip away < >, ex: <html> becomes html
            if(!tag.startsWith("/")){ // for starting tags
                buffer.push(tag);
            }
            else { // for closing tags
                if(buffer.isEmpty()){
                    return false; // no tag to match
                }
                if(!tag.substring(1).equals(buffer.pop())){
                    return false; // for mismatched tag
                }
            }
            j = xml.indexOf('<', k+1);
        }
        return buffer.isEmpty(); // were all opening tags properly matched with closing tags?
    }
}
