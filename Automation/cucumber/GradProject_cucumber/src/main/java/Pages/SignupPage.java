package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    WebDriver driver;
    public SignupPage(WebDriver driver) {
        this.driver=driver;
    }


    //loators
    private By enter_Account_word= By.xpath("//b[contains(text(),'Enter Account Information')]");
    private By title= By.xpath("//input[@value='Mr']");
    private By name= By.xpath("//input[@id='name']");
    //private By email= By.xpath("//input[@id='email']");
    private By day= By.xpath("(//option[@value='7'])[1]");
    private By month= By.xpath("(//option[@value='6'])[2]");
    private By year= By.xpath("(//option[@value='2003'])[1]");
    private By password= By.xpath("//input[@id='password']");
    private By newsletter= By.xpath("//input[@id='newsletter']");
    private By receive_offer= By.xpath("//input[@id='optin']");
    private By first_name= By.xpath("//input[@id='first_name']");
    private By last_name= By.xpath("//input[@id='last_name']");
    private By company= By.xpath("//input[@id='company']");
    private By address_one= By.xpath("//input[@id='address1']");
    private By address_two= By.xpath("//input[@id='address2']");
    private By country= By.xpath("//option[@value='United States']");
    private By state= By.xpath("//input[@id='state']");
    private By city= By.xpath("//input[@id='city']");
    private By zipcode= By.xpath("//input[@id='zipcode']");
    private By mobile_number= By.xpath("//input[@id='mobile_number']");
    private By create_account_button= By.xpath("//button[@data-qa='create-account']");



    //actions
    public boolean check_Enter_Account_word(){
      return driver.findElement(enter_Account_word).isDisplayed();
    }

    public void choose_title(){
        driver.findElement(title).click();
    }

    public void enter_name(){
        driver.findElement(name).sendKeys("abdo");
    }

    /*public void enter_email(){
        driver.findElement(email).sendKeys("abdelrahmansalem609@gmail.com");
    }*/

    public void choose_Day(){
        driver.findElement(day).click();
    }

    public void choose_month(){
        driver.findElement(month).click();
    }

    public void choose_year(){
        driver.findElement(year).click();
    }

    public void enter_password(){
        driver.findElement(password).sendKeys("12345");
    }

    public void clickon_newsletter(){
        driver.findElement(newsletter).click();
    }

    public void clickon_receive_offer(){
        driver.findElement(receive_offer).click();
    }

    public void enter_first_name(){
        driver.findElement(first_name).sendKeys("abdo");
    }

    public void enter_last_name(){
        driver.findElement(last_name).sendKeys("salem");
    }

    public void enter_company(){
        driver.findElement(company).sendKeys("depi");
    }

    public void enter_addres1(){
        driver.findElement(address_one).sendKeys("Tharwat Okasha,Obour city, Depi");
    }

    public void enter_address2(){
        driver.findElement(address_two).sendKeys("");
    }

    public void enter_country(){
        driver.findElement(country).click();
    }

    public void enter_state(){
        driver.findElement(state).sendKeys("single");
    }

    public void enter_city(){
        driver.findElement(city).sendKeys("obour");
    }

    public void enter_zipcode(){
        driver.findElement(zipcode).sendKeys("123456");
    }

    public void enter_mobile_number(){
        driver.findElement(mobile_number).sendKeys("01011643200");
    }

    public Created_Account_Page clickon_create_account_button(){
        driver.findElement(create_account_button).click();
        return new Created_Account_Page(driver);
    }




}
