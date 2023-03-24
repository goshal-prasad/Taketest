package pages;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import baseclassLibrary.BaseClass;
import library.TestDataImport;

public class AllScreens extends BaseClass {
	private WebDriver driver;
	private TestDataImport tdImport;
	private String testResult ="";

	public AllScreens(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
		tdImport = new TestDataImport();
	}

	@FindBy(id="quizframe")
	private WebElement quizframe;

	@FindBy(id="btnStart")
	private WebElement takeTheTest;

	@FindBy(id="family_history-yes")
	private WebElement diabetesYes;
	@FindBy(id="family_history-no")
	private WebElement diabetesNo;
	@FindBy(id="next-button1")
	private WebElement nextButton1;

	@FindBy(id="high_blood_pressure-yes")
	private WebElement bloodPressureYes;
	@FindBy(id="high_blood_pressure-no")
	private WebElement bloodPressureNo;
	@FindBy(id="next-button2")
	private WebElement nextButton2;

	@FindBy(id="age-lessthan40")
	private WebElement agelessthan40;
	@FindBy(id="age-40-49")
	private WebElement age40_49;
	@FindBy(id="age-50-59")
	private WebElement age50_59;
	@FindBy(id="age-60+")
	private WebElement age60Plus;
	@FindBy(id="next-button3")
	private WebElement nextButton3;

	@FindBy(id="ethnicity-other")
	private WebElement otherEthnicity;
	@FindBy(id="next-button4")
	private WebElement nextButton4;

	@FindBy(id="active-yes")
	private WebElement activeYes;
	@FindBy(id="active-no")
	private WebElement activeNo;
	@FindBy(id="next-button5")
	private WebElement nextButton5;

	@FindBy(id="gender-man")
	private WebElement genderMan;
	@FindBy(id="gender-woman")
	private WebElement genderWoman;
	@FindBy(id="gestational-yes")
	private WebElement gestationalYes;
	@FindBy(id="gestational-no")
	private WebElement gestationalNo;
	@FindBy(id="next-button6")
	private WebElement nextButton6;

	@FindBy(id="height")
	private WebElement height;	
	@FindBy(id="weight")
	private WebElement weight;	
	@FindBy(id="next-button7")
	private WebElement nextButton7;

	@FindBy(id="btnTakeAgainFromLow1")
	private WebElement takeAgain;
	@FindBy(id="risk_score_form")
	private WebElement result;

	@FindBy(xpath="//strong[contains(text(),'YOUR SCORE')]")
	private List<WebElement> yourScore;
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg' and @aria-label='Close']")
	private WebElement close;

	public List<WebElement> diabetes(){
		List<WebElement> diabetes = new ArrayList<WebElement>();
		diabetes.add(diabetesYes);
		diabetes.add(diabetesNo);
		return diabetes;
	}

	public List<WebElement> bloodPressure(){
		List<WebElement> bloodPressure = new ArrayList<WebElement>();
		bloodPressure.add(bloodPressureYes);
		bloodPressure.add(bloodPressureNo);
		return bloodPressure;
	}

	public List<WebElement> age(){
		List<WebElement> age = new ArrayList<WebElement>();
		age.add(agelessthan40);
		age.add(age40_49);
		age.add(age50_59);
		age.add(age60Plus);
		return age;
	}

	public List<WebElement> active(){
		List<WebElement> active = new ArrayList<WebElement>();
		active.add(activeYes);
		active.add(activeNo);
		return active;
	}

	public List<WebElement> gender(){
		List<WebElement> gender = new ArrayList<WebElement>();
		gender.add(genderMan);
		gender.add(genderWoman);
		return gender;
	}

	public List<WebElement> gestational(){
		List<WebElement> gestational = new ArrayList<WebElement>();
		gestational.add(gestationalYes);
		gestational.add(gestationalNo);
		return gestational;
	}

	public void cdcTest() {
		int gestationLimit=0;
		Select heightDropdown, weightDropdown; 
		try {
			int h=1;
			for(int i=0; i<diabetes().size(); i++) {				
				for(int j=0; j<bloodPressure().size(); j++) {					
					for(int k=0; k<age().size(); k++) {
						for(int l=0; l<active().size(); l++) {
							for(int m=0; m<gender().size(); m++) {
								if(m==0)
									gestationLimit=1;
								else
									gestationLimit=2;
								for(int n=0; n<gestationLimit; n++) {
									for(int p=1; p<20; p++) { //height
										for(int q=1; q<5; q++) { //weight
											waitForElementToLoad(takeTheTest, 30);
											takeTheTest.click();
											waitForElementToLoad(quizframe, 30);
											driver.switchTo().frame(quizframe);

											waitForElementToLoad(diabetes().get(i), 30);
											diabetes().get(i).click();
											System.out.println("Do you have a mother, father, sister, or brother with diabetes?: " +diabetes().get(i).getAttribute("value"));
											tdImport.writeCell(h, 0, diabetes().get(i).getAttribute("value"));
											nextButton1.click();
											Thread.sleep(1500);

											waitForElementToLoad(bloodPressure().get(i), 30);
											bloodPressure().get(j).click();
											System.out.println("Have you ever been diagnosed with high blood pressure?: "+ bloodPressure().get(j).getAttribute("value"));
											tdImport.writeCell(h, 1, bloodPressure().get(j).getAttribute("value"));
											nextButton2.click();
											Thread.sleep(1500);

											waitForElementToLoad(age().get(k), 30);
											age().get(k).click();
											System.out.println("How old are you?: "+ age().get(k).getAttribute("value"));
											tdImport.writeCell(h, 2, age().get(k).getAttribute("value"));
											nextButton3.click();
											Thread.sleep(1500);

											waitForElementToLoad(otherEthnicity, 30);
											otherEthnicity.click();
											System.out.println("What race or ethnicity best describes you?: "+ otherEthnicity.getAttribute("value"));
											tdImport.writeCell(h, 3, otherEthnicity.getAttribute("value"));
											nextButton4.click();
											Thread.sleep(1500);

											waitForElementToLoad(active().get(l), 30);
											active().get(l).click();
											System.out.println("Are you physically active?: "+ active().get(l).getAttribute("value"));
											tdImport.writeCell(h, 4, active().get(l).getAttribute("value"));
											nextButton5.click();
											Thread.sleep(1500);

											waitForElementToLoad(gender().get(m), 30);
											gender().get(m).click();
											System.out.println("Are you a man or a woman?: "+ gender().get(m).getAttribute("value"));
											tdImport.writeCell(h, 5, gender().get(m).getAttribute("value"));
											if(m!=0) {
												waitForElementToLoad(gestational().get(n), 30);
												gestational().get(n).click();
												System.out.println("Have you ever been diagnosed with gestational diabetes?: "+ gestational().get(n).getAttribute("value"));
												tdImport.writeCell(h, 6, gestational().get(n).getAttribute("value"));
											}

											nextButton6.click();
											Thread.sleep(1500);

											waitForElementToLoad(height, 30);
											heightDropdown = new Select(driver.findElement(By.id("height")));
											heightDropdown.selectByIndex(p);
											System.out.println("How tall are you?: "+ driver.findElement(By.id("height")).getAttribute("value"));
											tdImport.writeCell(h, 7, driver.findElement(By.id("height")).getAttribute("value"));
											Thread.sleep(1500);

											waitForElementToLoad(weight, 30);
											weightDropdown = new Select(driver.findElement(By.id("weight")));
											weightDropdown.selectByIndex(q);
											Thread.sleep(1500);
											System.out.println("Please select your weight.: "+ driver.findElement(By.id("weight")).getAttribute("value"));
											tdImport.writeCell(h, 8, driver.findElement(By.id("weight")).getAttribute("value"));
											nextButton7.click();
											Thread.sleep(1500);

											waitForElementToLoad(result, 30);
											testResult = result.getText();
											System.out.println("\n"+ testResult);
											tdImport.writeCell(h, 9, testResult);
											driver.switchTo().defaultContent();
											close.click();
											Thread.sleep(1500);
											h++;
										}
									}
								}
							}
						}
					}
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
