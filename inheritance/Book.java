package Inheritance;

 class Books {
 String title;
 int publicationYear;
 
 Books(String title,int publicationYear){
	 this.title=title;
	 this.publicationYear=publicationYear;
	 
 }
 void displayInfo() {
     System.out.println("Book Title: " + title);
     System.out.println("Publication Year: " + publicationYear);
 }
 
}
class Author extends Books {
    String name;
    String bio;


    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);  
        this.name = name;
        this.bio = bio;
    }
    
   void  displayInfo(){
	   super.displayInfo();
	   System.out.println("Name =" + name );
	   System.out.println("Bio =" + bio );
	   
    	
    }
    
} 
 public class Book{
	public static void main(String [] args) {
		Author auth=new Author("java_programming",2002,"Hritik","Learner Of java");
		auth.displayInfo();
		
	}
	
}