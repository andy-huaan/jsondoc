package com.breadenglish.service;
import com.breadenglish.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ScheduleServiceImpl implements ScheduleService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ScheduleServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    //@Scheduled(cron = "0 20 0 * * ?")  //每天的20分准备数据
    @Transactional
    public void everyDay(){
        System.out.println("------测试day------");
        try {
            String date = DateUtils.getPreAfterDateTime(-2);
            jdbcTemplate.execute("call statistic.test_procedure('" + date + "')");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    //@Scheduled(cron="0 50 * * * ?")  //每小时的50分数据录入
    @Transactional
    public void ereryHour(){
        System.out.println("------测试hour------");
        try {
            String date = DateUtils.getPreAfterDateTime(0);
            jdbcTemplate.execute("call statistic.test_procedure2('" + date + "')");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
