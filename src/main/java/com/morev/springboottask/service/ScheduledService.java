package com.morev.springboottask.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {


    /**
     * second, minute, hour, day of month, month, day of week.
     * 0 * * * * MON-FRI
     * 0 0/5 14,18 * * ?   每天14点整，和18点整，每5秒钟自行一次
     * 0 15 10 ? * 1-6     每个月的周一至周六 10：15分执行一次
     * 0 0 2 ? * 6L        每个月的最后一个星期6凌晨2点执行
     * 0 0 2 LW * ?        每个月的最后一个凌晨2点执行1次
     * 0 0 2-4 ? * 1#1     每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次
     *
     */

    //@Scheduled(cron = "0 * * * * MON-FRI") //定时任务
    //@Scheduled(cron = "0,1,2,3,4,5 * * * * MON-FRI") //枚举
    //@Scheduled(cron = "0-5 * * * * MON-FRI") //区间
    @Scheduled(cron = "0/5 * * * * MON-FRI") //步长 每5秒执行一次
    public void hello() {
        System.out.println("hello...");
    }
}
