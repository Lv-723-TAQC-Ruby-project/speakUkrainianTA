package com.ita.edu.speakua.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class ClubCard extends BasePO {
    protected WebElement cardBody;
    @FindBy(xpath = ".//div[@class='title']")
    protected WebElement title;
    @FindBy(xpath = "//ul[@class='ant-rate ant-rate-disabled rating'")
    private WebElement ratingStars;
    @FindBy(xpath = "//li[@class='ant-rate-star ant-rate-star-full'")
    private WebElement fullRatingStar;
    @FindBy(xpath = "//li[@class='ant-rate-star ant-rate-star-zero'")
    private WebElement emptyRatingStar;
    @FindBy(xpath = "//div[@class='ant-card-body'")
    private WebElement clubCard;

    public ClubCard(WebDriver driver) {
        super(driver);
    }

    public ClubCard(WebDriver driver, WebElement cardBody) {
        super(driver);
        this.cardBody = cardBody;
        PageFactory.initElements(new DefaultElementLocatorFactory(this.cardBody), this);
    }

    public int getRatingStars() {
        List<WebElement> fullStars = clubCard.findElements(By.xpath("//li[@class='ant-rate-star ant-rate-star-full'"));
        return fullStars.size();
    }

    public String getTitle() {
        return this.title.getText();
    }


}
