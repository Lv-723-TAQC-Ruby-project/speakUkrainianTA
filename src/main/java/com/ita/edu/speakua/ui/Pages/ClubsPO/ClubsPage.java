package com.ita.edu.speakua.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.AdvancedSearchModel;
import com.ita.edu.speakua.ui.BasePageWithHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ClubsPage extends BasePageWithHeader {


    private List<ClubCard> cards;

    @FindBy(xpath = "//div[contains(@class,'ant-card ant-card-bordered card')]")
    protected List<WebElement> cardsBody;
    public ClubsPage(WebDriver driver) {
        super(driver);

    }
    public List<ClubCard> getCards() {
        this.cards = new ArrayList<>();
        for(WebElement cardBody: cardsBody) {
            this.cards.add(new ClubCard(this.driver, cardBody));
        }
        return cards;
    }
}
