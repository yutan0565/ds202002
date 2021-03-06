import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class hash_test {
	
	
	// 최대, 최소, 합계 구하기
	static long max_min_sum(int N, int K) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();	
		Random rand = new Random(77);
		
		int random_number1,random_number2,a,b;
		int min , max ;
		long sum;
		long t = System.currentTimeMillis();
		
		for(int i = 1 ; i <= N ; i++ ) {
			map.put( i,rand.nextInt() );
		}
		List<Integer> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));		
		for(int i = 0 ; i < K ; i++) {			
			while(true) {
				random_number1 = rand.nextInt(N)+1;
				random_number2 = rand.nextInt(N)+1;
			
				if(random_number1 != random_number2) {			
					break;
					}
				}
				if(random_number1 > random_number2) {
					a = random_number2;
					b = random_number1;						
				}
				
				else {
					a = random_number1;
					b = random_number2;		
				}		
			int min_init = map.get(a);
			int max_init = map.get(b);
			min = min_init ;
			max = max_init ;
			sum = 0 ;	
							
			for(Integer j : keySetList) {
				if(j >= a && j <= b) {
					min = map.get(j);
					break;
				}
			}		
			for(Integer j : keySetList ) {
				if(j >= a && j <= b && map.get(j) > max) {
						max = map.get(j);
					}						
			}
			for(int j = a ; j <= b ; j++) {
		
				sum += map.get(j);
			}	
		}
		t =  System.currentTimeMillis() - t;
		
		return t;
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("N = 100으로 고정,  K는 0 ~ 1000000");
		for(int K = 0 ; K <= 10000000 ; K+=50000 ) {
			int N = 100;
			System.out.println(max_min_sum(N,K));
			}
		/*
		System.out.println("K = 100으로 고정,  N은 1 ~ 1000000");
		for(int N = 0 ; N <= 10000000 ; N+=50000 ) {
			if(N == 0 || N == 1) continue;
			int K = 100;
			System.out.println(max_min_sum(N,K));
			}	
			*/
	}
}
