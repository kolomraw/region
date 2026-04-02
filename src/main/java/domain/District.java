package domain;

public class District {

    private Long id;
    private String name;
    private String area;
    private String adminCenter;
    private String head;

    private Long regionId;
    private Region region;

    public District() {
    }

    public District(String name, String area, String adminCenter, String head, Long regionId) {
        this.name = name;
        this.area = area;
        this.adminCenter = adminCenter;
        this.head = head;
        this.regionId = regionId;
    }

    public District(Long id, String name, String area, String adminCenter, String head, Long regionId) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.adminCenter = adminCenter;
        this.head = head;
        this.regionId = regionId;
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

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "District { id=" + id +
                ", name=" + name +
                ", area=" + area +
                ", adminCenter=" + adminCenter +
                ", head=" + head + " }";
    }
}