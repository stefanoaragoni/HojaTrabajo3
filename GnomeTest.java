import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GnomeTest {

	@Test
	void test() {
		Sort s = new Sort();
		
		Integer[] t = new Integer[4];
		t[0] = 4;
		t[1] = 2;
		t[2] = 3;
		t[3] = 1;
		
		Integer[] expected = new Integer[4];
		expected[0] = 1;
		expected[1] = 2;
		expected[2] = 3;
		expected[3] = 4;
		
		Integer[] bucket = s.GnomeSort(t);
		
		
		assertEquals(expected[0], bucket[0]);
		assertEquals(expected[1], bucket[1]);
		assertEquals(expected[2], bucket[2]);
		assertEquals(expected[3], bucket[3]);
	}

}
