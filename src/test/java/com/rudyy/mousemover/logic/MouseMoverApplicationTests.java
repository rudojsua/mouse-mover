package com.rudyy.mousemover.logic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MouseMoverApplicationTests {

//    @InjectMocks
//    static MouseMover mouseMover = new MouseMover();
//
//    @Mock
//    private Date date;
//
//
//    @Mock
//    private LocalTime localTime;

    @Test
    void testExtractedHourAndMinute() throws ToMachArgumentsException {

        assertArrayEquals(new int[]{18, 21}, MouseMover.extractedHourAndMinute(new String[]{"18", "21"}));
        assertArrayEquals(new int[]{18, 00}, MouseMover.extractedHourAndMinute(new String[]{"18"}));
        assertThrows(NumberFormatException.class, () -> MouseMover.extractedHourAndMinute(new String[]{"18", "sdf"}));
        assertThrows(ToMachArgumentsException.class, () -> MouseMover.extractedHourAndMinute(new String[]{"18", "12", "12"}));
    }


    @Test
    void testIfSendTrue() {

        assertEquals(true, MouseMover.ifSendTimeEqualsCurrentTime(true, true, new int[]{18, 21}));
        assertEquals(true, MouseMover.ifSendTimeEqualsCurrentTime(true, false, new int[]{18, 21}));


//        boolean checkTime = true;
//        boolean ifTimeWasSend = true;
//        int[] extractedHourAndMinute = {12, 30};
//
//
//        Date dateMock = Date.from(Instant.parse("2023-01-01T12:30:00Z"));
//        when(LocalTime.now()).thenReturn(LocalTime.of(12, 30));
//
//        LocalTime localTimeMock = LocalTime.of(12, 30);
//
//        // Mockowanie obiektu Date
//        MouseMover mouseMover = new MouseMover();
//
//        // Wywołanie metody do przetestowania
//        boolean result = mouseMover.ifSendTimeEqualsCurrentTime(checkTime, ifTimeWasSend, extractedHourAndMinute);
//
//        // Sprawdzenie wyniku
//        assertFalse(result); // Oczekujemy, że wynik będzie false
    }

}
