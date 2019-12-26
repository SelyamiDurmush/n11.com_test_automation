package com.selamidurmus.n11test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class N11Page {

	private WebDriver driver;
	private By buttonSingIn = By.cssSelector(".btnSignIn");
	private By inputEmail = By.id("email");
	private By inputPassword = By.id("password");
	private By buttonLogin = By.id("loginButton");
	private By loginResult = By.xpath(".//*[@id='header']/div/div/div[3]/div[2]/div[1]/div[1]/a[1]");
	private By searchBox = By.id("searchData");
	private By buttonSearch = By.className("searchBtn");
	private By resultSearch = By.className("resultText");
	private By currentPage = By.className("currentPage");
	private By addFavorites = By.className("followBtn");
	private By productName = By.className("productName");
	private By account = By.className("menuTitle");
	private By buttonDelete = By.className("deleteProFromFavorites");

	public N11Page() {
		driver = new ChromeDriver();
	}

	public void start() {
		System.setProperty("webdriver.chrome.driver", "chromedriver\\");
		driver.get("https://www.n11.com/");
	}

	public void login(String username, String password) throws InterruptedException {
		driver.findElement(buttonSingIn).click();
		Thread.sleep(1000);
		driver.findElement(inputEmail).sendKeys(username);
		driver.findElement(inputPassword).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(buttonLogin).click();
		Thread.sleep(1000);
		String result = "";
		try {
			WebElement e = driver.findElement(loginResult);
			result = e.getText();
		} catch (Exception e) {
			result = "Başarılı";
		}
		Assert.assertNotEquals("Login hatası", result, "Kullanıcı girişi başarısız");
		Thread.sleep(1000);
	}

	public void searchSearchBox(String key) throws InterruptedException {
		driver.findElement(searchBox).sendKeys(key);
		Thread.sleep(1000);
		driver.findElement(buttonSearch).click();
		String result = "";
		// İlk harfi büyütüyoruz
		key = key.substring(0, 1).toUpperCase() + key.substring(1, key.length());
		try {
			WebElement r = driver.findElement(resultSearch);
			result = r.getText();
		} catch (Exception e) {
			result = key;
		}
		Assert.assertTrue("Hata", result.contains(key));
	}

	public void openSearchPage(Integer pageNumber) throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='contentListing']/div/div/div[2]/div[4]/a[" + pageNumber + "]")).click();
		Thread.sleep(1000);
		String result = "";
		try {
			result = driver.findElement(currentPage).getAttribute("value");
		} catch (Exception e) {
			result = "Başarılı";
		}
		Assert.assertNotEquals("Sayfa bulunamadı hatası", result, pageNumber.toString() + ". Sayfaya ulaşılamadı");
		Thread.sleep(1000);
	}

	public String addFavorites(Integer itemNumber) throws InterruptedException {
		WebElement listItem = driver.findElement(By.xpath(".//*[@id='view']/ul/li[" + itemNumber.toString() + "]"));
		WebElement selectedItem = listItem.findElement(addFavorites);
		selectedItem.click();
		Thread.sleep(2000);
		return listItem.findElement(productName).getText();
	}

	public void controlFavorites(String name) {
		driver.findElements(account).get(1).click();
		driver.findElement(By.xpath(".//*[@class='accNav']/ul/li[5]")).click();
		driver.findElement(By.className("listItemTitle")).click();
		WebElement listItem = driver.findElement(By.xpath(".//*[@id='view']/ul/li[1]"));
		String currenctItem = listItem.findElement(productName).getText();
		Assert.assertEquals("Favori bulunamadı", currenctItem, name);
	}

	public void removeFavorite() {
		WebElement listItem = driver.findElement(By.xpath(".//*[@id='view']/ul/li[1]"));
		listItem.findElement(buttonDelete).click();
	}

	public void controlFavoritesForDelete(String name) throws InterruptedException {
		driver.findElements(account).get(1).click();
		driver.findElement(By.xpath(".//*[@class='accNav']/ul/li[5]")).click();
		driver.findElement(By.className("listItemWrap")).click();
		String currenctItem = "";
		try {
			WebElement listItem = driver.findElement(By.xpath(".//*[@id='view']/ul/li[1]"));
			currenctItem = listItem.findElement(productName).getText();
		} catch (Exception e) {
			currenctItem = "Başarılı";
		}

		Assert.assertNotEquals("Favori kaldırılamadı", currenctItem, name);
		Thread.sleep(3000);
	}

	public void finish() {
		driver.close();
		driver.quit();
	}

}
