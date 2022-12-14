package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.headercomponent.HeaderComponent;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends BaseTestRunner {
    @BeforeClass
    public void setUp() {
        setDriver();
    }

    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }

    @Test
    public void oneSymbolEnteredInTheField() {
        HeaderComponent search = new HomePage(driver)
                .clickSearchField()
                .enterInTheSearchField("j")
                .clickSearchField();
    }

    @Test
    public void oneHundredFifteenSymbolsEnteredInTheSearchField() {
        HeaderComponent search = new HomePage(driver)
                .clickSearchField()
                .enterInTheSearchField("dfgrhyujskdlkjnmhbnjmknhyFGTJVBYJK545fds5e5r5t5g5ggggggggggdiejdhntgf574639201///////85dkeidjhytgfrbhgtfdreswqabhgytfrdes3456&^%$#@!&*(jgdswtumbczsfg")
                .clickSearchButton();
    }

    @Test
    public void moreThanOneHundredFifteenSymbolsEnteredInTheSearchField() {
        HeaderComponent search = new HomePage(driver)
                .clickSearchField()
                .enterInTheSearchField("123456789dfgrhyujskdlkjnmhbnjmknhyFGTJVBYJK545fds5e5r5t5g5ggggggggggdiejdhntgf574639201///////85dkeidjhytgfrbhgtfdreswqabhgytfrdes3456&^%$#@!&*(jgdswtumbczsfg")
                .clickSearchButton();
    }


}
