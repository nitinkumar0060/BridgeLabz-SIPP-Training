interface Calculator{
    int operation(int a,int b);
}

public class LamdaCalculator {
    public static void main(String[] args){
        Calculator add=(a,b) ->(a+b);
        Calculator subtract=(a,b) ->(a-b);
        Calculator multiplication=(a,b) ->(a*b);
        Calculator division=(a,b) ->(a/b);

        int x=15;
        int y=10;
        System.out.println("Addition:"+add.operation(x, y));
        System.out.println("subtraction:"+subtract.operation(x, y));
        System.out.println("multiplication:"+multiplication.operation(x, y));
        System.out.println("division:"+division.operation(x, y));
        
    }
    
}
