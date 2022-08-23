package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	
	@Given("Type the username as {string}")
	public void typeUserName(String username)
	{
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	@And("Type the password as {string}")
	public void typePassword(String password)
	{
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@When("Click on the Login button")
	public void login()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		
	}
	
	@Then("Verify the home page is displayed")
	public void verifyHomePage()
	{
		String text = driver.findElement(By.tagName("h2")).getText();
		if(text.contains("Welcome"))
		{
			System.out.println("Home page is displayed");
		}
		else
		{
			System.out.println("Home page is not displayed");
		}
	}
	
	@But("Error message is displayed")
	public void errorMessage()
	{
		String text = driver.findElement(By.id("errorDiv")).getText();
		System.out.println(text);
	}
}
