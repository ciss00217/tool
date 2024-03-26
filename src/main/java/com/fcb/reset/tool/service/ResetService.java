package com.fcb.reset.tool.service;

import com.fcb.reset.tool.config.ResetBatchScriptConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ResetService {

    @Value("${app.reset-batch-script.start-time}")
    private String cronExpression;


    @Autowired
    private BatchScriptService batchScriptService;

    @Autowired
    private ResetBatchScriptConfigurationProperties resetBatchScriptConfigurationProperties;

    // 每天凌晨 0 点触发
    @Scheduled(cron ="${app.reset-batch-script.start-time}")
    public void doAction(){
        Map<String,String> map=resetBatchScriptConfigurationProperties.getMap();
        //STOP_ACTIVE_FLOWCHART
        batchScriptService.executeBatchScript(map.get("STOP_ACTIVE_FLOWCHART"));
        //KILL_UNICA_TASK
        batchScriptService.executeBatchScript(map.get("KILL_UNICA_TASK"));
        //STOP_WAS
        batchScriptService.executeBatchScript(map.get("STOP_WAS"));
        //START_WAS
        batchScriptService.executeBatchScript(map.get("START_WAS"));
        //START_CMP_SERVER
        batchScriptService.executeBatchScript(map.get("START_CMP_SERVER"));
        //EXECUTE_LOCK_IDS
        batchScriptService.executeBatchScript(map.get("EXECUTE_LOCK_IDS"));
        //HOUSE_KEEPING
        batchScriptService.executeBatchScript(map.get("HOUSE_KEEPING"));

    }
}


                //STOP_ACTIVE_FLOWCHART
                //KILL_UNICA_TASK
                //STOP_WAS
                //START_WAS
                //START_CMP_SERVER
                //EXECUTE_LOCK_IDS
                //HOUSE_KEEPING
