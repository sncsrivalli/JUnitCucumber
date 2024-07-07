package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SkillraryLoginSteps {
	WebDriver driver;
	
	@Given("Navigate to skillrary")
	public void navigate_to_skillrary() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://demoapp.skillrary.com/login.php?type=login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("Provided with valid inputs")
	public void provided_with_valid_inputs() {
	    driver.findElement(By.id("email")).sendKeys("admin");
	    driver.findElement(By.id("password")).sendKeys("admin");
	}

	@And("Hit on Login")
	public void hit_on_login() {
	    driver.findElement(By.id("last")).click();
	}

	@Then("Admin home page displays")
	public void admin_home_page_displays() {
	    WebElement adminIcon = driver.findElement(By.xpath("//span[text()='SkillRary Admin']"));
	    
	    if(adminIcon.isDisplayed())
	    	System.out.println("Test pass");
	    else
	    	System.out.println("Test failed");
	    
	    driver.quit();
	}

	@When("Provided with invalid inputs")
	public void provided_with_invalid_inputs() {
		driver.findElement(By.id("email")).sendKeys("abcdef");
	    driver.findElement(By.id("password")).sendKeys("123456");
	}

}
