package com.stu.luanvan.config;

import com.stu.luanvan.repository.ReviewRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class ConExpressionConfig {
    @Autowired
    private ReviewRepository reviewRepository;
    private final Logger logger = LogManager.getLogger(getClass());
    @Bean
    public TaskScheduler taskScheduler() {
        final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        return scheduler;
    }
    @Scheduled(fixedDelay = 1000*60*10)
    public void scheduleReviewCommentFixedDelayTask() throws InterruptedException{
        try{
            var review = reviewRepository.findByStatusFalse();
            review.forEach(e->{
                if(e.getRate()>2){
                    e.setStatus(true);
                }
            });
            reviewRepository.saveAll(review);
        }catch (Exception ex){
            logger.error(ex);
        }
    }

}
