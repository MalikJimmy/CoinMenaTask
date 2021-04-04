package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.Operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class UpdateComputerTest extends BaseClass {

    Operations updateComputer = new Operations();
    String name = "NewName";

    @BeforeClass
    void navigate() throws InterruptedException {
        setUp();
        Thread.sleep(2000);
        updateComputer.clickAddNewComputerButton();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = myDateObj.format(myFormatObj);
        updateComputer.createComputer(name, formattedDate, formattedDate, "Apple Inc.");
        updateComputer.searchComputer(name);
        updateComputer.clickToUpdate(name);
    }

    @Test
    void createNewComputer() throws InterruptedException {
        String name = "Updated-Apple-Test";
        updateComputer.editComputer(name);

        boolean isUpdateMessageDisplayed = updateComputer.isUpdateMessageDisplayed();
        Assert.assertTrue(isUpdateMessageDisplayed, "Computer does not updated!");
        Thread.sleep(2000);
    }

    @AfterClass(alwaysRun = true)
    void close() {
        tearDown();
    }
}
