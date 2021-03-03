package com.example.springbootquartz.config;

import com.example.springbootquartz.job.MyJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(MyJob.class)
                // 起个名
                .withIdentity("myJobDetail")
                // 没有被trigger指向的情况下任务依然被保留
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger myJobTrigger() {
        // cron表达式详见 https://www.cnblogs.com/sawyerlsy/p/7208321.html
        // * 任意值，如果秒域为*表示任意一秒都会触发
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("* * * * * ?");
        return TriggerBuilder.newTrigger()
                // 关联上述的JobDetail
                .forJob(myJobDetail())
                // 起个名
                .withIdentity("myJobTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}