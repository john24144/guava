package com.google.common.util.concurrent;

import static org.junit.Assert.assertEquals;

import com.google.common.util.concurrent.RateLimiterTest.FakeStopwatch;
import org.junit.Test;

public class SmoothRateLimiterTest {

  private final FakeStopwatch stopwatch = new FakeStopwatch();

  @Test
  public void reserveEarliestAvailable() {
    RateLimiter limiter = SmoothRateLimiter.create(5.0, stopwatch);
    long expected = limiter.reserveEarliestAvailable(0, 0);
    assertEquals(expected, 0);
  }

}
