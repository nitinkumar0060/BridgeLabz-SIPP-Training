package Arrays;
import java.util.*;
public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();
        String[] array=new String[input+1];
        int ptr=0;
        for(int i=0;i<input+1;i++){
            if(i%3==0 && i%5==0){
                array[ptr]="FizzBuzz";
                ptr++;
                continue;
            }else if(i%3==0){
                array[ptr]="Fizz";
                ptr++;
                continue;
            }else if(i%5==0){
                array[ptr]="Buzz";
                ptr++;
                continue;
            }else{
                array[ptr]=Integer.toString(i);
                ptr++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}