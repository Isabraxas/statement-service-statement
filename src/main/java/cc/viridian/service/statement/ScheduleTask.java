package cc.viridian.service.statement;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {

    @Scheduled(cron = "0 * * * * ?")  //each minute at 0 seconds
    //@Scheduled(fixedDelay = 1000)
    public void scheduleTaskUsingCronExpression() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
            "schedule tasks using cron jobs - " + now);
        System.out.println("Current Thread : " +  Thread.currentThread().getName());
    }
}
