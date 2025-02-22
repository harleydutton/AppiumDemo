import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumTest {

    
    @Test
    static void Test2(){
        String expectedText = "asdfasdf";
        String actualText = "";
        Assert.assertEquals(expectedText,actualText);
    }
}
