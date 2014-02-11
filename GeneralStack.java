
/**
 * A stack of general Object items. Maintains the items in the LIFO order:
 * Last In First Out. meaning, the last item that was pushed into the stack
 * will be the first to be popped out of the stack.
 * 
 * @author lshaniv
 *
 */

public class GeneralStack extends LinkedListWrapper {
	
    /**
     * Initialize the stack
     */
	
    public GeneralStack(){
        super();
    }
	
    /**
     * push an item to the stack
     * 
     * @param item the Object item to add. It is assumed not null.
     */
	
    public void push(Object item) {
        _list.addLast(item);
    }
	
    /**
     * pop the next item from the stack (remove it from the stack and return
     * it). The popped item should be the last one that was pushed into the 
     * stack.
     * 
     * @return the next item, or null, if the stack is empty
     */

    public Object pop() {
        return _list.pollLast();
    }
}
