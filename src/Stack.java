import java.util.ArrayList;

public class Stack {
    private ArrayList<String> list = new ArrayList<String>();

    /**
     * Pops the last element as stacks use LIFO
     * @return the removed element
     */
    public String pop(){
        String removedElement = list.get(list.size() - 1);
        list.remove(list.size()-1);
        return removedElement;
    }

    /**
     * See the top of the stack
     * @return the element at the top of the stack
     */
    public String peek(){
        if(isEmpty()){
            return "";
        }else
            return list.get(getSize() - 1);
    }

    /**
     * Adds the element onto the stack
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
        return list.toString();
    }
}
