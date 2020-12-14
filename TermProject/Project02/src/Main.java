import java.util.Scanner;
import java.util.Random;
//rand.nextInt()

//과제 1
// N과 구간 a, b를 입력받고, 출력을내는프로그램을작성합니다.
// N개의 데이터를 랜덤함수로 생성합니다.
// a, b 구간의 최소값 최대값 합계를 구해서 출력합니다.


//숫자들을 정렬 하는 방식
//1. min, max 정한다음 하나씩 비교하기
//2. 삽입 정렬
//3. 합병 정렬
//4. 퀵 정렬



public class Main {
	static int random_number1;
	static int random_number2;
	static int a;
	static int b;
	static int[] new_array;
	static int j;
		
	//정렬 방식
	// 1. 기본 정렬 방식 사용
	static int[] min_max(int[] new_array) {
		int min = new_array[0];	
		int max = new_array[0];
		int[] result = new int[2];
		for(int i = 0 ; i < new_array.length ; i++) {
			if(new_array[i] < min) {
				min = new_array[i];
			}
			if(new_array[i] > max) {
				max = new_array[i];
			}
		}
		result[0] = min;
		result[1] = max;
	
		return result;		
	}
	
	
	// 합계 방식
	static long sum_1(int[] new_array) {
		long sum = 0;
		for(int i = 0 ; i < new_array.length ; i++) {
			sum += new_array[i];
		}
		return sum;
	}
	
	// 최대, 최소, 합계 구하기
	static long max_min_sum(int N, int K) {
		long t = System.currentTimeMillis();
		Random rand = new Random(77);
		long sum = 0;
				
		//배열 만들기
		int[] array = new int[N];
		for(int i = 0 ; i < N ; i++ ) {
			array[i] = rand.nextInt();
		}

		
		//array 배열 보기
		System.out.println("랜덤 생성 배열  ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
			if((i+1) % 3 == 0) {
				System.out.println();
			}
		}
		System.out.println();

		
		
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
	
			// 새로운 배열 만들기 	
			new_array = new int[b-a+1];
			j = 0;
			for(int i = a-1 ; i <= b-1 ; i++) {
				new_array[j] = array[i];
				j++;
			}
			///////////////////////////새로운 배열의 합계 구하기(구간 합계)////////////////////////////////////////////

			sum = sum_1(new_array);
			
			////////////////////////////////////////////////////////////////////////////////////
		
			//new_array 배열 보기
			System.out.println("구간 : "+ a+"번 ~ "+b +"번");					
			//최대 최소 설정
			int[] result = min_max(new_array);
			int min = result[0];
			int max = result[1];
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
		
		System.out.println("Term 2 결과 ");
		System.out.println("랜덤함수를 통해 생성할 데이터의 개수 N을 입력하세요 : ");
		int N = sc.nextInt();
		
		System.out.println("랜덤하게 생성할 구간의 개수를 구하시오 : ");
		int K = sc.nextInt();		
				
		long final_time = max_min_sum(N,K);	
		
		System.out.println("위 과정을 수행하는데 걸리는 시간은"+ final_time+"ms 입니다.");		
	}
}

