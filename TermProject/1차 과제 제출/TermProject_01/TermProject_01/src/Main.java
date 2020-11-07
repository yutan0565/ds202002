import java.util.Scanner;
import java.util.Random;
//rand.nextInt()

//과제 1
// N과 구간 a, b를 입력받고, 출력을내는프로그램을작성합니다.
// N개의 데이터를 랜덤함수로 생성합니다.
// a, b 구간의 최소값 최대값 합계를 구해서 출력합니다.


public class Main {
	
	static long max_min_sum(int N, int a, int b) {
		Random rand = new Random();
		int sum = 0;
		
		//배열 만들기
		int[] array = new int[N];
		for(int i = 0 ; i < N ; i++ ) {
			array[i] = rand.nextInt();
		}
		System.out.println();
		
		//array 배열 보기
		System.out.println("랜덤 생성 배열");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
		
		//시작 끝 구간만 따온 배열 만들기
		int[] new_array = new int[b-a+1];
		int j = 0;
		for(int i = a-1 ; i <= b-1 ; i++) {
			new_array[j] = array[i];
			j++;
		}
		System.out.println();
		
		//new_array 배열 보기
		System.out.println(a+"번쨰 부터 " +b+"까지의 배열");
		for(int i=0; i< new_array.length; i++) {
			System.out.print(new_array[i]+" ");
		}
		System.out.println();
		
		//new_array를 오름차순으로 나열	
		for(int i=0; i< new_array.length;i++) {
			for(int p = 0; p< new_array.length-1;p++) {
				if(new_array[p]>new_array[p+1]) {
					int temp = new_array[p];
					new_array[p] = new_array[p+1];
					new_array[p+1] = temp;
				}
			}
		}		
		System.out.print("오름차순 정렬: ");
		for(int i=0;i < new_array.length; i++) {
			System.out.print(new_array[i] + " ");
		}
		
		//최대 최소 설정
		System.out.println("");
		int max = new_array[new_array.length-1];
		int min = new_array[0];
		
		System.out.println("");
		System.out.println("최대값은 "+max);
		System.out.println("최소값은 "+min);
		System.out.println("");
		
		//최대 최소 합 설정
		sum = max + min;
		System.out.println("최소, 최대값의 합 : "+sum);
		return sum;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		
		System.out.println("랜덤함수를 통해 생성할 데이터의 개수 N을 입력하세요 : ");
		int N = sc.nextInt();
		
		System.out.println("구간의 시작(a)과 끝(b)를 입력하세요 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();

		long t = System.currentTimeMillis();
		max_min_sum(N,a,b);	
		long f = System.currentTimeMillis();
		System.out.println("위 과정을 수행하는데 걸리는 시간은"+(f-t)+"ms 입니다.");		
	}

}


