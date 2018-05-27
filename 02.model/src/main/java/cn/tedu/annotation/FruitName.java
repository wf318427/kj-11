package cn.tedu.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 18.1.7.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}

