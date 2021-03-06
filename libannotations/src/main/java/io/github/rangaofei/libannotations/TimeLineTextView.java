package io.github.rangaofei.libannotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)

public @interface TimeLineTextView {
    boolean key() default true;//是否显示在key布局

    String id() default TimeConfig.ID_NULL;

    String style() default TimeConfig.ID_NULL;

    String styleAnchor() default TimeConfig.ID_NULL;
}
