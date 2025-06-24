import java.util.*;
public class Countvowels{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the String:");
String input=sc.nextLine();
input=input.toLowerCase();
int vowels=0 , consonants=0;
for(int i=0; i< input.length();i++){
char ch= input.charAt(i);
if(ch >='a' && ch<='z'){
if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
vowels++;
}
else{
consonants++;
}
}
}
System.out.println("vowels are:" + vowels);
System.out.println("consonants are:" + consonants);
}
}


