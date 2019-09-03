package com.eva.common.timewheel;

import org.junit.Test;

import java.io.IOException;

/**
 * @Author EvaJohnson
 * @Date 2019-09-03
 * @Email g863821569@gmail.com
 */
public class TimeWheelTest {
    @Test
    public void testTimeWheel() throws IOException {
        Timer timer = new Timer();
        timer.addTask(new TimerTask(50, () -> System.out.println("Task delay 50ms.")));
        System.in.read();
    }
}
