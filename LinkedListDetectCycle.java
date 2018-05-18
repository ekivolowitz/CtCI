package src;

class LinkedListDetectCycle {
	static boolean hasCycle(Node head) {
	    if(head == null) {
	        return false;
	    }
	    Node runner = head;
	    Node _runner = head.next;
	    while(_runner != null) {
	        if(_runner == runner)
	            return true;
	        if(_runner.next == null || runner.next.next == null)
	        	return false;
	        _runner = (_runner.next).next; 
	        runner = runner.next;
	    }
	    
	    return false;
	}
	
	public static void main(String args[]) {
		Node head = new Node(1);
		
		assert(hasCycle(head) == false);
		
		
		head.insert(2);
		head.insert(3);
		head.next.next.next = head.next;
		assert(hasCycle(head) == true);
		System.out.println("Correct output printed");
	}
}



class Node {
	int data;
	Node next;
	static Node end;
	Node(int a) {
		this.data = a;
		this.next = null;
	}
	
	@Override
	public String toString() {
		return this.data + ""; 
	}
	
	public void insert(int a) {
		Node runner = this;
		Node temp = new Node(a);
		while(runner.next != null)
			runner = runner.next;
		runner.next = temp;
		end = temp;
	}
}