import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    private Guest francesca;

    @Before
    public void before(){
        francesca = new Guest("Francesca", 45);
    }

    @Test
    public void hasName(){
        assertEquals("Francesca", francesca.getName());
    }

    @Test
    public void hasMoney(){
        assertEquals(45, francesca.getMoney());
    }

    @Test
    public void canPayMoney(){
        assertEquals(45, francesca.getMoney());
        francesca.payMoney(5);
        assertEquals(40, francesca.getMoney());
    }


}
