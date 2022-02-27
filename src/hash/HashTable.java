package hash;

public class HashTable {
    private EmpLinkedList[] empLinkedListArrary;
    private int size;

    public HashTable(int size) {
        this.size = size;
        empLinkedListArrary = new EmpLinkedList[size];
        for (int i = 0; i < empLinkedListArrary.length; i++) {
            empLinkedListArrary[i] = new EmpLinkedList();
        }

    }
    public HashTable() {
        this.size = 8;
        empLinkedListArrary = new EmpLinkedList[8];
        for (int i = 0; i < empLinkedListArrary.length; i++) {
            empLinkedListArrary[i] = new EmpLinkedList();
        }
    }

    public EmpLinkedList[] getEmpLinkedListArrary() {
        return empLinkedListArrary;
    }

    public void setEmpLinkedListArrary(EmpLinkedList[] empLinkedListArrary) {
        this.empLinkedListArrary = empLinkedListArrary;
    }


    public void add(Emp emp){
        // 根据员工Id 进行散列
        int postion = hash(emp.getId());
        empLinkedListArrary[postion].addEmp(emp);

    }

    public int hash(int id ){
        return id % size;
    }
    public void list( ){
        for (EmpLinkedList empLinkedList : empLinkedListArrary) {
            empLinkedList.list();
        }

    }
}
