package gopuffpageobject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class GoPuffSearchPageObject 
{
    WebDriver driver;
    
    By gopuffproductsearchbox = By.xpath("//input[@id='product-search']");
    
    By gopuffproductelement   = By.xpath("(//h3[@class='cat-bubble subcat-tile'])[1]");
    
    By gopuffproductelementsearchresults = By.xpath("//div[@class='gp-product-tile__text']");
    
    public  GoPuffSearchPageObject(WebDriver driver)
    {
        this.driver=driver;
    }
    
    public void enterproductintosearchbox(String productName)
    {
        driver.findElement(gopuffproductsearchbox).sendKeys(productName);
    }
    
    public void clickelementtab()
    {
        driver.findElement(gopuffproductelement).click();
    }
    
    public List<WebElement> returnsearchresults()
    {
        List <WebElement> searchresults = driver.findElements(gopuffproductelementsearchresults);
        return searchresults;
    }
    

}

