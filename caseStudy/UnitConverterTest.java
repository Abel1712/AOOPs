import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitConverterTest {

    @Test
    public void testConvertLength() {
        // Test meter to kilometer
        assertEquals(1.0, UnitConverter.convertLength(1000, "meter", "kilometer"));
        // Test kilometer to meter
        assertEquals(1000.0, UnitConverter.convertLength(1, "kilometer", "meter"));
       
    }

    @Test
    public void testConvertWeight() {
        // Test kg to pound
        assertEquals(2.20462, UnitConverter.convertWeight(1, "kg", "pound"));
        // Test pound to kg
        assertEquals(1.0, UnitConverter.convertWeight(2.20462, "pound", "kg"));
      
    }

    @Test
    public void testConvertVolume() {
        // Test liter to milliliter
        assertEquals(1000.0, UnitConverter.convertVolume(1, "liter", "milliliter"));
        // Test milliliter to liter
        assertEquals(1.0, UnitConverter.convertVolume(1000, "milliliter", "liter"));
      
    }
}
