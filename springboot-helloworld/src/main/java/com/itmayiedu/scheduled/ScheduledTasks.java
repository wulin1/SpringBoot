package com.itmayiedu.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @param 吴林
 * @date 2019/3/13 0013 17:30
 */
/*注入到容器中*/
@Component
public class ScheduledTasks {
@Scheduled(fixedRate =1000 )
    public void  test(){
        System.out.println("我正在1秒执行定时任务");
    }
}
