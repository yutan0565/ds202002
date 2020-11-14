import java.util.Scanner;

class Queue{
	int len = 1024;
	int[] queue = new int[len];
	int front = 0 , back = 0;
	
	void push(int p) {
		queue[back] = p;
		back = (back+1)%len;
	}
	
	void pop() {
		if(front == back) {
			System.out.println("-1");
		}
		else {
			int temp = queue[front];
			front = (front+1)%len;
			System.out.println(temp);
		}
	}
	
	void front() {
		if(front == back) {
			System.out.println("-1");
		}
		else {
			System.out.println(queue[front]);
		}
	}
	
	void back() {
		if(front == back) {
			System.out.println("-1");
		}
		else {
			System.out.println(queue[back-1]);
		}
	}
	
	void size() {
		System.out.println((back - front + len) % len);
	}
	
	void empty() {
		if(front == back) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}
}


public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue queue = new Queue();
			
		
		for(int i = 0; i < N ; i++) {
			String code = sc.next();
			
			if(code.equals("push")) {
				int p  = sc.nextInt();
				queue.push(p);
				
			}
			else if(code.equals("pop")) {
				queue.pop();
				
			}
			else if(code.equals("front")) {
				queue.front();
				
			}
			else if(code.equals("back")) {
				queue.back();
				
			}
			else if(code.equals("size")) {
				queue.size();
	
			}
			else if(code.equals("empty")) {
				queue.empty();
			}	
		}
		
		
	}
}
