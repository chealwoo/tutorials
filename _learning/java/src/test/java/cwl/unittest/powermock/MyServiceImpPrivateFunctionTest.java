package cwl.unittest.powermock;

import cwl.unittest.MyService;
import cwl.unittest.MyServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertTrue;


/**
 * https://automationrhapsody.com/call-private-method-powermock/
 */
public class MyServiceImpPrivateFunctionTest {

    private MyService myService;

    @Before
    public void setUp() throws Exception {
        myService = new MyServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void privateFunctionTestExample() throws Exception {
        Whitebox.invokeMethod(myService, "privateDo", 1, "test");
        assertTrue(Whitebox.invokeMethod(myService, "privateGetTrue", "test"));
    }
}