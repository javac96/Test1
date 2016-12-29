package etihad;
/* * go to http://www.etihad.com/en-us/
 * from -> JFK
 * to -> Dhaka
 * select business class
 * select depart -> 09/15/2017
 * select return --> 10/15/2017
 * click on search flight
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBooking {
	static WebDriver driver = null;
	static String url = "http://www.etihad.com/en-us/";
	static String travelDate = "09/15/2017";
	static String returnDate = "10/15/2017";
	static String months[] = {"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"};


	public static void main(String[] args) throws Exception {


		DateFormat df = new SimpleDateFormat("MM/dd/yy");//MMMM/dd/yyyy
		Date dtT = df.parse(travelDate);
		Date dtR = df.parse(returnDate);

		Calendar calT = Calendar.getInstance();
		Calendar calR = Calendar.getInstance();

		calT.setTime(dtT);
		calR.setTime(dtR);

		int travelDay = calT.get(Calendar.DAY_OF_MONTH);
		int monthT = calT.get(Calendar.MONTH);
		int yearT = calT.get(Calendar.YEAR);

		int returnDay = calR.get(Calendar.DAY_OF_MONTH);
		int monthR = calR.get(Calendar.MONTH);
		int yearR = calR.get(Calendar.YEAR);

		String travelMonth = months[monthT]+" "+yearT;
		String returnMonth = months[monthR]+" "+yearR;
		//check the months


		//now selenium starts 

		//System.setProperty("webdriver.gecko.driver", "C:\\Selenium Driver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Driver\\chromedriver.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url); 

		By fromPath = By.xpath("//ul[@id='frm_2012158061206151234ui_autocomplete']/li/a");

		String fromLocation = "New York NY, John F Kennedy Airport (JFK), United States of America";
		By toPath = By.xpath("//ul[@id='frm_20121580612061235ui_autocomplete']/li/a");
		String toLocation = "Dhaka, Hazrat Shahjalal Airport (DAC), Bangladesh";

		By radioButtonPath = By.xpath("//div[@id='t1-p1']/div/fieldset[1]/div/div/div/input");
		String travelClassType = "Business";


		//click on the drop down menu of from location
		WebElement dropdownFrom =driver.findElement(By.xpath(".//div[@id='t1-p1']/fieldset/div[1]/div/span"));
		dropdownFrom.click();


		//invoke the method to select from airport
		selectLocation(fromPath, fromLocation);
		Thread.sleep(3000);

		//click on drop down menu of to location
		WebElement dropdownTo = driver.findElement(By.xpath(".//div[@id='t1-p1']/fieldset/div[2]/div/span"));
		dropdownTo.click();


		//invoke the method to select to airport
		selectLocation(toPath, toLocation);
		Thread.sleep(3000);

		//select depart -> 09/15/2017
		//click on outbound date picker
		driver.findElement(By.xpath(".//div[@id='t1-p1']/fieldset/div[4]/div[1]/div/span")).click();
		Thread.sleep(3000);

		//select the outbound date
		selectDate(travelMonth, travelDay);
		Thread.sleep(3000);

		//click on return date picker
		driver.findElement(By.xpath(".//div[@id='t1-p1']/fieldset/div[4]/div[2]/div/span")).click();
		Thread.sleep(3000);

		//select the return date
		selectDate(returnMonth, returnDay);
		Thread.sleep(3000);


		//invoke the method to select class radio button
		selectTravelClass(radioButtonPath, travelClassType);
		

		//click on search flight button
		driver.findElement(By.xpath(".//*[@id='t1-p1']/div/div/button")).click();

	}

	public static void selectTravelClass(By buttonPath, String classType){

		List<WebElement> button = driver.findElements(buttonPath);
		System.out.println(button.size());

		for(WebElement radio: button){
			if(radio.getAttribute("value").equalsIgnoreCase(classType)){

				if(!radio.isSelected())
					radio.click();
				break;
			}
		}
	}//method selectTravelClass end
	
	public static void selectDate(String month, int day) throws Exception{
		WebElement month_year = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[3]/div/div"));
		if(!month_year.getText().trim().equalsIgnoreCase(month)){
			while(!month_year.getText().trim().equalsIgnoreCase(month)){
				driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[4]/div/a")).click();
				month_year = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[3]/div/div"));
			}
		}
		List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[3]/table/tbody/tr/td/a"));
		for(WebElement date : dates){
			if(Integer.parseInt(date.getText()) == day){
				date.click();
				break;
			}
		}
	}//method close

	public static void selectLocation(By locationPath, String airport){

		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<WebElement> airports = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locationPath));
		for(WebElement el : airports){
			if(el.getText().equalsIgnoreCase(airport)){
				el.click();
				break;
			}
		}

	}//method selectLocation end

}


