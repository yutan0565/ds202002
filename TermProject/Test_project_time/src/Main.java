import java.util.Scanner;
import java.util.Random;
//rand.nextInt()

/////////////�ð� ������

//���� 1
// N�� ���� a, b�� �Է¹ް�, ������������α׷����ۼ��մϴ�.
// N���� �����͸� �����Լ��� �����մϴ�.
// a, b ������ �ּҰ� �ִ밪 �հ踦 ���ؼ� ����մϴ�.


//���ڵ��� ���� �ϴ� ���
//1. min, max ���Ѵ��� �ϳ��� ���ϱ�
//2. ���� ����
//3. �պ� ����
//4. �� ����



public class Main {
	static int random_number1;
	static int random_number2;
	static int a;
	static int b;
	static int[] new_array;
	static int j;
		
	//���� ���
	// 1. �⺻ ���� ��� ���
	static int[] original(int[] new_array) {
		for(int i=0; i< new_array.length;i++) {
			for(int p = 0; p< new_array.length-1;p++) {
				if(new_array[p]>new_array[p+1]) {
					int temp = new_array[p];
					new_array[p] = new_array[p+1];
					new_array[p+1] = temp;
				}
			}
		}		
		return new_array;		
	}
	
	
	// �հ� ���
	static long sum_1(int[] new_array) {
		long sum = 0;
		for(int i = 0 ; i < new_array.length ; i++) {
			sum += new_array[i];
		}
		return sum;
	}
	
	
	// �ִ�, �ּ�, �հ� ���ϱ�
	static long max_min_sum(int N, int K) {
		long t = System.currentTimeMillis();
		
		Random rand = new Random();
		long sum = 0;

		//�迭 �����
		int[] array = new int[N];
		for(int i = 0 ; i < N ; i++ ) {
			array[i] = rand.nextInt();
		}

		
		
		//���� �� ������ ���� �迭 �����		
		//���۰� �� ������ ���� ������ �����ϱ�	
		for(int k = 0 ; k < K; k++) {
			
			// ���� �ٸ� ���� ���ڰ� ���Ë� ���� ���� �̾Ƴ���
			while(true) {
			random_number1 = (int) (Math.random()*(N))+1;
			random_number2 = (int) (Math.random()*(N))+1;
			if(random_number1 != random_number2) {			
				break;
				}
			}
			
			// ���� ����
			if(random_number1 > random_number2) {
				a = random_number2;
				b = random_number1;						
			}
			
			else {
				a = random_number1;
				b = random_number2;		
			}
	
			// ���ο� �迭 ����� 	
			new_array = new int[b-a+1];
			j = 0;
			for(int i = a-1 ; i <= b-1 ; i++) {
				new_array[j] = array[i];
				j++;
			}
	
			///////////////////////////���ο� �迭�� �հ� ���ϱ�(���� �հ�)////////////////////////////////////////////
		
			sum = sum_1(new_array);
		
			////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////������� ���� �ϱ�////////////////////////////////////////////
			

			int[] sort_new_array = original(new_array);

			
			////////////////////////////////////////////////////////////////////////////////////
			

			
			//�ִ� �ּ� ����
			long max = sort_new_array[sort_new_array.length-1];
			long min = sort_new_array[0];
			
		}	
		t =  System.currentTimeMillis() - t;
		
		return t;
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		System.out.println("N = 100���� ����,  K�� 0 ~ 1000000");
		for(int K = 0 ; K <= 10000000 ; K+=50000 ) {
			int N = 100;
			System.out.println(max_min_sum(N,K));
			}
		
		*/
		System.out.println("K = 100���� ����,  N�� 1 ~ 50000");
		for(int N = 0 ; N <= 50000 ; N+=500 ) {
			if(N == 0 || N == 1) continue;
			int K = 100;
			System.out.println(max_min_sum(N,K));
			}
		
		
	}
}

