import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	GradeBook g1;
	GradeBook g2;
	
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		
		g1.addScore(85);
		g1.addScore(70);
		g1.addScore(90);
		
		g2.addScore(75);
		g2.addScore(79);
		g2.addScore(98);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	/*@Test
	void testGradeBook() {
		fail("Not yet implemented");
	}*/

	@Test
	void testAddScore() {
		assertTrue(g1.toString().contentEquals("85.0 70.0 90.0 "));
		assertTrue(g2.toString().contentEquals("75.0 79.0 98.0 "));
		
		assertEquals(3, g1.getScoreSize());
		assertEquals(3, g2.getScoreSize());
	
	}

	@Test
	void testSum() {
		assertEquals(245, g1.sum(), .0001);
		assertEquals(252, g2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(70, g1.minimum(), .001);
		assertEquals(75, g2.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		assertEquals(175, g1.finalScore(), .01);
		assertEquals(177, g2.finalScore(), .01);
	}
}
