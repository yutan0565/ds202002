import java.util.Random;
import java.util.Scanner;

/*
다음과 같은 알고리즘으로 숫자들 정렬하는 것을 수행합니다.

a) 큐와 스택을 생성합니다.

b) 숫자 n을 입력받습니다.

c) 큐에 n개의 랜덤한 숫자들을 넣습니다.  랜덤한 숫자는 0~10000 범위로 합니다.

d) 큐에서 숫자 하나를 꺼냅니다.

e) 스택 최상위 숫자가 큐에서 꺼낸 숫자보다 작은 경우, 스택에서 숫자를 꺼내 큐에 넣습니다.

f) 스택이 비어있거나 스택 최상위 숫자가 큐에서 꺼낸 숫자보다 클때까지 e)를 반복합니다.

g) 스택에 큐에서 꺼낸 숫자를 넛습니다.

h) 큐가 비어있지 않다면 d)로 가서 수행을 계속합니다.

i) 스택에 있는데이터를 하나씩 꺼내면서 데이터를 출력합니다. 
*/


public class Main {
	
	static void cal(int n) {
		Random rand = new Random();
		
		// a) 큐와 스택을 생성합니다.
		int[] queue = new int[n*100];
		int head =0, tail = 0;
		
		//스택 생성
		int[] stack = new int[n*100];
		int top = -1;
		
		// c) 큐에 n개의 랜덤한 숫자들을 넣습니다.  랜덤한 숫자는 0~10000 범위로 합니다.
		System.out.println("입력 Queue");
		for(int i = 0; i < n ; i++) {
			queue[tail] = rand.nextInt(10001);
			System.out.print(queue[tail]+" ");
			tail = (tail+1)%(n*2);
		}
		System.out.println("");
		
		// h) 큐가 비어있지 않다면 d)로 가서 수행을 계속합니다.
	      while(head!=tail) {   
	    	  // d) 큐에서 숫자 하나를 꺼냅니다.
	          int temp = queue[head];   
	          queue[head]=0;             
	          head = (head+1)%(n*2);      
       
	          // f) 스택이 비어있거나 스택 최상위 숫자가 큐에서 꺼낸 숫자보다 클때까지 e)를 반복합니다.
	          while(top!=-1 && stack[top]<temp) {  
	        	  
	        	// e) 스택 최상위 숫자가 큐에서 꺼낸 숫자보다 작은 경우, 스택에서 숫자를 꺼내 큐에 넣습니다.
	             queue[tail]=stack[top--];    
	             tail=(tail+1)%(n*2);      
	          }
	          
	          // g) 스택에 큐에서 꺼낸 숫자를 넛습니다.
	          stack[++top]=temp;    
	       }
			
		
		// i) 스택에 있는데이터를 하나씩 꺼내면서 데이터를 출력합니다. 
	    System.out.println("정렬 Queue");
		while( true){
			System.out.print(stack[top]+" ");
			top--;
			if(top==-1) {
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		// b) 숫자 n을 입력받습니다.
		int N = sc.nextInt();
		cal(N);
		
		
	}

}
