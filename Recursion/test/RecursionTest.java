import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionTest {

    static final double EPSILON = 0.0001;

    @Test
    void sumRange() {
        assertEquals(1, Recursion.sumRange(1));
        assertEquals(3, Recursion.sumRange(2));
        assertEquals(6, Recursion.sumRange(3));
    }

    @Test
    void fac() {
        assertEquals(1, Recursion.fac(1));
        assertEquals(2, Recursion.fac(2));
        assertEquals(6, Recursion.fac(3));
        assertEquals(720, Recursion.fac(6));
    }

    @Test
    void harmonic() {
        assertEquals(1.0, Recursion.harmonic(1), EPSILON);
        assertEquals(3.0/2.0, Recursion.harmonic(2), EPSILON);
        assertEquals(11.0/6.0, Recursion.harmonic(3), EPSILON);
        assertEquals(25.0/12.0, Recursion.harmonic(4), EPSILON);
    }

}