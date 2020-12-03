
import java.util.Random;
import java.util.Scanner;

public class XX {
   // ���� ������ ���� ���� �迭 ����
   static int[] array;
   //   ���� ������ �迭 ���� ������ �迭 ����
   static int[] Sectionarray;
   
   // ���� ����, �� ��ȣ�� ���� ���� num1, num2
   static int num1;
   static int num2;
   
   // �ּ�,�ִ밪 ����
   static int min;
   static int max;
   
   // �� ������ �ּ�,�ִ�,�հ谪�� �����ϱ� ���� K*3���� �ε����� ���� �迭����
   static int[] K_array;
   // K_array�迭�� �ε����� �ϳ��� ä���� ����
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
      
      num1 = (int) ((Math.random() * N) + 1); // 1~N������ �� �� �ϳ� ����
      num2 = (int) ((Math.random() * N) + 1); // ���������� 1~N������ �� �� �ϳ� ����
      
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
         
         //   Sectionarray�� �ε����� 0���� �����ϰ� ���� ���� ����
         int Sectionarrayindex = 0;
         
         //   ������ ������ �迭 �� Sectionarray�� ����
         for(int i = num1 - 1; i < num2; i++) {
            Sectionarray[Sectionarrayindex++] = array[i];
         }
         
         selectionSort(Sectionarray);
         
         
         // �հ� ���ϱ�
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
         //   Sectionarray�� �ε����� 0���� �����ϰ� ���� ���� ����
         int Sectionarrayindex = 0;
            
         //   ������ ������ �迭 �� Sectionarray�� ����
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
   
   static void ShowSectionInformation(int[] K_array) { // �� ���� �ּ�,�ִ�,�հ� ������ִ� �޼ҵ�
   
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
   
      System.out.print("������ �������� ������ �Է��ϼ��� > ");
      int N = sc.nextInt();
      System.out.print("\n������ ������ ������ �Է��ϼ��� > ");
      int K = sc.nextInt();
      
      K_array = new int[K * 3];
      long t = System.currentTimeMillis();
      
      RandomSectionInformation(N, K);
      
      long f = System.currentTimeMillis();
      //   ������ �ð����� ������ �ð��� ���� ����ð��� ������, �̸� ����մϴ�.
      
      System.out.println("\nElapsed time is " + (f-t) + "ms.");
      
      System.out.println("\n");
      
      for(int i = 0; i < array.length; i++) {
         System.out.print(array[i] + " ");
      }
   }
}