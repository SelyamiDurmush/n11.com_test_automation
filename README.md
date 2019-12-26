# n11.com Selenium Test Automation Case with JAVA

**Test Ortam Bilgileri**<br>
Kullanılan Dil:Java
Selenium Web Driver:3.16.1<br> 
IDE:Eclips IDE Version 2019-12(4.14.0)<br> 
OS: Windows 7<br>
Browser:Chrome 79.0.3945.88<br> 
Junit version:4.12<br>

**Kurulum**<br>
Chrome ayarlaması için linkte bulunan size uygun driver'ı indirin https://chromedriver.chromium.org/<br>
N11Page.java içerisinde aşağıdaki kod üzerinde driverin yolu gösterilir ve kaydedilir.<br>
System.setProperty("webdriver.chrome.driver", "Driver_Path");<br>

# HomePageTest.java dosyası Junit ile çalıştırıldığında test başlayacaktır.Test seneryosu sırası ile aşağıdaki gibidir.<br>

1-	 http://www.n11.com<http://www.n11.com/> sitesine gelecek ve anasayfanin acildigini onaylayacak<br>
2-	Login ekranini acip, bir kullanici ile login olacak ( daha once siteye uyeliginiz varsa o olabilir )<br>
3-	Ekranin ustundeki Search alanina 'samsung' yazip Ara butonuna tiklayacak<br> 
4-	Gelen sayfada samsung icin sonuc bulundugunu onaylayacak<br>
5-	Arama sonuclarindan 2. sayfaya tiklayacak ve acilan sayfada 2. sayfanin su an gosterimde oldugunu onaylayacak<br>
6-	Ustten 3. urunun icindeki 'favorilere ekle' butonuna tiklayacak<br>
7-	Ekranin en ustundeki 'favorilerim' linkine tiklayacak<br> 
8-	Acilan sayfada bir onceki sayfada izlemeye alinmis urunun bulundugunu onaylayacak<br>
9-	Favorilere alinan bu urunun yanindaki 'Kaldir' butonuna basarak, favorilerimden cikaracak<br>
10-	Sayfada bu urunun artik favorilere alinmadigini onaylayacak.<br>  




