package demo;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class form {
	String url_;
	public form(String url) {
		url_=url;
	}
	public form() {
	}
//	public void setForm(String[]... args){
//		valueList=new String[args.length][];
//		for(int i=0;i<args.length;i++){
//			valueList[i]=args[i];
//		}
//	}
	private void textFormClear(WebDriver driver){
		int textFormSize=driver.findElements(By.xpath("//input[@type='text']")).size();
		for(int i4=0;i4<textFormSize;i4++){
			driver.findElements(By.xpath("//input[@type='text']")).get(i4).clear();
		}
	}
	
	public void input(String[][] list){
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get(url_);
		
		//System.out.println(valueList[0].length);
//		int size=driver.findElements(By.xpath("//input[@type='text']")).size();
//		WebElement[] element = new WebElement[size];
		
		for(int i=0;i<list.length;i++){
			wait.until(titleContains("動作テスト"));
			this.textFormClear(driver);
			//pw
			driver.findElements(By.className("hovertip")).get(0).sendKeys(list[i][0]);
			//pw確認
			driver.findElements(By.className("hovertip")).get(1).sendKeys(list[i][1]);
			//個人法人
			
			if(list[i][2].equals("1")){
				driver.findElements(By.className("hovertip")).get(3).click();
			}else if(list[i][3].equals("1")){
				driver.findElements(By.className("hovertip")).get(4).click();
			}
			driver.findElements(By.className("hovertip")).get(5).sendKeys(list[i][4]);
			driver.findElements(By.className("hovertip")).get(6).sendKeys(list[i][5]);
			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
			}
			
			driver.findElements(By.className("btn_submit")).get(0).click();

			//wait.until(titleContains("株式会社シーアップ　お申し込み"));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			wait.until(ExpectedConditions.titleContains("最強ギター"));
			driver.get(url_);
		}
			
		driver.quit();
	
	}
	}

