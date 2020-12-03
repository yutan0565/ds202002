
import java.util.Random;
import java.util.Scanner;

public class XX {
   // 랜덤 데이터 값을 받을 배열 선언
   static int[] array;
   //   랜덤 구간의 배열 값을 복사할 배열 선언
   static int[] Sectionarray;
   
   // 구간 시작, 끝 번호를 담을 변수 num1, num2
   static int num1;
   static int num2;
   
   // 최소,최대값 변수
   static int min;
   static int max;
   
   // 각 구간별 최소,최대,합계값을 저장하기 위한 K*3개의 인덱스를 가진 배열선언
   static int[] K_array;
   // K_array배열의 인덱스를 하나씩 채워갈 변수
   static int arrayindex = 0;
   
   static void selectionSort(int[] array) {
      
         for(int i = 0; i < array.length; i++) {
            
            for(int p = 0; p < array.length - 1; p++) {
               if(array[p] > array[p + 1]) {
                  int temp = array[p];
                  array[p] = array[p + 1];
                  array[p + 1] = temp;
               }
            }
         }
   }
   
   static void MinMaxSum(int N, int[] array) {
      
      num1 = (int) ((Math.random() * N) + 1); // 1~N까지의 수 중 하나 랜덤
      num2 = (int) ((Math.random() * N) + 1); // 마찬가지로 1~N까지의 수 중 하나 랜덤
      
      System.out.print(num1 + " " + num2);
      System.out.println();
   
      if (num1 == num2) {
   
         MinMaxSum(N, array);
      }
   
      else if (num1 < num2) {
         int sum = 0;
         
         System.out.print(num1 + " " + num2 + sum);
         System.out.println();
         
         Sectionarray = new int[num2 - num1 + 1];
         
         //   Sectionarray의 인덱스를 0부터 시작하게 해줄 변수 선언
         int Sectionarrayindex = 0;
         
         //   랜덤한 구간의 배열 값 Sectionarray에 복사
         for(int i = num1 - 1; i < num2; i++) {
            Sectionarray[Sectionarrayindex++] = array[i];
         }
         
         selectionSort(Sectionarray);
         
         
         // 합계 구하기
         for (int j = num1 - 1; j < num2; j++) {
            sum += array[j];
         }
   
   
         K_array[arrayindex] = Sectionarray[0];
         arrayindex++;
         K_array[arrayindex] = Sectionarray[Sectionarrayindex-1];
         arrayindex++;
         K_array[arrayindex] = sum;
         arrayindex++;
   
      }
   
      else if (num1 > num2) {
         int temp = num1;
         num1 = num2;
         num2 = temp;
   
         int sum = 0;
         
         System.out.print(num1 + " " + num2 + sum);
         System.out.println();
         
         Sectionarray = new int[num2 - num1 + 1];
         //   Sectionarray의 인덱스를 0부터 시작하게 해줄 변수 선언
         int Sectionarrayindex = 0;
            
         //   랜덤한 구간의 배열 값 Sectionarray에 복사
         for(int i = num1 - 1; i < num2; i++) {
            Sectionarray[Sectionarrayindex++] = array[i];
         }
      
         selectionSort(Sectionarray);
            
         for (int j = num1 - 1; j < num2; j++) {
            sum += array[j];
         }
   
   
         K_array[arrayindex] = Sectionarray[0];
         arrayindex++;
         K_array[arrayindex] = Sectionarray[Sectionarrayindex-1];
         arrayindex++;
         K_array[arrayindex] = sum;
         arrayindex++;
   
      }
   
   }
   
   static void ShowSectionInformation(int[] K_array) { // 각 구간 최소,최대,합계 출력해주는 메소드
   
      for (int i = 0; i < K_array.length; i++) {
         if (i == 0)
            System.out.print(K_array[i] + " ");
         else if (i != 0 && (i % 3) == 0) {
            System.out.println();
            System.out.print(K_array[i] + " ");
         } else
            System.out.print(K_array[i] + " ");
      }
   }
   
   static void RandomSectionInformation(int N, int K) {
      Random random = new Random();
      array = new int[N];
   
      for (int i = 0; i < N; i++) {
         array[i] = random.nextInt();
      }
   
      for (int i = 0; i < K; i++) {
   
         MinMaxSum(N, array);
   
      }
      ShowSectionInformation(K_array);
   
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
   
      System.out.print("생성할 데이터의 개수를 입력하세요 > ");
      int N = sc.nextInt();
      System.out.print("\n생성할 구간의 개수를 입력하세요 > ");
      int K = sc.nextInt();
      
      K_array = new int[K * 3];
      long t = System.currentTimeMillis();
      
      RandomSectionInformation(N, K);
      
      long f = System.currentTimeMillis();
      //   실행후 시간에서 실행전 시간을 빼면 경과시간이 나오며, 이를 출력합니다.
      
      System.out.println("\nElapsed time is " + (f-t) + "ms.");
      
      System.out.println("\n");
      
      for(int i = 0; i < array.length; i++) {
         System.out.print(array[i] + " ");
      }
   }
}