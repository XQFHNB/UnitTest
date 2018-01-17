
package test.com.xqf.test.utils;

import com.xqf.test.utils.UtilString;
import org.junit.Assert;
import org.junit.Test;

/**
 * UtilString Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>??? 13, 2018</pre>
 */
public class UtilStringTest {



    /**
     * Method: bothAreDecNum(String str1, String str2)
     */
    @Test
    public void testBothAreDecNum() throws Exception {

    }

    /**
     * Method: strIsDecNum(String str)
     */
    @Test
    public void testStrIsDecNum() throws Exception {
        //°×ºÐµÄ²âÊÔÓÃÀý
        String testString1 = "";
        String testString2 = "- ";
        String testString3 = ".";
        String testString4a = "11";
        String testString4b = "11.11";
        String testString5a = "1A";
        String testString5b = "1a";
        String testString5c = "a";

        //ºÚºÐµÄ²âÊÔÓÃÀý
        String testString6 = "2";
        String testString7 = "22222222222222222";
        String testString8 = "-2";
        String testString9 = "-22222222222222222";
        String testString10 = "0";
        String testString11 = "2.0";
        String testString12 = "0.2";
        String testString13 = "-a";
        String testString14 = "1a";

        Assert.assertSame(false, UtilString.strIsDecNum(testString1));
        Assert.assertSame(false, UtilString.strIsDecNum(testString2));
        Assert.assertSame(false, UtilString.strIsDecNum(testString3));
        Assert.assertSame(true, UtilString.strIsDecNum(testString4a));
        Assert.assertSame(true, UtilString.strIsDecNum(testString4b));
        Assert.assertSame(false, UtilString.strIsDecNum(testString5a));
        Assert.assertSame(false, UtilString.strIsDecNum(testString5b));
        Assert.assertSame(false, UtilString.strIsDecNum(testString5c));

        Assert.assertSame(true, UtilString.strIsDecNum(testString6));
        Assert.assertSame(true, UtilString.strIsDecNum(testString7));
        Assert.assertSame(true, UtilString.strIsDecNum(testString8));
        Assert.assertSame(true, UtilString.strIsDecNum(testString9));
        Assert.assertSame(true, UtilString.strIsDecNum(testString10));
        Assert.assertSame(true, UtilString.strIsDecNum(testString11));
        Assert.assertSame(true, UtilString.strIsDecNum(testString12));
        Assert.assertSame(false, UtilString.strIsDecNum(testString13));
        Assert.assertSame(false, UtilString.strIsDecNum(testString14));


    }

    /**
     * Method: bothAreHexNum(String str1, String str2)
     */
    @Test
    public void testBothAreHexNum() throws Exception {
        //TODO: Test goes here... 
    }

    /**
     * Method: strIsHexNum(String str)
     */
    @Test
    public void testStrIsHexNum() throws Exception {

        String testString35="1234acd";
        String testString36="1234";
        String testString37="1234acdef";
        String testString38="1234acdefg";

        Assert.assertSame(true,UtilString.strIsHexNum(testString35));
        Assert.assertSame(true,UtilString.strIsHexNum(testString36));
        Assert.assertSame(true,UtilString.strIsHexNum(testString37));
        Assert.assertSame(false,UtilString.strIsHexNum(testString38));

        //TODO: Test goes here... 
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMain() throws Exception {
        //TODO: Test goes here... 
    }

}
