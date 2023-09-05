package com.rudyy.mousemover.logic;

import com.rudyy.mousemover.logic.MouseMover;
import com.rudyy.mousemover.logic.ToMachArgumentsException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class MouseMoverApplicationTests {

	@Test
	void testExtractedHourAndMinute() throws ToMachArgumentsException {

		assertArrayEquals(new int[]{18, 21}, MouseMover.extractedHourAndMinute(new String[]{"18", "21"}));
		assertArrayEquals(new int[]{18, 00}, MouseMover.extractedHourAndMinute(new String[]{"18"}));
		assertThrows(NumberFormatException.class, () -> MouseMover.extractedHourAndMinute(new String[]{"18", "sdf"}));
		assertThrows(ToMachArgumentsException.class, () -> MouseMover.extractedHourAndMinute(new String[]{"18", "12", "12"}));
	}


	@Test
	void testIfSendTrue() {
		assertEquals(true, MouseMover.ifSendTimeEqualsCurrentTome(true, true, new int[]{18, 21}));
		assertEquals(true, MouseMover.ifSendTimeEqualsCurrentTome(true, false, new int[]{18, 21}));
	}

}
