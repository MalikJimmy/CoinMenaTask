package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.Operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchComputerTest extends BaseClass {

    Operations searchComputer = new Operations();
    String name;

    @BeforeClass
    void navigate() throws InterruptedException {
        setUp();
        Thread.sleep(2000);
        searchComputer.clickAddNewComputerButton();
        name = "New-Apple-Testt";
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = myDateObj.format(myFormatObj);
        searchComputer.createComputer(name, formattedDate, formattedDate, "Apple Inc.");
    }

    @Test
    void createNewComputer() throws InterruptedException {
        searchComputer.searchComputer(name);

        boolean isComputerDisplayed = searchComputer.isComputerDisplayed(name);
        Assert.assertTrue(isComputerDisplayed, "Computer does not created!");
        Thread.sleep(2000);
    }

    @AfterClass(alwaysRun = true)
    void close() {
        tearDown();
    }
}
