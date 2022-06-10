package log;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author gmydl
 * @title: FileAppender
 * @projectName DataStructure
 * @description: TODO
 * @date 2022/6/10 22:08
 */
public class FileAppender implements Appender {

    private static final String LOCATION  = "/Users/gmydl/Desktop/picture/log.txt";

    @Override
    public void append(LoggingEvent event) {
        // 输入的日志信息
        String logInfo = "[" + event.getTimestamp() + "]:" + ",message:" + event.getMessage() +
                "Level:"+event.getLevel() ;

        try {
            // 创建日志文件
            OutputStream logFile = new FileOutputStream(LOCATION);
            logFile.write(logInfo.getBytes(StandardCharsets.UTF_8));
            logFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
