
/**
 * A queue of general Object items. Maintains the items in the FIFO order:
 * First In First Out. meaning, the first item that was pushed into the queue
 * will be the first to be popped out of the queue. 
 *  
 * @author lshaniv
 *
 */

public class GeneralQueue extends LinkedListWrapper{
	
    /**
     * Initialize the queue.
     */
	
    public GeneralQueue(){
        super();
    }
	
    /**
     * push an item to the queue.
     * 
     * @param item the Object item to add. It is assumed not null.
     */
	
    public void push(Object item) {
        _list.addLast(item);	
    }
	
    /**
     * pop the next item from the queue (remove it from the queue and return 
     * it). The popped item should be the first one that was pushed into the 
     * queue.
     * 
     *  @return the next item, or null, if the queue is empty
     */

    public Object pop() {
        return _list.pollFirst();
    }
}
