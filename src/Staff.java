import java.time.LocalDate;

public abstract class Staff {
    private String maNhanVien;
    private String tenNhanVien;
    private int tuoiNhanVien;
    private double heSoLuong;
    private LocalDate ngayVaoLam;
    protected Department boPhanLamViec;
    private int soNgayNghiPhep;

    /*
   Phuong thuc khoi tao khong tham so
    */
    public Staff() {}

    /**
     * Phuong thuc khoi tao co tham so
     * @param maNhanVien
     * @param tenNhanVien
     * @param tuoiNhanVien
     * @param heSoLuong
     * @param ngayVaoLam
     * @param boPhanLamViec
     * @param soNgayNghiPhep
     */
    public Staff(String maNhanVien, String tenNhanVien, int tuoiNhanVien, double heSoLuong, LocalDate ngayVaoLam, Department boPhanLamViec, int soNgayNghiPhep) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tuoiNhanVien = tuoiNhanVien;
        this.heSoLuong = heSoLuong;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhanLamViec = boPhanLamViec;
        this.soNgayNghiPhep = soNgayNghiPhep;
    }

    public String getMaNhanVien() {return maNhanVien;}
    public void setMaNhanVien(String maNhanVien) {this.maNhanVien = maNhanVien;}
    public String getTenNhanVien() {return tenNhanVien;}
    public void setTenNhanVien(String tenNhanVien) {this.tenNhanVien = tenNhanVien;}
    public int getTuoiNhanVien() {return tuoiNhanVien;}
    public void setTuoiNhanVien(int tuoiNhanVien) {this.tuoiNhanVien = tuoiNhanVien;}
    public double getHeSoLuong() {return heSoLuong;}
    public void setHeSoLuong(double heSoLuong) {this.heSoLuong = heSoLuong;}
    public LocalDate getNgayVaoLam() {return ngayVaoLam;}
    public void setNgayVaoLam(LocalDate of) {this.ngayVaoLam = ngayVaoLam;}
    public Department getBoPhanLamViec() {return boPhanLamViec;}
    public void setBoPhanLamViec(Department boPhanLamViec) {this.boPhanLamViec = boPhanLamViec;}
    public int getSoNgayNghiPhep() {return soNgayNghiPhep;}
    public void setSoNgayNghiPhep(int soNgayNghiPhep) {this.soNgayNghiPhep = soNgayNghiPhep;}

    public abstract void displayInformation();
}

