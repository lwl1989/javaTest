package Self;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})  //可以在方法和类上使用
@Retention(RetentionPolicy.RUNTIME)  //运行时
@Inherited
@Documented
public @interface NoMember {
}
