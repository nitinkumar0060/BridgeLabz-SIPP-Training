package arrays;
import java.util.*;
public class Arrayto1D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
    
        int[][] array_2d=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                array_2d[i][j]=sc.nextInt();
            }
        }
        int[] array_1d=new int[row*col];
        int ptr=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                array_1d[ptr]=array_2d[i][j];
                ptr++;
            }
        }
        System.out.print(Arrays.toString(array_1d));
    }
}
   