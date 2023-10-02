package com.metlife;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */

//run from run button on the top
@Test
public class App 
{
    @DataProvider
    public Object[][] data() {
        return new String[][]{new String[]{"data1"}, new String[]{"data2"}};
    }
    @Test(dataProvider = "data")
    public void test(String d) {
        Assert.assertEquals("First Line\nSecond Line", "First Line\nSecond Line");
    }

}
