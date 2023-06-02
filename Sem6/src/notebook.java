public class notebook {
    public String getVendor() {
        return vendor;
    }

    public String getColor() {
        return color;
    }

    public String getOs() {
        return os;
    }

    public Integer getRam() {
        return ram;
    }

    public Integer getHardDisk() {
        return hardDisk;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public void setHardDisk(Integer hardDisk) {
        this.hardDisk = hardDisk;
    }

    private String vendor;
    private String color;
    private String os;
    private Integer ram;
    private Integer hardDisk;

    public notebook(String vendor, String color, String os, Integer ram, Integer hardDisk) {
        this.vendor = vendor;
        this.color = color;
        this.os = os;
        this.ram = ram;
        this.hardDisk = hardDisk;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "vendor='" + getVendor() + '\'' +
                ", color='" + getColor() + '\'' +
                ", os='" + getOs() + '\'' +
                ", ram=" + getRam() +
                ", storage=" + getHardDisk() +
                '}';
    }


    enum FilterCriteria {
        VENDOR,
        COLOR,
        OS,
        RAM,
        STORAGE
    }

    public boolean CheckCriteria(Map<NoteBook.FilterCriteria, Object> criteria) {
        if (criteria.containsKey(NoteBook.FilterCriteria.VENDOR) &&
                !this.getVendor().equalsIgnoreCase((String) criteria.get(NoteBook.FilterCriteria.VENDOR)))
            return false;
        if (criteria.containsKey(NoteBook.FilterCriteria.COLOR) &&
                !this.getColor().equalsIgnoreCase((String) criteria.get(NoteBook.FilterCriteria.COLOR)))
            return false;
        if (criteria.containsKey(NoteBook.FilterCriteria.OS) &&
                !this.getOs().equalsIgnoreCase((String) criteria.get(NoteBook.FilterCriteria.OS)))
            return false;
        if (criteria.containsKey(NoteBook.FilterCriteria.RAM) &&
                this.getRam() < (int) criteria.get(NoteBook.FilterCriteria.RAM))
            return false;
        return !criteria.containsKey(NoteBook.FilterCriteria.STORAGE) ||
                this.getHardDisk() >= (int) criteria.get(NoteBook.FilterCriteria.STORAGE);
    }
}
}
