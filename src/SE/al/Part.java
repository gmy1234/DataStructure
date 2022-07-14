package SE.al;

/**
 * @author gmydl
 * @title: Part
 * @projectName DataStructure
 * @description: 内部对象
 * @date 2022/7/6 10:50
 */
public class Part {

    private int id;

    private String view;

    private String type;

    private String branch;

    public Part() {
    }

    public Part(int id, String view, String type, String branch) {
        this.id = id;
        this.view = view;
        this.type = type;
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getType() {
        return type;
    }



    public void setType(String type) {
        this.type = type;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", view='" + view + '\'' +
                ", type='" + type + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
