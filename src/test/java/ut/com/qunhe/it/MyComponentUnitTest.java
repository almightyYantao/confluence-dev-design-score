package ut.com.qunhe.it;

import org.junit.Test;
import com.qunhe.it.api.MyPluginComponent;
import com.qunhe.it.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}