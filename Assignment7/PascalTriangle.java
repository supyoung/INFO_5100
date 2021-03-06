/* GOod Work
 * SCore 9.5 + extra credit 0; Total score 9.5
 */
public class PascalTriangle {
  public static void printPascalTriangle(int n){// use long, for input 100, int over flows; score 1.5
    int[] pre = new int[1];

    for (int i=0; i<n; i++) {
    		int[] current = new int[i+1];
    		for (int j = 0; j < i; j++) {
    				if (j == 0 || j == i)
    					current[j] = 1;
    				else
    					current[j] = pre[j - 1] + pre[j];
    				System.out.print(current[j] + " ");
    		}
        System.out.println();
        pre = current;
      }
  }

  public static void main(String[] args) {
		printPascalTriangle(10);
	}
}
