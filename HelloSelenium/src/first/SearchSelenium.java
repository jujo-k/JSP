package first;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchSelenium {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.gecko.driver", "D:\\安装文件夹\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		//创建FirefoxDriver实例,驱动firefox
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		//使用driver打开网页
		driver.get("https://www.baidu.com");
		
		WebElement element = driver.findElement(By.id("kw"));
		
		element.sendKeys("Selenium");
		
		element.submit();
		
		//关闭浏览器
		driver.quit();
	}
}
