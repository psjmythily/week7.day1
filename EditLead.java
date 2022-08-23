package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProjectSpecificMethods;

public class EditLead extends ProjectSpecificMethods{
	 
	@And("Click Find Leads Tab")
	public void findLeadsTab()
	{
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	@When("Enter the first name as (.*)$")
	public void enter_First_Name_In_Find_Leads_Page(String firstName)
	{
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(firstName);
	}
	
	@And("Click Find Leads Button")
	public void clickFindLeadsButton()
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	
	@And("Click the first Lead id link in the list")
	public void clickLeadId() throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		WebElement ele = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a"));

		try {

			ele.click();
		} catch (StaleElementReferenceException e) {
			System.out.println("Failed due to staleness");
			wait.until(ExpectedConditions.stalenessOf(ele));
			ele.click();
		}
	}
	
	@And("Click Edit button")
	public void clickEditButton()
	{
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
	}
	
	@And("Enter the last name as (.*)$")
	public void enter_The_LastName_InEdit(String lastName)
	{
		WebElement last = driver.findElement(By.id("updateLeadForm_lastName"));
		last.clear();
		last.sendKeys(lastName);
	}
	
	@And("Click on Update button")
	public void clickUpdateButton()
	{
		driver.findElement(By.xpath("//input[@value='Update']")).click();
	}
	
	@Then("Verify the updated last Name as (.*)$")
	public void verifyTheUpdatedLastName(String lastName)
	{
		String text = driver.findElement(By.xpath("//span[@id='viewLead_lastName_sp']")).getText();
		if(text.equals(lastName))
		{
			System.out.println("The lead detail is edited successfully");
		}
		else
		{
			System.out.println("Edit lead is not done");
		}
			
	}

}
