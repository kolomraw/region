package domain;

public class Region {

    private Long id;
    private String name;
    private String area;
    private String adminCenter;
    private String head;

    public Region() {
    }

    public Region(String name, String area, String adminCenter, String head) {
        this.name = name;
        this.area = area;
        this.adminCenter = adminCenter;
        this.head = head;
    }

    public Region(Long id, String name, String area, String adminCenter, String head) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.adminCenter = adminCenter;
        this.head = head;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAdminCenter() {
        return adminCenter;
    }

    public void setAdminCenter(String adminCenter) {
        this.adminCenter = adminCenter;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "Region { id=" + id +
                ", name=" + name +
                ", area=" + area +
                ", adminCenter=" + adminCenter +
                ", head=" + head + " }";
    }
}