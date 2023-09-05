package com.rudyy.mousemover.logic;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class MouseMover {
    public static void main(String[] args) throws AWTException, InterruptedException, ToMachArgumentsException {
        PointerInfo a;
        Point b;
        int x;
        int y;
        final long startTime = System.currentTimeMillis();
        int howLongWorks;
        String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        System.out.println("Start  " + timeStamp);
        int[] extractedHourAndMinute = extractedHourAndMinute(args);
        if (extractedHourAndMinute[0] != 0) {
            System.out.println("The Program will stops at " + extractedHourAndMinute[0] + ":" + extractedHourAndMinute[1]);
        }else {
            System.out.println("The program will not stop automatically");
        }
        boolean checkTime = true;
        boolean ifTimeWasSend = extractedHourAndMinute[0] != 0;

        while (checkTime) {
            checkTime = ifSendTimeEqualsCurrentTome(checkTime, ifTimeWasSend, extractedHourAndMinute);
            a = MouseInfo.getPointerInfo();
            b = a.getLocation();
            x = (int) b.getX();
            y = (int) b.getY();
            Robot r = new Robot();
            r.mouseMove(x + 1, y + 1);
            r.mouseMove(x - 1, y - 1);
            Thread.sleep(55000);
            howLongWorks = (int) (System.currentTimeMillis() - startTime) / 1000 / 60;
            if ((howLongWorks % 60) < 10) {
                System.out.println(howLongWorks / 60 + ":0" + (howLongWorks % 60));
            } else {
                System.out.println(howLongWorks / 60 + ":" + howLongWorks % 60);
            }
        }
        LocalTime localTime = LocalTime.now();
        System.out.println("Program was stopped at: " + localTime.getHour() + ":" + localTime.getMinute());
    }

    static boolean ifSendTimeEqualsCurrentTome(Boolean checkTime, Boolean ifTimeWasSend, int[] extractedHourAndMinute) {
        if (checkTime == true && ifTimeWasSend == true) {
            Date date = new Date();
            LocalTime localTime = date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalTime();
            int hour = localTime.getHour();
            int minute = localTime.getMinute();
            if (hour == extractedHourAndMinute[0] && minute == extractedHourAndMinute[1]) {
                return false;
            }
        }
        return true;
    }

      static int[] extractedHourAndMinute(String[] args) throws ToMachArgumentsException {
        int[] receiveHourAndMinute = new int[2];
        if (args.length == 0) {
            return receiveHourAndMinute;
        }
        if (args.length == 1 || args.length == 2) {

            String[] part = new String[]{args[0], args.length == 1 ? "00" : args[1]};

            try {
                receiveHourAndMinute[0] = Integer.parseInt(part[0]);
                receiveHourAndMinute[1] = Integer.parseInt(part[1]);
            } catch (NumberFormatException e) {
                System.out.println("Date format is not correct. Should be like 18 23 or 18");
                throw e;
            }
        }
        if (args.length > 2) {
            throw new ToMachArgumentsException("To mach arguments, should be not more then 2");
        }
        return receiveHourAndMinute;
    }


}