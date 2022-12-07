package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.headercomponent.HeaderComponent;
import org.openqa.selenium.WebDriver;

public class BasePageWithHeader extends HeaderComponent {
    public BasePageWithHeader(WebDriver driver) {
        super(driver);
    }
}
