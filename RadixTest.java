import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RadixTest {

	@Test
	void test() {
		Sort sort = new Sort();
		Integer[] test = new Integer[3];
		test[0] = 2;
		test[1] = 1;
		test[2] = 3;
		
		Integer[] correct = new Integer[3];
		correct[0] = 1;
		correct[1] = 2;
		correct[2] = 3;
		
		Integer[] empty = sort.RadixSort(test);
		
		assertEquals(correct[0],empty[0]);
		assertEquals(correct[1],empty[1]);
		assertEquals(correct[2],empty[2]);
	}

}
