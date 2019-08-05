package com.calculator.abhijeet.selenium.utils.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * HOW TO USE:
 * @Rule
 * public RepeatRule repeatRule = new RepeatRule();
 *
 * @Test
 * @Repeat(10)
 * public void exampleTest() {
 * }
 */

@Retention( RetentionPolicy.RUNTIME )
@Target({ METHOD, ANNOTATION_TYPE })
public @interface Repeat {
    int value() default 1;
}
