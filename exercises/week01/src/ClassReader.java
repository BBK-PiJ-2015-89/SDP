import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gwilki01 on 12/01/2017.
 */
public class ClassReader {

    public static void main(String[] args) {
        Class c;
        Scanner sc;
        try{
            sc = new Scanner(System.in);
            System.out.println("Enter the name of the class:");
            String theClass = sc.next();
            c = Class.forName(theClass);
            System.out.println("Modifiers: " + c.getModifiers());
            System.out.println("Constructors: " +  Arrays.toString(c.getConstructors()));
            System.out.println("Methods: " + Arrays.toString(c.getMethods()));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

interface Test {
    void test();
}
