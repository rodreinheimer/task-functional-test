package br.ce.wcaquino.tasks.prod;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class HealthCheckIT {
	
	@Test
	public void heathCheck() throws MalformedURLException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://192.168.86.250:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			String version = driver.findElement(By.id("version")).getText();
			Assert.assertTrue(version.contains("build"));	
			System.out.print(version);
		} finally {
			driver.quit();
			
		}
	}
	
}
