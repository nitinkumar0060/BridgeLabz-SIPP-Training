import java.io.*;

public class StudentData {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.dat"))) {
            dos.writeInt(101);
            dos.writeUTF("Ravi");
            dos.writeDouble(8.5);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream("student.dat"))) {
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
