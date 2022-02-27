package hash;

public class Demo {
    public static void main(String[] args) {

        HashTable hashTable = new HashTable();
        hashTable.add(new Emp(1,"syy"));
        hashTable.add(new Emp(1,"gmy"));
        hashTable.add(new Emp(1,"gyy"));
        hashTable.add(new Emp(1,"smy"));
        hashTable.list();

    }
}
