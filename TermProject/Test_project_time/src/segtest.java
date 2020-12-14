import java.util.Scanner;
import java.util.Random;
//rand.nextInt()

//���� 1
// N�� ���� a, b�� �Է¹ް�, ������������α׷����ۼ��մϴ�.
// N���� �����͸� �����Լ��� �����մϴ�.
// a, b ������ �ּҰ� �ִ밪 �հ踦 ���ؼ� ����մϴ�.

public class segtest {
	static int random_number1;
	static int random_number2;
	static int a;
	static int b;
	static int[] new_array;
	static int j;
	
	// �ּҰ��� ���� ���׸�Ʈ Ʈ��
	public static int for_min_tree(int array[], int[] for_min, int node, int start, int end) {
	      if (start == end) {
	    	  for_min[node] = array[start]; 
	          return for_min[node];
	 
	        } else {
	            int mid = (start + end) / 2;
	            
	            for_min[node] = Math.min(for_min_tree(array, for_min, node * 2, start, mid),
	            		for_min_tree(array, for_min, node * 2 + 1, mid + 1, end));
	            return for_min[node];
	        }
	   }
	// �ּҰ� ã��
	public static int min_result(int[] for_min,int node,int start,int end,int index_min,int index_max){
	      int min;
	      if (index_min > end || index_max < start) {
	            min = Integer.MAX_VALUE;
	            return min;
	        }
	 
	        else if (index_min <= start && index_max >= end) {
	            return for_min[node];
	        }else {
	           int mid = (start + end) / 2;
	          min = Math.min(min_result(for_min, node * 2, start, mid, index_min, index_max)
	                    , min_result(for_min, node * 2 + 1, mid + 1, end, index_min, index_max));
	          return min;
	        }
	   }

	// �ִ밪�� ���� ���׸�Ʈ Ʈ��
		public static int for_max_tree(int array[], int[] for_max, int node, int start, int end) {
		      if (start == end) {
		    	  for_max[node] = array[start]; 
		          return for_max[node];
		 
		        } else {
		            int mid = (start + end) / 2;
		            
		            for_max[node] = Math.max(for_max_tree(array, for_max, node * 2, start, mid),
		            		for_max_tree(array, for_max, node * 2 + 1, mid + 1, end));
		            return for_max[node];
		        }
		   }
		// �ִ밪 ã��
		public static int max_result(int[] for_max,int node,int start,int end,int index_min,int index_max){
		      int max;
		      if (index_min > end || index_max < start) {
		    	  max = Integer.MIN_VALUE;
		            return max;
		        }
		 
		        else if (index_min <= start && index_max >= end) {
		            return for_max[node];
		        }else {
		           int mid = (start + end) / 2;
		           max = Math.max(max_result(for_max, node * 2, start, mid, index_min, index_max)
		                    , max_result(for_max, node * 2 + 1, mid + 1, end, index_min, index_max));
		          return max;
		        }
		   }
	
	// �ִ�, �ּ�, �հ� ���ϱ�
	static void  max_min_sum(int N, int K) {
		
		Random rand = new Random(77);
		int min, max ;
		long sum = 0;
		long[] sum_list = new long[N+1];   //�� �ε������� �� �������� ��� ���� �����ش�.
		sum_list[0] = 0;
		
		int[] for_min = new int[N*4];
		int[] for_max = new int[N*4];
		
		int[] array = new int[N];
		for(int i = 0 ; i < N ; i++ ) {
			array[i] = rand.nextInt();
			sum_list[i+1] = sum_list[i] + array[i];	
		}

		for_min_tree(array, for_min, 1 , 0, N-1);
		for_max_tree(array, for_max, 1 , 0, N-1);
		
		for(int k = 0 ; k < K; k++) {
			
			while(true) {
			random_number1 = rand.nextInt(N)+1;
			random_number2 = rand.nextInt(N)+1;
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
			sum = sum_list[b]-sum_list[a-1];
			min = min_result(for_min,1,0,N-1,a-1,b-1) ;
			max = max_result(for_max,1,0,N-1,a-1,b-1) ;

		}	
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		System.out.println("N = 100���� ����,  K�� 0 ~ 1000000");
		for(int K = 0 ; K <= 10000000 ; K+=50000 ) {
			int N = 10;
			long t = System.currentTimeMillis();
			max_min_sum(N,K);
			t =  System.currentTimeMillis() - t;
			System.out.println(t);
			}

		

		System.out.println("K = 100���� ����,  N�� 1 ~ 1000000");
		for(int N = 0 ; N <= 100000 ; N+=500 ) {
			if(N == 0 || N == 1) continue;
			int K = 1000000;
			long t = System.currentTimeMillis();
			max_min_sum(N,K);
			t =  System.currentTimeMillis() - t;
			System.out.println(t);
			}		
			
		System.out.println("K = 100���� ����,  N�� 1 ~ 1000000");
		for(int N = 0 ; N <= 1000 ; N+=5 ) {
			if(N == 0 || N == 1) continue;
			int K = 1000000;
			long t = System.currentTimeMillis();
			max_min_sum(N,K);
			t =  System.currentTimeMillis() - t;
			System.out.println(t);
			}	
			*/	
		
		System.out.println("N = 100���� ����,  K�� 0 ~ 1000000");
		for(int K = 0 ; K <= 100000 ; K+=500 ) {
			int N = 10000000;
			long t = System.currentTimeMillis();
			max_min_sum(N,K);
			t =  System.currentTimeMillis() - t;
			System.out.println(t);
			}
		
		
		
		
	}
}