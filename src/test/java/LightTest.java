import org.example.models.Light;
import org.junit.Assert;
import org.junit.Test;

public class LightTest {

    @Test
    public void setListOnSuccess(){
        Light light = new Light();
        Assert.assertFalse(light.isLightOn());
        light.setLightOn(true);
        Assert.assertTrue(light.isLightOn());
    }
}
