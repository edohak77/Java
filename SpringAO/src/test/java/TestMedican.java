import interfaces.Thinker;
import org.junit.Test;
import pojo.Megican;
import pojo.Volunteer;

import static org.junit.Assert.assertEquals;

public class TestMedican {
    private Volunteer volunteer;
    private Megican megican;
    @Test
    public void magicianShouldReadVolunteersMind() {
        volunteer.thinkOfSomething("Queen of Hearts");
        assertEquals("Queen of Hearts", megican.getToughth());
    }
}
