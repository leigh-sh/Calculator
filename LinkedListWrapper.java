import java.util.LinkedList;

/**
 * An abstract class that wrapps a linked list of general Object items, and
 * exposes size, push and pop methods.
 * 
 * @author lshaniv
 * 
 */

public abstract class LinkedListWrapper {

    protected LinkedList<Object> _list;
    
    /**
     * Initialize the LinkedList
     */
    
    public LinkedListWrapper(){
    	_list = new LinkedList<Object>();
    }

    /**
     * How many items are in the list
     * @return the number of items
     */
    
    public int size() {
        return _list.size();
    }

    /**
     * push another item into the wrapper
     */
    
    public abstract void push(Object item);

    /**
     * pop the next item from the wrapper
     */
    
    public abstract Object pop();
}
