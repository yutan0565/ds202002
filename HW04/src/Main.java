//	Lecture 14
//	���������� �̿��Ͽ� ������׷����� ���� ū ������ ���簭�� ���� ���ϱ�
//	�Է�
//	ó���� ������׷��� ���� ���� N�� �Էµ˴ϴ�.
//	������ �� ���õ��� �������� N�� �Էµ˴ϴ�.
//	���� �� { 3, 2, 6, 7 }�� ������ ������ 4���� ������ �ִ� ������׷���
//	4 3 2 6 7
//	�� �Է��� �־����ϴ�.
//	�̿� ���� �亯�� ���簢���� ���̸� ����ϸ� �˴ϴ�.
//	12
import java.util.Scanner;
public class Main {

	static int histo(int[] v, int a, int b) {	
		if(a == b) {
            return v[a];
        }        
        int mid = (a + b) / 2;
        int result = Math.max(histo(v, a, mid), histo(v, mid + 1, b));
        
        int leftIndex = mid;
        int rightIndex = mid;
 
        int minHeight = v[mid];
        int length = 1;
        
        while(rightIndex - leftIndex <= b - a) {
            
        	int tempLength = length + 1;
            
           
            int leftLocalHeightIndex = (leftIndex > a)? (leftIndex - 1) : -1;
            int leftLocalHeight = (leftLocalHeightIndex == -1)? -1 : Math.min(minHeight, v[leftLocalHeightIndex]);
            int leftLocalWidth = leftLocalHeight * tempLength;
            
            int rightLocalHeightIndex = (rightIndex < b)? (rightIndex + 1) : -1;
            int rightLocalHeight = (rightLocalHeightIndex == -1)? -1 : Math.min(minHeight, v[rightLocalHeightIndex]);
            int rightLocalWidth = rightLocalHeight * tempLength;
            
            if(leftLocalWidth <= rightLocalWidth) {
                minHeight = rightLocalHeight;
                rightIndex += 1;
            }
            else {
                minHeight = leftLocalHeight;
                leftIndex -= 1;
            }          
            length +=1 ;
            result = Math.max(result, minHeight * length);
        }
        
        return result;

	}
		
	static int histo(int[] v, int n) {
		return histo(v, 0, n-1);
	}
	
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("���� ���� �Է� : ");
		int n = scan.nextInt();
		System.out.print("�迭 ���� �Է� : ");
		int[] v = new int[n];
		for(int i = 0; i < n; i++) {
			v[i] = scan.nextInt();
		}
		int r = histo(v, n);
		System.out.println(r);
	}
}
