package Constructor.Level1;
import java.util.*;
public class Course {
	String courseName;
	int duration;
	double fee;
	static String instituteName;
	
	Course(String courseName,int duration,double fee){
		this.courseName=courseName ;
		this.duration=duration;
		this.fee=fee;
		
	}
       void display() {
    	System.out.println("The institute name is  :" + instituteName );    	
		System.out.println("The course name is :" + courseName);
		System.out.println("The course duration  is :" + duration);
		System.out.println("The course fee is :" + fee);
	}
       public static void updateInstituteName(String newName) {
           instituteName = newName;}
	public static void main(String []args) {

	  updateInstituteName("GLA");
		
		Course c1=new Course( "B.tech",5,2400);
		Course c2=new Course( "B.pharma",5,6000);
		c1.display();
		c2.display();
		
	}

}