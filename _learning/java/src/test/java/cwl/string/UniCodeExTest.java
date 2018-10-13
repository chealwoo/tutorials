package cwl.string;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UniCodeExTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_UniCode() {
        Assertions.assertThat(Character.UnicodeBlock.of('a') == Character.UnicodeBlock.BASIC_LATIN).isTrue(); //true
        Assertions.assertThat(Character.UnicodeBlock.of('�') == Character.UnicodeBlock.BASIC_LATIN).isFalse(); //false
    }
}