package testScript;

import org.testng.annotations.BeforeClass;

import baseclassLibrary.BaseClass;
import library.TestDataImport;
import pages.AllScreens;

public class Test extends BaseClass {
	private AllScreens screen;
	private TestDataImport tdImport;
	
	@BeforeClass
	public void initialize() {
		screen = new AllScreens(driver);
		tdImport = new TestDataImport();
		tdImport.readSheet("Result");
	}
	
	@org.testng.annotations.Test
	public void takeTest() {
		screen.cdcTest();
	}
}
