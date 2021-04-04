package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.Operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class DeleteComputerTest extends BaseClass {

    Operations deleteComputer = new Operations();
    int oldNumbers ;
    int newNumbers ;
    String name = "New-Apple-Test" ;

    @BeforeClass
    void navigate() throws InterruptedException {
        setUp();
        Thread.sleep(2000);
        deleteComputer.clickAddNewComputerButton();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = myDateObj.format(myFormatObj);
        deleteComputer.createComputer(name, formattedDate, formattedDate, "Apple Inc.");
        oldNumbers = deleteComputer.getNumberOfComputers();
        deleteComputer.searchComputer(name);
        deleteComputer.clickToUpdate(name);
    }

    @Test
    void deleteComputer() throws InterruptedException {
        deleteComputer.deleteComputer();
        newNumbers = deleteComputer.getNumberOfComputers();

        boolean isDeletedMessageDisplayed = deleteComputer.isDeletedMessageDisplayed();
        boolean isNumbersOfComputerDecreased = oldNumbers > newNumbers;

        Map actual = new HashMap();
        actual.put("isDeletedMessageDisplayed", isDeletedMessageDisplayed);
        actual.put("isNumbersOfComputerDecreased", isNumbersOfComputerDecreased);

        Map expected = new HashMap();
        expected.put("isDeletedMessageDisplayed", isDeletedMessageDisplayed);
        expected.put("isNumbersOfComputerDecreased", isNumbersOfComputerDecreased);

        Assert.assertEquals(actual, expected, "Computer does not deleted!");
        Thread.sleep(2000);
    }

    @AfterClass(alwaysRun = true)
    void close() {
        tearDown();
    }
}
