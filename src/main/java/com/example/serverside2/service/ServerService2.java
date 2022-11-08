package com.example.serverside2.service;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServerService2 {
  private static final Logger logger = LoggerFactory.getLogger(ServerService2.class);
  private static final Long TO_SECONDS = 1000L;

  public String getResult() throws InterruptedException {

    long startTime = System.currentTimeMillis();
    long waitingTime = 20000L;
    int passengers = 0;


      for (int i = 1; i <= 20; i++) {
        while (startTime + waitingTime > System.currentTimeMillis()) {
          Thread.sleep(getRandomTimeRanges(100, 3000));
          passengers++;
          logger.info(String.format("Current time: %d seconds, Passenger #: %d",
              ((System.currentTimeMillis() - startTime) / 1000), passengers));
          if (passengers == 10 && ((startTime + waitingTime) - System.currentTimeMillis() <= 10000))
            break;
        }
      }
    long elapsedTime = (System.currentTimeMillis() - startTime) / TO_SECONDS;
    logger.info(String.format("%d passengers entered into bus", passengers));
    logger.info(String.format("%d seconds passed", elapsedTime));
    return String.format("Time is passed. %d passengers entered bus for %d 'seconds'.", passengers, elapsedTime);
  }

  private int getRandomTimeRanges(int min, int max) {
    Random random = new Random();
    return random.ints(min, max)
        .findFirst()
        .getAsInt();
  }

}
