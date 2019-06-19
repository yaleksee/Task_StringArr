import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TaskTest {
    private static Task task = null;
    private String[] mass;
    private int cointMatches;
    public TaskTest(String[] mass, int cointMatches){
        this.mass = mass;
        this.cointMatches = cointMatches;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {new String[]{"abc", "bac", "abc", "d", "et", "d", "et", "zzz"}, 4},
                {new String[]{"abc", "oo", "zqm", "16", "s2", "d", "et", "abc"}, 7},
                {new String[]{"abc", "cba"}, 1},
                {new String[]{""}, 1},
                {new String[]{}, 0},
        };
        return Arrays.asList(data);
    }

    @Test
    public void boolTest() {
        Assert.assertEquals(task.toConvert(mass).size(), cointMatches);
    }

    @Before
    public void init() {
        task = new Task();
    }

    @After
    public void tearDown() throws Exception {
        task = null;
    }
}
