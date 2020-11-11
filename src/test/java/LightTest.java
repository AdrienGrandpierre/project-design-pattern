import org.example.models.Light;
import org.example.models.Thing;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LightTest {

    private Light light;

    @Before
    public void before(){
        light = new Light();
    }

    @Test
    public void setLightOnInReachableStateSuccess() {
        Assert.assertEquals(Thing.State.REACHABLE, light.getState());
        Assert.assertFalse(light.isLightOn());

        light.setLightOn(true);
        Assert.assertTrue(light.isLightOn());
    }

    @Test
    public void setLightOnInUnreachableStateFail() {
        light.setState(Thing.State.UNREACHABLE);

        light.setLightOn(true);
        Assert.assertFalse(light.isLightOn());
    }
}
