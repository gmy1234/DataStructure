package hash;

public class EmpLinkedList {
    // 头指针，执行第一个Emp，
    private Emp head;

    // 添加Empty
    public void addEmp(Emp emp){
        if (head == null) {
            head = emp;
        }else {
            Emp curEmp = head;
            while (curEmp.getEmpNext() != null) {
                // 链表到最后了
                curEmp = curEmp.getEmpNext();
            }
            curEmp.setEmpNext(emp);
        }
    }

    public void list(){
        if (head == null) {
            System.out.println("该链表为空");
            return ;
        }
        Emp curEmp = head;
        // 输出
        System.out.println(curEmp);
        while (curEmp.getEmpNext() != null) {
            curEmp = curEmp.getEmpNext();
        }
    }
}
