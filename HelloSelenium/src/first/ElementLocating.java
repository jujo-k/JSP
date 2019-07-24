/*
 * 用selenium自动完成考试题目
 * 
 */
package first;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementLocating {
	public static void main(String[] args) throws InterruptedException {
		//加载驱动，因为selenium的包和firefox版本对不上
		System.setProperty("webdriver.gecko.driver", "D:\\安装文件夹\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		
		//启动firefox
		WebDriver driver = new FirefoxDriver();
		
		//打开网页最大化
		driver.manage().window().maximize();
		
		//使用driver打开网页，完全打开方法才结束
		driver.get("http://www.hztaxi.com.cn/");
//		driver.get("http://www.hztaxi.com.cn/app/html/qgkmks.html");
	
	
		//点击进入考试区
		WebElement exam = driver.findElement(By.xpath("//a[@href='app/html/qgkmks.html']"));
		exam.click();
		
		//切换到新的窗口
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String h : handles) {
			if(!h.equals(handle)) {
				driver.switchTo().window(h);
			}
		}
		
	
		Thread.sleep(4000);
		//全部选A  这里刚开始就取到一个，用例list+循环才全部取到。
		List<WebElement> opts = driver.findElements(By.xpath("//input[@value='A']"));
		for(WebElement opt :opts) {
			opt.click();
		}
		
		Thread.sleep(2000);
		//提交答案,by classname 抓不到  。删掉空格之后竟然找到了
		//莫名奇妙抓不到，后来发现没有选择就直接点击了，就停了2s 就ok
		WebElement button = driver.findElement(By.className("btn-success"));
		button.click();
		
		//接受弹出框，并确认
		//.alert().accept()  始终抓不到，是confirm
//		Alert a = driver.switchTo().alert();
//		Thread.sleep(2000);
//		a.accept();
		
		//不知道为什么不能抓到alert  好像不是弹出alert 而是显示一个隐藏的框，只能直接上手上面的按钮了。
		WebElement submit = driver.findElement(By.className("layui-layer-btn0"));
		submit.click();
		
		Thread.sleep(2000);
		WebElement qr = driver.findElement(By.className("layui-layer-btn0"));
		qr.click();
		
		
		
		/*
		//找到有道logo页面对应的WebElement对象
		WebElement logo = driver.findElement(By.className("logo"));
		System.out.println("找到logo");
		
		//highlight方法为selenium高级应用，用于高亮显示页面元素
		highlight(driver,logo);
		
		//找到有道搜索框对应的对象
		WebElement ssk = driver.findElement(By.className("s-input"));
		
		//找到含有“有道”页面链接对应的对象列表
		List<WebElement> link = driver.findElements(By.partialLinkText("有道"));
		for(WebElement e:link) {
			highlight(driver,e);
		}
			*/	
		driver.quit();
	}
}
