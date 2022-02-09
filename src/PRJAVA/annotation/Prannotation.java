package PRJAVA.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.FIELD) //필드값에 적용 가능한 어노테이션
@Retention(RetentionPolicy.RUNTIME)
@interface InsertInt {
    //어노테이션 필드는 함수 작성하듯
    int data() default 0;
}

public class Prannotation {

    @InsertInt(data = 30)
    static  int a;

    public static void main(String[] args) {
//        @InsertInt(data = 39) 안된다
        System.out.println(a);
//        Prannotation.class.getMethod().isAnnotationPresent()
//        .class 를 통해 annotation 정보를 얻고 진행
    }

}
