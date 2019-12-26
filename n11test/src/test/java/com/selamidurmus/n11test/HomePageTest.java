package com.selamidurmus.n11test;

import org.junit.Test;

public class HomePageTest {

	@Test
	public void testCasestart() throws InterruptedException {
		N11Page homepage = new N11Page();
		homepage.start();
		homepage.login("selamidurmus9@gmail.com", "selami123");
		homepage.searchSearchBox("samsung");
		homepage.openSearchPage(2);
		String name = homepage.addFavorites(3);
		homepage.controlFavorites(name);
		homepage.removeFavorite();
		homepage.controlFavorites(name);
		homepage.finish();
	}
}
