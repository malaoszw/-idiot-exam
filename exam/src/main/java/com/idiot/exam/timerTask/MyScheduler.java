package com.idiot.exam.timerTask;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class MyScheduler {

    public static void test() throws SchedulerException, InterruptedException {
        // 1、创建调度器Scheduler
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取距离当前时间3秒后的时间
        //date.setTime(date.getTime()+3000);
        //获取当前时间
        date.setTime(date.getTime());
        //获取距离当前时间6秒后的时间
        Date endTime=new Date();
        endTime.setTime(endTime.getTime()+60000);

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
                .withIdentity("job1", "group1").build();
        // 3、构建Trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .startAt(date)
                .endAt(endTime)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(50)//每隔1s执行一次,可以设置时间
                        .repeatForever()).build();//一直执行

        //4、执行
        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("--------scheduler start ! ------------");
        scheduler.start();

        //睡眠
        TimeUnit.MINUTES.sleep(1);
       // TimeUnit.SECONDS.sleep(20);
        scheduler.shutdown();
        System.out.println("--------scheduler shutdown ! ------------");


    }
}