package com.ita.edu.speakua.ui.ClubsPO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.headercomponent.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClubsPO extends BasePO {

    private List<ClubCard> cards;

    @FindBy(xpath = "//div[contains(@class,'ant-card ant-card-bordered card')]")
    protected List<WebElement> cardsBody;
    public ClubsPO(WebDriver driver) {
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
