import java.util.Scanner;

// HW02_2

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		int i, temp, max = 0,top = 0;
		int stack[] = new int[n];
		while(n-- >0) {
			temp =sc.nextInt();
			if(temp > max) {
				//stack에 값이 있는 상태
				for(i = max+1; i <= temp; i++) {
					stack[top++] = i;
					sb.append("+\n");
				}
				max = temp;
			}else if(stack[top-1] != temp) {
				System.out.print("NO");
				return;
			}
			top--;
			sb.append("-\n");
			
			
		}
		
		System.out.println(sb);
		
	}

}
