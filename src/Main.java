import Self.NoMember;
import Self.Test1;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        try {
            Class c = Class.forName("Self.Self1");
            boolean exists = c.isAnnotationPresent(Test1.class);
            if(exists) {
                Test1 test1 = (Test1)c.getAnnotation(Test1.class);
                System.out.println(test1.Annotation1());
            }

            Method[] method = c.getMethods();
            for(Method m : method) {
                boolean mexists = m.isAnnotationPresent(NoMember.class);
                if(mexists) {
                    System.out.println(m.toString()+" is Annotation by " + NoMember.class);
                }
                //System.out.println(mexists+m.toString());
            }
            System.out.println();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
