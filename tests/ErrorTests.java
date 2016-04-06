import edu.bsu.cs327.Switching;
import org.junit.Assert;
import org.junit.Test;

public class ErrorTests {
    @Test
    public void testFrameErrorCheckTooLarge(){
        String output = new Switching().frameErrorCheck("12abcdef");
        Assert.assertEquals("Error: MAC address must be 6 bytes!", output);
    }

    @Test
    public void testFrameErrorCheckTooSmall(){
        String output = new Switching().frameErrorCheck("abc");
        Assert.assertEquals("Error: MAC address must be 6 bytes!", output);
    }

    @Test
    public void testPortNumberCheck(){
        String output = new Switching().portErrorCheck(25);
        Assert.assertEquals("Error: Port# not supported!", output);
    }
}
