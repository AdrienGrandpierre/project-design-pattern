import org.example.models.Thermostat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ThermostatTest {

    private Thermostat thermostat;

    @Before
    public void before(){
        thermostat = new Thermostat(5,20);
    }

    @Test
    public void setTemperatureInRangeMinMaxSuccess(){
        Assert.assertEquals(thermostat.getMinTemperature(), thermostat.getTemperature(), 00.1);
        Assert.assertTrue(thermostat.setTemperature(12));
    }

    @Test
    public void setTemperatureNotInRangeMinMaxFail(){
        Assert.assertFalse(thermostat.setTemperature(400));
    }
}
