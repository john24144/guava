package com.google.common.util.concurrent;

import static org.junit.Assert.assertEquals;

import com.google.common.util.concurrent.RateLimiterTest.FakeStopwatch;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.Test;

public class SmoothRateLimiterTest {

  private final FakeStopwatch stopwatch = new FakeStopwatch();

  @Test
  public void reserveEarliestAvailable() {
    long limit = 80000;
    RateLimiter limiter = SmoothRateLimiter.create(limit, stopwatch);
    long expected = limiter.reserveEarliestAvailable(0, 0);
    assertEquals(expected, 0);


    /*
    long aquired = 0L;
    while (true) {
      if (limiter.tryAcquire()) {
        ++aquired;
      }
      if (aquired == limit) {
        logger.trace("Acquire" + aquired + ", cost: " + stopwatch.readMicros() + "ms");
        aquired = 0;
        stopwatch.readEventsAndClear();
      }
    }

     */
  }

}
