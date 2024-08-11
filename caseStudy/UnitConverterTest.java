import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitConverterTest {

    @Test
    public void testConvertLength() {
        // Test meter to kilometer
        assertEquals(1.0, UnitConverter.convertLength(1000, "meter", "kilometer"), 0.001);
        // Test kilometer to meter
        assertEquals(1000.0, UnitConverter.convertLength(1, "kilometer", "meter"), 0.001);
       
    }

    @Test
    public void testConvertWeight() {
        // Test kg to pound
        assertEquals(2.20462, UnitConverter.convertWeight(1, "kg", "pound"), 0.00001);
        // Test pound to kg
        assertEquals(1.0, UnitConverter.convertWeight(2.20462, "pound", "kg"), 0.00001);
      
    }

    @Test
    public void testConvertVolume() {
        // Test liter to milliliter
        assertEquals(1000.0, UnitConverter.convertVolume(1, "liter", "milliliter"), 0.001);
        // Test milliliter to liter
        assertEquals(1.0, UnitConverter.convertVolume(1000, "milliliter", "liter"), 0.001);
      
    }
}
