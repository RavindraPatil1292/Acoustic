package testCases;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom_HomePage.HomePage;
import utilities.ExcelUtils;

public class NewTest {
	HomePage homePage;

	// test case to verify error when user clicked "Photos" without selecting
	// country
	@Test(priority = 1)
	public void photosError() {
		homePage = new HomePage();
		homePage.viewPhotos();
		Assert.assertTrue(true, "Error not displayed when click on Photos without selecting country");
	}

	// test case to verify error when user clicked "Tourist Places" without
	// selecting country
	@Test(priority = 2)
	public void touristPlacesError() {
		homePage.viewTouristPlaces();
		Assert.assertTrue(true, "Error not displayed when click on Tourist Places without selecting country");
	}

	// Verify photos for country
	@Test(priority = 3, dataProvider = "dp")
	public void verifyPhotos(Hashtable<String, String> data) {
		homePage.switchToDefault();
		homePage.selectRegion(data.get("region"));
		homePage.selectCountry(data.get("country"));
		String pageTitle = homePage.viewPhotos();
		Assert.assertEquals(pageTitle, "Photos");
	}

	// Verify tourist places for country
	@Test(priority = 4, dataProvider = "dp")
	public void verifyTouristPlaces(String region, String country) {
		homePage.switchToDefault();
		homePage.selectRegion(region);
		homePage.selectCountry(country);
		String pageTitle = homePage.viewTouristPlaces();
		Assert.assertEquals(pageTitle, "Tourist Places");
	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) throws Exception {
		ExcelUtils.setExcelFile(System.getProperty("user.dir") + "\\src\\test\\resources\\Test Data\\Test Data.xslx");
		int rows = ExcelUtils.getRowCount("Sheet 1");
		int cols = ExcelUtils.getColumnCount("Sheet 1");
		Object[][] data = new Object[rows][1];
		Hashtable<String, String> table = null;
		for (int i = 1; i <= rows; i++) {
			table = new Hashtable<String, String>();
			for (int j = 0; j < cols; j++) {
				table.put(ExcelUtils.getCellData("Sheet 1", 0, j), ExcelUtils.getCellData("Sheet 1", i, j));
				data[i - 1][0] = table;
			}
		}
		return data;
	}
}
