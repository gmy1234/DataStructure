package log;

/**
 * @author gmydl
 * @title: LogcLogger
 * @projectName DataStructure
 * @description: 默认的 Logger 实现类
 * @date 2022/6/10 21:35
 */
public class LogcLogger implements Logger{

    private String name;
    private Appender appender;
    private DebugLevel level = DebugLevel.ERROR; //当 前Logger的级别，默认最低
    private int effectiveLevelInt; //冗余级别字段，方便使用


    /**
     * 过滤并输出，所有的输出方法都会调用此方法
     * @param level 日志级别
     * @param msg 输出内容
     */
    private void filterAndLog(DebugLevel level, String msg){

        LoggingEvent e = new LoggingEvent(level, msg,getName());
        //目标的日志级别大于当前级别才可以输出
        if(level.toInt() >= effectiveLevelInt){
            appender.append(e);
        }
    }

    @Override
    public void info(String msg) {
        filterAndLog(DebugLevel.INFO, msg);
    }

    @Override
    public void debug(String msg) {
        filterAndLog(DebugLevel.DEBUG, msg);
    }

    @Override
    public void warn(String msg) {
        filterAndLog(DebugLevel.WARN, msg);
    }

    @Override
    public void error(String msg) {
        filterAndLog(DebugLevel.ERROR, msg);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Appender getAppender() {
        return appender;
    }

    public void setAppender(Appender appender) {
        this.appender = appender;
    }

    public DebugLevel getLevel() {
        return level;
    }

    public void setLevel(DebugLevel level) {
        this.level = level;
    }

    public int getEffectiveLevelInt() {
        return effectiveLevelInt;
    }

    public void setEffectiveLevelInt(int effectiveLevelInt) {
        this.effectiveLevelInt = effectiveLevelInt;
    }
}
