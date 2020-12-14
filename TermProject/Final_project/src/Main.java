import java.util.Scanner;
import java.util.Random;
//rand.nextInt()

//과제 1
// N과 구간 a, b를 입력받고, 출력을내는프로그램을작성합니다.
// N개의 데이터를 랜덤함수로 생성합니다.
// a, b 구간의 최소값 최대값 합계를 구해서 출력합니다.

public class Main {
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
	static long max_min_sum(int N, int K) {
		long t = System.currentTimeMillis();
		Random rand = new Random(77);
		int min, max ;
		long sum = 0;
		long[] sum_list = new long[N+1];   //각 인덱스에서 그 전까지의 모든 합을 구해준다.
		sum_list[0] = 0;
		
		int[] for_min = new int[N*4];
		int[] for_max = new int[N*4];
		
		//배열 만들기
		int[] array = new int[N];
		for(int i = 0 ; i < N ; i++ ) {
			array[i] = rand.nextInt();
			sum_list[i+1] = sum_list[i] + array[i];	
		}
		
		//만든 배열로 세그먼트 트리 만들기
		for_min_tree(array, for_min, 1 , 0, N-1);
		for_max_tree(array, for_max, 1 , 0, N-1);
		

		/*array 배열 보기
		System.out.println("랜덤 생성 배열  ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
			if((i+1) % 3 == 0) {
				System.out.println();
			}
		}
		System.out.println("");
		*/
		//시작 끝 구간만 따온 배열 만들기		
		//시작과 끝 구간을 랜덤 값으로 생성하기	
		for(int k = 0 ; k < K; k++) {
			
			System.out.println("----------------"+(k+1)+"번 범위"+"----------------");
			
			// 서로 다른 랜덤 숫자가 나올떄 까지 숫자 뽑아내기
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
	
			///////////////////////////구간 합계 구하기////////////////////////////////////////////
			
			//b번째 까지의 합에서 a-1번째 까지의 합을 빼기   - 미리 구성했기 떄문에 상수 시간으로 계산 가능
			sum = sum_list[b]-sum_list[a-1];
						
			///////////////////////////최대 최소 구하기////////////////////////////////////////////
			//세그먼트 트리
			min = min_result(for_min,1,0,N-1,a-1,b-1) ;
			max = max_result(for_max,1,0,N-1,a-1,b-1) ;
			
			
			////////////////////////////////////////////////////////////////////////////////////
						
			//최대 최소 설정					
	
			System.out.println("구간 : "+ a+"번 ~ "+b +"번");
			System.out.println("최대값은 "+max);
			System.out.println("최소값은 "+min);		
			System.out.println("합계 "+ sum);	

		}	
		t =  System.currentTimeMillis() - t;
		
		return t;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		
		System.out.println("Term 최종 결과");
		System.out.println("랜덤함수를 통해 생성할 데이터의 개수 N을 입력하세요 : ");
		int N = sc.nextInt();
		
		System.out.println("랜덤하게 생성할 구간의 개수를 구하시오 : ");
		int K = sc.nextInt();		
				
		long final_time = max_min_sum(N,K);	
		
		System.out.println("위 과정을 수행하는데 걸리는 시간은"+ final_time+"ms 입니다.");		
	}
}
