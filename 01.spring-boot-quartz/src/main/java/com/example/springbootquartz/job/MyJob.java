package com.example.springbootquartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyJob extends QuartzJobBean {

    /**
     * 定时任务的逻辑写在这里
     *
     * <p>定时任务的配置和使用并不麻烦，重要的是定时任务的业务逻辑实现，
     * 比如每隔多长时间通过某种方式从某系统获取某些数据，进而存到当前系统数据库中
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm").format(LocalDateTime.now()));
    }
}
