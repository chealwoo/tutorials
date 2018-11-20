package cwl.unittest.powermock;

import cwl.unittest.MyService;
import cwl.unittest.MyServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;



@RunWith(PowerMockRunner.class)
@PrepareForTest({MyServiceImpl.class})
public class MyServiceImpStaticFunctionTest {

    private MyService myService;

    @Before
    public void setUp() throws Exception {
        myService = new MyServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void staticFunctionTestExample() throws Exception {
        PowerMockito.mockStatic(MyServiceImpl.class);

        MyServiceImpl.publicDo(1,"test");

        PowerMockito.verifyStatic(Mockito.times(1));
    }
}