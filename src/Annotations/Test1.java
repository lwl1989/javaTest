package Annotations;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.FIELD})  //可以在低端和类上使用
@Retention(RetentionPolicy.RUNTIME)  //运行时
@Inherited
@Documented
public @interface Test1 {
    String Annotation1();

    int number() default 12;
}
