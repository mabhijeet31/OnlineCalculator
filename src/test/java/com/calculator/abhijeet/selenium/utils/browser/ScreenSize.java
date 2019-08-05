package com.calculator.abhijeet.selenium.utils.browser;

import org.openqa.selenium.Dimension;

import com.calculator.abhijeet.selenium.configurations.TypedProperties;

public enum ScreenSize {
    SMALL("small", new Dimension(new TypedProperties("/test_data.properties").getInt("screen.small"), 800)),
    MEDIUM("medium", new Dimension(new TypedProperties("/test_data.properties").getInt("screen.medium"), 800)),
    LARGE("large", new Dimension(new TypedProperties("/test_data.properties").getInt("screen.large"), 800)),
    XLARGE("xlarge", new Dimension(new TypedProperties("/test_data.properties").getInt("screen.xlarge"), 800)),
    XXLARGE("xxlarge", new Dimension(new TypedProperties("/test_data.properties").getInt("screen.xxlarge"), 800));

    public final String name;

    public final Dimension dimension;

    ScreenSize(final String name, final Dimension dimension) {
        this.name = name;
        this.dimension = dimension;
    }

}
