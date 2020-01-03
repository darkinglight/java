import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class SafariIntegrationTest {
    @Test
    public void testHelloWorldIndexPage() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/helloworld.html");
        WebElement element = driver.findElement(By.tagName("h2"));
        assertThat(element.getText(), is("Hello World!"));
    }
}
