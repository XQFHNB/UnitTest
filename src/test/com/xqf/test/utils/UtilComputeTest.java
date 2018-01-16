package test.com.xqf.test.utils;

import com.xqf.test.MyModel;
import com.xqf.test.utils.UtilCompute;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * UtilCompute Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>һ�� 16, 2018</pre>
 */
public class UtilComputeTest {
//
//    @Before
//    public void before() throws Exception {
//    }
//
//    @After
//    public void after() throws Exception {
//    }

    /**
     * Method: compute(MyModel model)
     */

    MyModel model17 = new MyModel();
    String testString17a = "11", testOp17 = "+", testString17b = "11";

    MyModel model18 = new MyModel();
    String testString18a = "11111111111111111", testOp18 = "+", testString18b = "11111111111111111";

    MyModel model19 = new MyModel();
    String testString19a = "22", testOp19 = "-", testString19b = "11";

    MyModel model20 = new MyModel();
    String testString20a = "22222222222222222", testOp20 = "-", testString20b = "11111111111111111";

    MyModel model21 = new MyModel();
    String testString21a = "1", testOp21 = "*", testString21b = "2";

    MyModel model22 = new MyModel();
    String testString22a = "11111111111111111", testOp22 = "*", testString22b = "2";

    MyModel model23 = new MyModel();
    String testString23a = "2.0", testOp23 = "/", testString23b = "1.0";

    MyModel model24 = new MyModel();
    String testString24a = "22222.22222222222", testOp24 = "/", testString24b = "11111.11111111111";

    MyModel model25 = new MyModel();
    String testString25a = "2.0", testOp25 = "/", testString25b = "0";

    {

        model17.setNum1(testString17a);
        model17.setOp(testOp17);
        model17.setNum2(testString17b);

        model18.setNum1(testString18a);
        model18.setOp(testOp18);
        model18.setNum2(testString18b);

        model19.setNum1(testString19a);
        model19.setOp(testOp19);
        model19.setNum2(testString19b);

        model20.setNum1(testString20a);
        model20.setOp(testOp20);
        model20.setNum2(testString20b);

        model21.setNum1(testString21a);
        model21.setOp(testOp21);
        model21.setNum2(testString21b);

        model22.setNum1(testString22a);
        model22.setOp(testOp22);
        model22.setNum2(testString22b);

        model23.setNum1(testString23a);
        model23.setOp(testOp23);
        model23.setNum2(testString23b);

        model24.setNum1(testString24a);
        model24.setOp(testOp24);
        model24.setNum2(testString24b);

        model25.setNum1(testString25a);
        model25.setOp(testOp25);
        model25.setNum2(testString25b);

    }

    @Test
    public void testCompute() throws Exception {

        Assert.assertEquals("22", UtilCompute.compute(model17));
        Assert.assertEquals("22222222222222222", UtilCompute.compute(model18));
        Assert.assertEquals("11", UtilCompute.compute(model19));
        Assert.assertEquals("11111111111111111", UtilCompute.compute(model20));
        Assert.assertEquals("2", UtilCompute.compute(model21));
        Assert.assertEquals("22222222222222222", UtilCompute.compute(model22));
        Assert.assertEquals("2", UtilCompute.compute(model23));
        Assert.assertEquals("2", UtilCompute.compute(model24));
        Assert.assertEquals("0 can't be molecular!", UtilCompute.compute(model25));
    }


    /**
     * Method: computeByDec(MyModel model)
     */
    @Test
    public void testComputeByDec() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: computeByHex(MyModel model)
     */
    @Test
    public void testComputeByHex() throws Exception {
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
