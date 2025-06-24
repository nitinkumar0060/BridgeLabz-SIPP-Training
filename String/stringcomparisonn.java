import java.util.*;
public class stringcomparisonn{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter string 1:");
String input1=sc.nextLine();
System.out.println("Enter string 2:");
String input2=sc.nextLine();
input1=input1.toLowerCase();
input2=input2.toLowerCase();
if(input1.equals(input2)){
System.out.println("Both string are equal");
}
else{
System.out.println("Both String are unequal");
}
}
}

