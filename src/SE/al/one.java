package SE.al;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gmydl
 * @title: one
 * @projectName DataStructure
 * @description: TODO
 * @date 2022/7/5 15:37
 */
public class one {

    public static void main(String[] args) {
        List<Part> result = basicA();

        System.out.println(result);

    }

    public static List<Part> basicA() {

        // 创建对象
        List<Part> parts = new ArrayList<>();
        // 添加数据
        parts.add(new Part(1001, "D", null, null));
        parts.add(new Part(1001, "M", "P", "001"));
        parts.add(new Part(1001, "M", "P", "002"));
        parts.add(new Part(1002, "D", null, null));
        parts.add(new Part(1002, "M", "P", "002"));
        parts.add(new Part(1002, "M", "P", "003"));

        List<Part> response = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        String input = null;
        // 判断是否还有输入
        if (scan.hasNextLine()) {
            input = scan.nextLine();
            System.out.println("输入的数据为：" + input);
        }
        scan.close();


        // 输入分割
        String[] split = input.split(",");
        // 视图
        String view = split[0].substring(1);
        System.out.println(view);
        String type = split[1];
        // 分支
        String branch = split[split.length - 1].substring(0, split[split.length - 1].length() - 1);
        System.out.println(branch);
        AtomicInteger count1 = new AtomicInteger();
        AtomicInteger count2 = new AtomicInteger();

        for (int i = 0; i < parts.size(); i++) {

            Part flag ;
            for (Part part : parts) {
                //  先比较视图
                if (part.getId() == 1001 && Objects.equals(part.getView(), view)){
                    // 比较分支 也相同
                    if (part.getBranch().equals(branch) && count1.get() < 2) {
                        count1.addAndGet(1);
                        response.add(part);
                    }
                }
            }
        }


        parts.forEach(item ->{
             //  先比较视图
            if (item.getId() == 1001 && Objects.equals(item.getView(), view)){
                // 比较分支 也相同
                if (item.getBranch().equals(branch) && count1.get() < 2) {
                    count1.addAndGet(1);
                    response.add(item);
                }
            } else if (item.getId() == 1002 && Objects.equals(item.getView(), view)){
                // 比较分支 也相同
                if (item.getBranch().equals(branch) && count2.get() < 2) {
                    count2.addAndGet(1);
                    response.add(item);
                }
            } else if (item.getId() != 1001){
                if (item.getView().equals("D") && count2.get() < 2){
                    count2.addAndGet(1);
                    response.add(item);
                }
            }
        });







        return response;
    }
}
