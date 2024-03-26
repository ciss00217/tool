package com.fcb.reset.tool.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
@Service
public class BatchScriptService {

    public void executeBatchScript(String scriptPath ) {
        try {
            log.info("====== Start {} ====== ",scriptPath);
            // 创建 ProcessBuilder 对象
            ProcessBuilder processBuilder = new ProcessBuilder();

            // 设置命令及其参数
            processBuilder.command("cmd.exe", "/c", scriptPath);

            // 启动进程
            Process process = processBuilder.start();

            // 读取进程的输出
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    log.info("{}", line);
                }
            } catch (IOException e) {
                log.error("batch Error",e);
            }
            // 等待进程执行完毕
            int exitCode = process.waitFor();

            log.info("====== End :{} exitCode:{} ====== ",scriptPath,exitCode);

            //

        } catch (IOException | InterruptedException e) {
            log.error("batch Error",e);
        }
    }
}
