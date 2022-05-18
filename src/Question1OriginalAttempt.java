import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question1OriginalAttempt {
    static String pathname = "src\\labtest2.txt";

    public static void main(String[] args) {
        Queue productCode = new Queue();
        Queue products = new Queue();

        try{
            Scanner scanner = new Scanner(new File(pathname));
            scanner.useDelimiter("[ ,\n]");
            while (scanner.hasNext()){
                String item = scanner.next();
                if(item.charAt(0) == 'P' && item.charAt(1) == '0'){
                    productCode.push(item);
                }
                else if(item.equals("\r")){
                    continue;
                }
                else {
                    products.push(item);
                }
            }
            scanner.close();

            System.out.println("Product Code in Queue : P03 ---> P02 ---> P06 ---> P04 --->");
            System.out.println("List of products by categories");

            Queue P03 = new Queue();
            Queue P03Products = new Queue();

            Queue P02 = new Queue();
            Queue P02Products = new Queue();

            Queue P06 = new Queue();
            Queue P06Products = new Queue();

            Queue P04 = new Queue();
            Queue P04Products = new Queue();

            while(!productCode.isEmpty() && !products.isEmpty()){
                if(productCode.peek().equals("P03")){
                    productCode.pop();
                    P03Products.push(products.pop());
                }
                if(productCode.peek().equals("P02")){
                    productCode.pop();
                    P02Products.push(products.pop());
                }
                if(productCode.peek().equals("P06")){
                    productCode.pop();
                    P06Products.push(products.pop());
                }
                if(productCode.peek().equals("P04")){
                    productCode.pop();
                    P04Products.push(products.pop());
                }
            }

            System.out.println("Product: P03");
            System.out.println(P03Products);
            System.out.println("Product: P02");
            System.out.println(P02Products);
            System.out.println("Product: P06");
            System.out.println(P06Products);
            System.out.println("Product: P04");
            System.out.println(P04Products);

        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
}
