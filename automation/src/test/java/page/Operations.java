package page;


import org.openqa.selenium.By;
import tests.BaseClass;

public class Operations {


//    Create,Edit and Delete Computer Page Elements

    String computerNameField = "//*[@id=\"name\"]";

    String introducedDateField = "//*[@id=\"introduced\"]";

    String discontinuedDateField = "//*[@id=\"discontinued\"]";

    String companyField = "//option[contains(text(), '";

    String selectList = "//*[@id=\"company\"]";

    String createComputerButton = "//*[@id=\"main\"]/form/div/input";

    String deleteButton = "//*[@id=\"main\"]/form[2]/input";

    String editComputerButton = "//*[@id=\"main\"]/form[1]/div/input";

    //    Computers Page Elements

    String addNewComputerButton = "//*[@id=\"add\"]";

    String searchField = "//*[@id=\"searchbox\"]";

    String searchButton = "//*[@id=\"searchsubmit\"]";

    String editLink = "//a[contains(text(), '";

    String alertMessgae = "//*[@id=\"main\"]/div[1]";

    String numOfComputers = "//*[@id=\"main\"]/h1";

    //    Computers Page Operations
    public void clickAddNewComputerButton() {
        BaseClass.getWebDriver().findElement(By.xpath(addNewComputerButton)).click();
    }

    public void clickToUpdate(String computerName) {
        BaseClass.getWebDriver().findElement(By.xpath(editLink + computerName + "')]")).click();
    }

//    Create,Edit and Delete Computer Operations

    public void createComputer(String name, String introducedDate, String discontinuedDate, String company) throws InterruptedException {
        Thread.sleep(2000);
        BaseClass.getWebDriver().findElement(By.xpath(computerNameField)).sendKeys(name);
        Thread.sleep(1000);
        BaseClass.getWebDriver().findElement(By.xpath(introducedDateField)).sendKeys(introducedDate);
        Thread.sleep(1000);
        BaseClass.getWebDriver().findElement(By.xpath(discontinuedDateField)).sendKeys(discontinuedDate);
        Thread.sleep(1000);
        BaseClass.getWebDriver().findElement(By.xpath(selectList)).click();
        Thread.sleep(1000);
        BaseClass.getWebDriver().findElement(By.xpath(companyField + company + "')]" )).click();
        Thread.sleep(1000);
        BaseClass.getWebDriver().findElement(By.xpath(createComputerButton)).click();
    }

    public void editComputer(String name) throws InterruptedException {
        Thread.sleep(2000);
        BaseClass.getWebDriver().findElement(By.xpath(computerNameField)).clear();
        Thread.sleep(1000);
        BaseClass.getWebDriver().findElement(By.xpath(computerNameField)).sendKeys(name);
        Thread.sleep(1000);
        BaseClass.getWebDriver().findElement(By.xpath(editComputerButton)).click();
    }

    public void deleteComputer() throws InterruptedException {
        Thread.sleep(2000);
        BaseClass.getWebDriver().findElement(By.xpath(deleteButton)).click();
    }

    public void searchComputer(String name) throws InterruptedException {
        Thread.sleep(2000);
        BaseClass.getWebDriver().findElement(By.xpath(searchField)).sendKeys(name);
        Thread.sleep(1000);
        BaseClass.getWebDriver().findElement(By.xpath(searchButton)).click();
        Thread.sleep(1000);
    }

    public int getNumberOfComputers() {
        String numbers = BaseClass.getWebDriver().findElement(By.xpath(numOfComputers)).getText();
        return  Integer.parseInt(numbers.substring(0, numbers.indexOf(" ")));
    }

    public boolean isSuccessMessageDisplayed() {
         return BaseClass.getWebDriver().findElement(By.xpath(alertMessgae)).getText().contains("created");
    }

    public boolean isUpdateMessageDisplayed() {
         return BaseClass.getWebDriver().findElement(By.xpath(alertMessgae)).getText().contains("updated");
    }

    public boolean isDeletedMessageDisplayed() {
         return BaseClass.getWebDriver().findElement(By.xpath(alertMessgae)).getText().contains("deleted");
    }

    public boolean isComputerDisplayed(String name) {
        return BaseClass.getWebDriver().findElement(By.xpath(editLink + name + "')]")).isDisplayed();
    }

}