import java.util.ArrayList;

public class Queue {
    private ArrayList<String> list = new ArrayList<String>();

    /**
     * Pops the first element as queues use FIFO
     * @return the removed element
     */
    public String pop(){
        String removedElement = list.get(0);
        list.remove(0);
        return removedElement;
    }

    /**
     * See the front of the queue
     * @return the element at the top of the stack
     */
    public String peek(){
        if(isEmpty()){
            return "";
        }else
            return list.get(0);
    }

    /**
     * Adds the element into the queue
     * @param element That you want to add
     */
    public void push(String element){
        list.add(element);
    }

    /**
     * Check if the stack is empty
     * @return True if the stack is empty, False if the stack is not empty
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * Returns the size of the stack using size() method from LinkedList
     * @return the integer size of the stack
     */
    public int getSize(){
        return list.size();
    }

    /**
     * Checks if the stack contains an element that you want
     * @param element the element that you want to check if it exists or not
     * @return True if it is in the stack, False if it is not in the stack.
     */
    public boolean contains(String element){
        return list.contains(element);
    }

    /**
     * Returns string representation of address values in the list
     * @return meaningful string values for printing purposes
     */
    public String toString(){
        if(this.isEmpty()){
            return "Queue is empty!";
        }else {
            String finalString = "";
            for (int i = 0; i < list.size(); i++) {
                finalString += list.get(i) + " --> ";
            }
            return finalString;
        }
    }
}
