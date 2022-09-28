package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmployee {

	WebDriver driver;
	String expectedid ="";
	String actualid ="";
	

	@Given("^User launch url \"([^\"]*)\"$")
	public void user_launch_url(String Url) throws Throwable {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get(Url);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^user Enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
public void user_Enter_username_as_and_password_as(String user, String pass) throws Throwable {
    driver.findElement(By.name("txtUsername")).sendKeys(user);
    driver.findElement(By.name("txtPassword")).sendKeys(pass);
}

@When("^user click login button$")
public void user_click_login_button() throws Throwable {

	driver.findElement(By.name("Submit")).click();
}

@When("^user click pim$")
public void user_click_pim() throws Throwable {
	driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
}

@When("^user click add button$")
public void user_click_add_button() throws Throwable {
	driver.findElement(By.xpath("//input[@value='Add']")).click();
}

@When("^Fill Add Employee \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
public void fill_Add_Employee_and_and(String firstname, String middlename, String lastname) throws Throwable {
	driver.findElement(By.name("firstName")).sendKeys(firstname);
	driver.findElement(By.name("middleName")).sendKeys(middlename);
	driver.findElement(By.name("lastName")).sendKeys(lastname);
}

@When("^User capture EmId Before$")
public void user_capture_EmId_Before() throws Throwable {
     expectedid = driver.findElement(By.name("employeeId")).getAttribute("value");
}

@When("^User click save button$")
public void user_click_save_button() throws Throwable {
    driver.findElement(By.id("btnSave")).click();
}

@When("^uer capture EmId After$")
public void uer_capture_EmId_After() throws Throwable {
	actualid = driver.findElement(By.name("personal[txtEmployeeId]")).getAttribute("value");
}

@Then("^user validates emid$")
public void user_validates_emid() throws Throwable {
   if(expectedid.equals(actualid))
   {
	   System.out.println("Emp Creation Success::::"+expectedid+"          "+actualid);
   }
   else
   {
	   System.out.println("Emp Creation Fail::::"+expectedid+"          "+actualid);
   }
}

@Then("^user close browser$")
public void user_close_browser() throws Throwable {
    driver.close();
}

}
