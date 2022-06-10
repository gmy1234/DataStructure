package log;

import java.util.Date;

/**
 * @author gmydl
 * @title: LoggingEvent
 * @projectName DataStructure
 * @description: TODOr
 * @date 2022/6/10 21:24
 */
public class LoggingEvent {

    public Date timestamp = new Date(System.currentTimeMillis());  // 日志时间戳
    private DebugLevel level;  // 日志级别
    private Object message; // 日志主题
    private String threadName;  // 线程名称
    private long threadId ;  //线程id
    private String loggerName;  //日志名称

    public LoggingEvent() {
    }


    public LoggingEvent(DebugLevel level, String msg, String name) {
        this.level = level;
        this.message = msg;
        this.loggerName = name;
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public DebugLevel getLevel() {
        return level;
    }

    public void setLevel(DebugLevel level) {
        this.level = level;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    @Override
    public String toString() {
        return "LoggingEvent{" +
                "timestamp=" + timestamp +
                ", level=" + level +
                ", message=" + message +
                ", threadName='" + threadName + '\'' +
                ", threadId=" + threadId +
                ", loggerName='" + loggerName + '\'' +
                '}';
    }
}
