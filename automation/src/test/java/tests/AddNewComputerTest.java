package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.Operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddNewComputerTest extends BaseClass {

    Operations createComputerPage = new Operations();

    @BeforeClass
    void navigate() throws InterruptedException {
        setUp();
        Thread.sleep(2000);
        createComputerPage.clickAddNewComputerButton();
    }

    @Test
    void createNewComputer() throws InterruptedException {
        String name = "New-Apple-Test";
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = myDateObj.format(myFormatObj);

        createComputerPage.createComputer(name, formattedDate, formattedDate, "Apple Inc.");

        boolean isSuccessMessageDisplayed = createComputerPage.isSuccessMessageDisplayed();
        Assert.assertTrue(isSuccessMessageDisplayed, "Computer does not created!");
        Thread.sleep(2000);
    }

    @AfterClass(alwaysRun = true)
    void close() {
        tearDown();
    }
}
