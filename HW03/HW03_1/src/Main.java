import java.util.Random;
import java.util.Scanner;

/*
������ ���� �˰������� ���ڵ� �����ϴ� ���� �����մϴ�.

a) ť�� ������ �����մϴ�.

b) ���� n�� �Է¹޽��ϴ�.

c) ť�� n���� ������ ���ڵ��� �ֽ��ϴ�.  ������ ���ڴ� 0~10000 ������ �մϴ�.

d) ť���� ���� �ϳ��� �����ϴ�.

e) ���� �ֻ��� ���ڰ� ť���� ���� ���ں��� ���� ���, ���ÿ��� ���ڸ� ���� ť�� �ֽ��ϴ�.

f) ������ ����ְų� ���� �ֻ��� ���ڰ� ť���� ���� ���ں��� Ŭ������ e)�� �ݺ��մϴ�.

g) ���ÿ� ť���� ���� ���ڸ� �ӽ��ϴ�.

h) ť�� ������� �ʴٸ� d)�� ���� ������ ����մϴ�.

i) ���ÿ� �ִµ����͸� �ϳ��� �����鼭 �����͸� ����մϴ�. 
*/


public class Main {
	
	static void cal(int n) {
		Random rand = new Random();
		
		// a) ť�� ������ �����մϴ�.
		int[] queue = new int[n*100];
		int head =0, tail = 0;
		
		//���� ����
		int[] stack = new int[n*100];
		int top = -1;
		
		// c) ť�� n���� ������ ���ڵ��� �ֽ��ϴ�.  ������ ���ڴ� 0~10000 ������ �մϴ�.
		System.out.println("�Է� Queue");
		for(int i = 0; i < n ; i++) {
			queue[tail] = rand.nextInt(10001);
			System.out.print(queue[tail]+" ");
			tail = (tail+1)%(n*2);
		}
		System.out.println("");
		
		// h) ť�� ������� �ʴٸ� d)�� ���� ������ ����մϴ�.
	      while(head!=tail) {   
	    	  // d) ť���� ���� �ϳ��� �����ϴ�.
	          int temp = queue[head];   
	          queue[head]=0;             
	          head = (head+1)%(n*2);      
       
	          // f) ������ ����ְų� ���� �ֻ��� ���ڰ� ť���� ���� ���ں��� Ŭ������ e)�� �ݺ��մϴ�.
	          while(top!=-1 && stack[top]<temp) {  
	        	  
	        	// e) ���� �ֻ��� ���ڰ� ť���� ���� ���ں��� ���� ���, ���ÿ��� ���ڸ� ���� ť�� �ֽ��ϴ�.
	             queue[tail]=stack[top--];    
	             tail=(tail+1)%(n*2);      
	          }
	          
	          // g) ���ÿ� ť���� ���� ���ڸ� �ӽ��ϴ�.
	          stack[++top]=temp;    
	       }
			
		
		// i) ���ÿ� �ִµ����͸� �ϳ��� �����鼭 �����͸� ����մϴ�. 
	    System.out.println("���� Queue");
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
		// b) ���� n�� �Է¹޽��ϴ�.
		int N = sc.nextInt();
		cal(N);
		
		
	}

}
