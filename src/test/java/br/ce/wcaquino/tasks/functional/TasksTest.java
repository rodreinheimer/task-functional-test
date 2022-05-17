package br.ce.wcaquino.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TasksTest {
	
	public WebDriver accessApplication() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void testEnvironment() {
		WebDriver driver = accessApplication();
		try {
			//Click Add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Write Description
			driver.findElement(By.id("task")).sendKeys("Selenium test");
			
			//Write Date
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			
			//Click Save
			driver.findElement(By.id("saveButton")).click();
			
			//Validate Success message
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", message);
				
		}finally {
			//close browser
			driver.quit();
		}
	}
	
	@Test
	public void shouldNotSaveTodoWithoutDescription() {
		WebDriver driver = accessApplication();
		try {
			//Click Add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Write Description
			driver.findElement(By.id("task")).sendKeys("Selenium test");
			
			//Click Save
			driver.findElement(By.id("saveButton")).click();
			
			//Validate Success message
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the due date", message);
				
		}finally {
			//close browser
			driver.quit();
		}
	}

	@Test
	public void shouldNotSaveTodoWithoutDate() {
		WebDriver driver = accessApplication();
		try {
			//Click Add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Write Date
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			
			//Click Save
			driver.findElement(By.id("saveButton")).click();
			
			//Validate Success message
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", message);
				
		}finally {
			//close browser
			driver.quit();
		}
	}
	
	@Test
	public void shouldNotSaveTodoWithPastDate() {
		WebDriver driver = accessApplication();
		try {
			//Click Add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Write Description
			driver.findElement(By.id("task")).sendKeys("Selenium test");
			
			//Write Date
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2010");
			
			//Click Save
			driver.findElement(By.id("saveButton")).click();
			
			//Validate Success message
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", message);
				
		}finally {
			//close browser
			driver.quit();
		}
	}
	

}
