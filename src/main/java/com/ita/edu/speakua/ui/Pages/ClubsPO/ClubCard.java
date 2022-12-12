package com.ita.edu.speakua.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ClubCard extends BasePO {
    protected WebElement cardBody;

    @FindBy(xpath = ".//div[@class='title']")
    protected WebElement title;

    public ClubCard(WebDriver driver) {
        super(driver);
    }

    public ClubCard(WebDriver driver, WebElement cardBody) {
        super(driver);
        this.cardBody = cardBody;
        PageFactory.initElements(new DefaultElementLocatorFactory(this.cardBody), this);
    }

    public String getTitle() {
        return this.title.getText();
    }


}
