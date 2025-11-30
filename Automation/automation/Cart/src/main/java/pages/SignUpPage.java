package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    static WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver = driver ;
    }
    //Locators
    private static By title= By.xpath("//input[@value='Mr']");
    private By name= By.xpath("//input[@id='name']");
    private static By day= By.xpath("(//option[@value='2'])[1]");
    private static By month= By.xpath("(//option[@value='3'])[2]");
    private static By year= By.xpath("(//option[@value='2004'])[1]");
    private static By password= By.xpath("//input[@id='password']");
    private static By newsletter= By.xpath("//input[@id='newsletter']");
    private static By receive_offer= By.xpath("//input[@id='optin']");
    private static By first_name= By.xpath("//input[@id='first_name']");
    private static By last_name= By.xpath("//input[@id='last_name']");
    private static By company= By.xpath("//input[@id='company']");
    private static By address_one= By.xpath("//input[@id='address1']");
    private static By address_two= By.xpath("//input[@id='address2']");
    private static By country= By.xpath("//option[@value='United States']");
    private static By state= By.xpath("//input[@id='state']");
    private static By city= By.xpath("//input[@id='city']");
    private static By zipcode= By.xpath("//input[@id='zipcode']");
    private static By mobile_number= By.xpath("//input[@id='mobile_number']");
    private static By create_account_button= By.xpath("//button[@data-qa='create-account']");


    //Actions
    public static void choose_title(){
        driver.findElement(title).click();
    }

    public void enter_name(){
        driver.findElement(name).sendKeys("abdo");
    }

    /*public void enter_email(){
        driver.findElement(email).sendKeys("abdelrahmansalem609@gmail.com");
    }*/

    public static void choose_Day(){
        driver.findElement(day).click();
    }

    public static void choose_month(){
        driver.findElement(month).click();
    }

    public static void choose_year(){
        driver.findElement(year).click();
    }

    public static void enter_password(){
        driver.findElement(password).sendKeys("1234568");
    }

    public static void clickon_newsletter(){
        driver.findElement(newsletter).click();
    }

    public static void clickon_receive_offer(){
        driver.findElement(receive_offer).click();
    }

    public static void enter_first_name(){
        driver.findElement(first_name).sendKeys("Ahmed");
    }

    public static void enter_last_name(){
        driver.findElement(last_name).sendKeys("Ali");
    }

    public static void enter_company(){
        driver.findElement(company).sendKeys("AMIT");
    }

    public static void enter_addres1(){
        driver.findElement(address_one).sendKeys("Tharwat Okasha,Obour city, Depi");
    }

    public static void enter_address2(){
        driver.findElement(address_two).sendKeys("");
    }

    public static void enter_country(){
        driver.findElement(country).click();
    }

    public static void enter_state(){
        driver.findElement(state).sendKeys("single");
    }

    public static void enter_city(){
        driver.findElement(city).sendKeys("6th oct");
    }

    public static void enter_zipcode(){
        driver.findElement(zipcode).sendKeys("123456");
    }

    public static void enter_mobile_number(){
        driver.findElement(mobile_number).sendKeys("01011643200");
    }

    public static CreatedAccountPage clickCnCreateAccountButton(){
        driver.findElement(create_account_button).click();
        return new CreatedAccountPage(driver);
    }







}
