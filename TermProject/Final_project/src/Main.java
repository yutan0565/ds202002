import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//���� ���

public class Main {
		
	// �ִ�, �ּ�, �հ� ���ϱ�
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
			
			System.out.print("���� �迭 : ");
			for(int j = 1 ; j <= N ; j++) {
				System.out.print(map.get(j)+"  ");		
			}
			System.out.println("");
			
			
			// K(���� ����)	
			for(int i = 0 ; i < K ; i++) {
				System.out.println("----------------"+(i+1)+"�� ����"+"----------------");
					
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
				
				System.out.print(a+"���� ���� " +b+"������ �迭 : ");
				for(int j = a ; j <= b ; j++) {
					System.out.print(map.get(j)+"  ");
					sum += map.get(j);
				}
				
				
				System.out.println("");
				System.out.println("�ִ밪�� "+max);
				System.out.println("�ּҰ��� "+min);
				System.out.println("�հ� "+ sum);	
				
				
			}
			t =  System.currentTimeMillis() - t;
			
			return t;
		}
		

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�����Լ��� ���� ������ �������� ���� N�� �Է��ϼ��� : ");
		int N = sc.nextInt();
		
		System.out.println("�����ϰ� ������ ������ ������ ���Ͻÿ� : ");
		int K = sc.nextInt();	
		
		long final_time = max_min_sum(N,K);	
		
		System.out.println("�� ������ �����ϴµ� �ɸ��� �ð���"+ final_time+"ms �Դϴ�.");	
		
		
		
		
		
	}
}