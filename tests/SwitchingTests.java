import edu.bsu.cs327.Switching;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class SwitchingTests {
    @Test
    public void testSwitching(){
        Switching s = new Switching();
        s.handleInput("123456", 12, "abcdef");
        ArrayList<HashMap> switchingTable = s.getTable();
        Assert.assertEquals(switchingTable.toString(), "[{123456=12}]");
    }
}
