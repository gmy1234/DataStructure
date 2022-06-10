package log;

/**
 * @author gmydl
 * @title: DebugLevel
 * @projectName DataStructure
 * @description: 日志级别
 * @date 2022/6/10 21:28
 */
public enum DebugLevel {
    ERROR(50000, "ERROR"),
    WARN(40000, "WARN"),
    INFO(30000, "INFO"),
    DEBUG(20000, "DEBUG");

    private final int levelInt;
    private final String levelStr;

     DebugLevel(int i, String s) {
        levelInt = i;
        levelStr = s;
    }
    public int toInt() {
        return levelInt;
    }

    public String toString() {
        return levelStr;
    }

    public boolean isGreaterOrEqual(DebugLevel level) {
        return levelInt>=level.toInt();
    }
}
