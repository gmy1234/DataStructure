package log;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author gmydl
 * @title: ConsoleAppender
 * @projectName DataStructure
 * @description: 控制台输出方式
 * @date 2022/6/10 21:26
 */
public class ConsoleAppender implements Appender{

    private OutputStream out = System.out;
    private OutputStream out_err = System.err;
    @Override
    public void append(LoggingEvent event) {
        try {
            out.write(event.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
