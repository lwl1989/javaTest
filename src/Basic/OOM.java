package Basic;

import java.util.*;

public class OOM {



        static String  base = "string";
        public static void main(String[] args) {
            //java 1.8 +
            //java.lang.OutOfMemoryError: Java heap space

            //java 1.6
            //java.lang.OutOfMemoryError: OernGen space

            //java 1.7
            //java.lang.OutOfMemoryError: Java heap space

            //jdk 1.8 +
            //-XX:MetaspaceSize=8M -XX:MaxMetaspaceSize=16M
            //java.lang.OutOfMemoryError: Metaspace

            //jdk 1.10
            //java.lang.OutOfMemoryError: Java heap space
            List<String> list = new ArrayList<String>();
            for (int i=0;i< Integer.MAX_VALUE;i++){
                String str = base + base;
                base = str;
                list.add(str.intern());
            }
        }
}
