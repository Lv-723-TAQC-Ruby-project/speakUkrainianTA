package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdvancedSearchTest extends BaseTestRunner {

    @BeforeClass
    public void setUp() {
        setDriver();
    }


    @Test
    public void checkAdvancedSearch() {
       HomePage Page = new HomePage(driver);
       boolean check  = Page.openAdvancedSearch().isAdvancedSearchOpen();
       Assert.assertTrue(check);
       System.out.println("True");
       check = Page.openAdvancedSearch().isAdvancedSearchOpen();
       Assert.assertFalse(check);
       System.out.println("False");
    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
