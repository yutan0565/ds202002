import java.util.Scanner;
import java.util.Random;
//rand.nextInt()

//과제 1
// N과 구간 a, b를 입력받고, 출력을내는프로그램을작성합니다.
// N개의 데이터를 랜덤함수로 생성합니다.
// a, b 구간의 최소값 최대값 합계를 구해서 출력합니다.

public class segtest {
	static int random_number1;
	static int random_number2;
	static int a;
	static int b;
	static int[] new_array;
	static int j;
	
	// 최소값을 위한 세그먼트 트리
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
	// 최소값 찾기
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

	// 최대값을 위한 세그먼트 트리
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
		// 최대값 찾기
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
	
	// 최대, 최소, 합계 구하기
	static void  max_min_sum(int N, int K) {
		
		Random rand = new Random(77);
		int min, max ;
		long sum = 0;
		long[] sum_list = new long[N+1];   //각 인덱스에서 그 전까지의 모든 합을 구해준다.
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
			
			// 범위 설정
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
		System.out.println("N = 100으로 고정,  K는 0 ~ 1000000");
		for(int K = 0 ; K <= 10000000 ; K+=50000 ) {
			int N = 10;
			long t = System.currentTimeMillis();
			max_min_sum(N,K);
			t =  System.currentTimeMillis() - t;
			System.out.println(t);
			}

		

		System.out.println("K = 100으로 고정,  N은 1 ~ 1000000");
		for(int N = 0 ; N <= 100000 ; N+=500 ) {
			if(N == 0 || N == 1) continue;
			int K = 1000000;
			long t = System.currentTimeMillis();
			max_min_sum(N,K);
			t =  System.currentTimeMillis() - t;
			System.out.println(t);
			}		
			
		System.out.println("K = 100으로 고정,  N은 1 ~ 1000000");
		for(int N = 0 ; N <= 1000 ; N+=5 ) {
			if(N == 0 || N == 1) continue;
			int K = 1000000;
			long t = System.currentTimeMillis();
			max_min_sum(N,K);
			t =  System.currentTimeMillis() - t;
			System.out.println(t);
			}	
			*/	
		
		System.out.println("N = 100으로 고정,  K는 0 ~ 1000000");
		for(int K = 0 ; K <= 100000 ; K+=500 ) {
			int N = 10000000;
			long t = System.currentTimeMillis();
			max_min_sum(N,K);
			t =  System.currentTimeMillis() - t;
			System.out.println(t);
			}
		
		
		
		
	}
}
