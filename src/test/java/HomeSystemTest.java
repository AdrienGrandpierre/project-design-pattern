import org.example.models.HomeSystem;
import org.example.models.Light;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HomeSystemTest {

    private HomeSystem homeSystem;

    @Before
    public void before() {
        homeSystem = new HomeSystem();
    }

    @Test
    public void thingsEmptyItInitial() {
        Assert.assertTrue(homeSystem.getThingsList().isEmpty());
    }

    @Test
    public void addLightSuccess() {
        homeSystem.addThings(new Light());
        Assert.assertEquals(1, homeSystem.getThingsList().size());
    }

    @Test
    public void toggleLighsWhenHomeSystemIsOnSuccess() {
        homeSystem.addThings(new Light());
        homeSystem.addThings(new Light());

        homeSystem.toggleAllLights(true);
        for (Light l : homeSystem.getLights()) {
            Assert.assertTrue(l.isLightOn());
        }
    }

    @Test
    public void toggleLightWhenHomeSystemIsOffFail() {
        homeSystem.addThings(new Light());
        homeSystem.addThings(new Light());
        homeSystem.setState(HomeSystem.State.OFF);

        homeSystem.toggleAllLights(true);

        for (Light l : homeSystem.getLights()) {
            Assert.assertFalse(l.isLightOn());
        }
    }

}
