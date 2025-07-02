package Inheritance;


class Device{
	String  device_id;
	String status;
	 Device (String id ,String status){
		 this.device_id=id;
		 this.status=status;
	 }
	 void display() {
		 System.out.println("The device id is :"+ device_id);
		 System.out.println("The device Status is :"+ status);
	 }
	 
}
class Thermostat extends Device{
	double tempratureSetting;
	
	 public Thermostat(String device_id, String status, double temperatureSetting) {
	        super(device_id, status); 
	        this.tempratureSetting=temperatureSetting;
	    }
	 void display() {
		 super.display();
		 System.out.println("The device tempeerature Setting is :"+ tempratureSetting);
	 }
	
	
}
public class SmartPhone {
	public static void main(String []args) {
		Thermostat thermo=new Thermostat("abx","Active",10.5);
		thermo.display();
	}

}