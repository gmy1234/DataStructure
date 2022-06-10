package log;

/**
 * @author gmydl
 * @title: Test
 * @projectName DataStructure
 * @description: TODO
 * @date 2022/6/10 21:48
 */
public class Test {
    public static void main(String[] args) {
        LogcLogger log= new LogcLogger();
        log.setAppender(new FileAppender());
        try
        {
            int a = 3;
            int b = 0;
            int c = a / b;
        }
        catch (Exception ex) {
            log.error(ex.getMessage());
        }

    }
}
