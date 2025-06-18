package Arrays;

import java.util.*;
class even_odd{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();
        int[] odd=new int[input/2 + 1];
        int[] even =new int[input/2+1];
        int odd_ptr=0,even_ptr=0;
        for(int i=1;i<input;i++){
            if(i%2!=0){
                odd[odd_ptr]=i;
                odd_ptr++;
            }else{
                even[even_ptr]=i;
                even_ptr++;
            }
        }
        System.out.println("even" + Arrays.toString(even));
        System.out.println("odd"+ Arrays.toString(odd));
    }
}