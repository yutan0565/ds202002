import java.util.Scanner;
import java.util.Random;
//rand.nextInt()

//���� 1
// N�� ���� a, b�� �Է¹ް�, ������������α׷����ۼ��մϴ�.
// N���� �����͸� �����Լ��� �����մϴ�.
// a, b ������ �ּҰ� �ִ밪 �հ踦 ���ؼ� ����մϴ�.


public class Main {
	
	static long max_min_sum(int N, int a, int b) {
		Random rand = new Random(77);
		long sum = 0;
		
		//�迭 �����
		int[] array = new int[N];
		for(int i = 0 ; i < N ; i++ ) {
			array[i] = rand.nextInt();
		}
		System.out.println();
		
		//array �迭 ����
		System.out.println("���� ���� �迭");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
		
		//���� �� ������ ���� �迭 �����
		int[] new_array = new int[b-a+1];
		int j = 0;
		for(int i = a-1 ; i <= b-1 ; i++) {
			new_array[j] = array[i];
			j++;
		}
		System.out.println();
		
		//new_array �迭 ����
		System.out.println(a+"���� ���� " +b+"������ �迭");
		for(int i=0; i< new_array.length; i++) {
			System.out.print(new_array[i]+" ");
		}
		System.out.println();
		
		//new_array�� ������������ ����	
		for(int i=0; i< new_array.length;i++) {
			for(int p = 0; p< new_array.length-1;p++) {
				if(new_array[p]>new_array[p+1]) {
					int temp = new_array[p];
					new_array[p] = new_array[p+1];
					new_array[p+1] = temp;
				}
			}
		}		
		System.out.print("�������� ����: ");
		for(int i=0;i < new_array.length; i++) {
			System.out.print(new_array[i] + " ");
		}
		
		//�ִ� �ּ� ����
		System.out.println("");
		long max = new_array[new_array.length-1];
		long min = new_array[0];
		
		System.out.println("");
		System.out.println("�ִ밪�� "+max);
		System.out.println("�ּҰ��� "+min);
		System.out.println("");
		
		//�ִ� �ּ� �� ����
		sum = max + min;
		System.out.println("�ּ�, �ִ밪�� �� : "+sum);
		return sum;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		
		System.out.println("�����Լ��� ���� ������ �������� ���� N�� �Է��ϼ��� : ");
		int N = sc.nextInt();
		
		System.out.println("������ 1���� ���� �Դϴ�.");
		System.out.println("������ ����(a)�� ��(b)�� �Է��ϼ��� : ");
		
		//���ǿ� �´� ���� �Է������� �ϱ�
		boolean valid = true;
		int a=0, b=0;
		while(valid) {
		    a = sc.nextInt();
			b = sc.nextInt();
			if( 1<=a && 1<=b  && a < b){
				valid = false;
			}
			else {
				valid = true;
				System.out.println("a < b ���ǿ� �´� ���ڸ� �Է��ϼ���!!");
			}		
		};

		long t = System.currentTimeMillis();
		max_min_sum(N,a,b);	
		long f = System.currentTimeMillis();
		System.out.println("�� ������ �����ϴµ� �ɸ��� �ð���"+(f-t)+"ms �Դϴ�.");		
	}

}

