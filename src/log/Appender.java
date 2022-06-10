package log;

/**
 * @author gmydl
 * @title: Appender
 * @projectName DataStructure
 * @description: 日志输出功能
 * @date 2022/6/10 21:24
 */
public interface Appender {

    /**
     * 日志输出方式
     * @param event
     */
    void append(LoggingEvent event);
}
