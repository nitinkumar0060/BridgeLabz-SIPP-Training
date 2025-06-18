package Arrays;
import java.util.*;
public class Five_inputs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] array=new int[5];
        for(int i=0;i<5;i++){
            array[i]=sc.nextInt();
        }
        for(int i=0;i<5;i++){
            int temp=array[i];
            if(temp<0){
                System.err.println("negative");
            }else if(temp==0){
                System.err.println("zero");
            }else if(temp>0){
                if(temp%2==0){
                    System.err.println("even");
                }else{
                    System.err.println("odd");
                }
            }
        }
        if(array[0]>array[4]){
            System.err.println("greater");
        }else if(array[0]==array[4]){
            System.err.println("equal");
        }else{
            System.err.println("lesser");
        }
    }
}