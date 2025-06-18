package Arrays;
import java.util.*;

public class MultiplicationOfNumber {
    public static void main(String[] args) {
    
    Scanner sc =new Scanner(System.in);
    int number =sc.nextInt();
    int table[]= new int[10] ;

    for(int index=1;index<=10;index++){
        table[index-1]=number*index;


    }
    for(int index= 1;index<=10;index++){
        System.out.println(number + "*" + index + "=" + table[index-1]);
    }
}}