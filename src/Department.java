public class Department {
    private String maBoPhan;
    private String tenBoPhan;
    private int soLuongNhanVien;

    public Department() {}

    public Department(String maBoPhan, String tenBoPhan, int soLuongNhanVien) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.soLuongNhanVien = soLuongNhanVien;
    }
    public String getMaBoPhan() {return maBoPhan;}
    public void setMaBoPhan(String maBoPhan) {this.maBoPhan = maBoPhan;}
    public String getTenBoPhan() {return tenBoPhan;}
    public void setTenBoPhan(String tenBoPhan) {this.tenBoPhan = tenBoPhan;}
    public int getSoLuongNhanVien() {return soLuongNhanVien;}
    public void setSoLuongNhanVien(int soLuongNhanVien) {this.soLuongNhanVien = soLuongNhanVien;}

    public String toString() {
        return "Mã bộ phận: [" + maBoPhan + "] Tên bộ phận: [" + tenBoPhan + "] Số lượng nhân viên: [" + soLuongNhanVien + "]";
    }
}
