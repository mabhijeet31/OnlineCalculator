package com.calculator.abhijeet.selenium.utils.annotations.browser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.calculator.abhijeet.selenium.utils.browser.ScreenSize;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface BrowserDimension {

    ScreenSize value();
}
