//	Lecture 14
//	분할정복을 이용하여 히스토그램에서 가장 큰 넓이의 직사강형 넓이 구하기
//	입력
//	처음에 히스토그램의 샘플 갯수 N이 입력됩니다.
//	다음에 각 샘플들의 도수들이 N개 입력됩니다.
//	예를 들어서 { 3, 2, 6, 7 }의 도수를 가지는 4개의 샘플이 있는 히스토그램은
//	4 3 2 6 7
//	로 입력이 주어집니다.
//	이에 대한 답변을 직사각형의 넓이를 출력하면 됩니다.
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
		System.out.print("샘플 개수 입력 : ");
		int n = scan.nextInt();
		System.out.print("배열 내용 입력 : ");
		int[] v = new int[n];
		for(int i = 0; i < n; i++) {
			v[i] = scan.nextInt();
		}
		int r = histo(v, n);
		System.out.println(r);
	}
}
