package log;

/**
 * @author gmydl
 * @title: Logger
 * @projectName DataStructure
 * @description: 日志打印入口
 * @date 2022/6/10 21:34
 */
public interface Logger {

    void info(String msg);

    void debug(String msg);

    void warn(String msg);

    void error(String msg);

    String getName();
}
