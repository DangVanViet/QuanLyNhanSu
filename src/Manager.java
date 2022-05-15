import java.time.LocalDate;

public class Manager extends Staff implements ICalculator {
    protected String chucDanh;
    private final static long LUONG_CO_BAN_NV_QUAN_LY = 5000000;
    private final static long LUONG_TRACH_NHIEM_BUSINESS_LEADER = 8000000;
    private final static long LUONG_TRACH_NHIEM_PROJECT_LEADER = 5000000;
    private final static long LUONG_TRACH_NHIEM_TECHNICAL_LEADER = 6000000;

    public Manager(String maNhanVien, String tenNhanVien, int tuoiNhanVien, double heSoLuong, LocalDate ngayVaoLam, Department boPhanLamViec, int soNgayNghiPhep, String chucDanh) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep);
        this.chucDanh = chucDanh;
    }
    public Manager() {}
    /**
     * Ham tinh luong cua nhan vien quan ly
     *
     *
     * @return (hesoluong * 5000000 +luongTrachNhiem) trong do luluongTrachNhiem
     * duoc tinh theo Business Leader = 8,000,000 Project Leader = 5,000,000
     * Technical Leader = 6,000,000
     *
     */
    @Override
    public double calculateSalary() {
        double luongQuanLy = getHeSoLuong() * LUONG_CO_BAN_NV_QUAN_LY;
        if(chucDanh.equals("Business Leader")) {
            luongQuanLy += LUONG_TRACH_NHIEM_BUSINESS_LEADER;
        }if(chucDanh.equals("Project Leader")) {
            luongQuanLy += LUONG_TRACH_NHIEM_PROJECT_LEADER;
        }if(chucDanh.equals("Technical Leader")) {
            luongQuanLy += LUONG_TRACH_NHIEM_TECHNICAL_LEADER;
        }
        return luongQuanLy;
    }
    /**
     * Ham hien thi thong tin cua nhan vien quan ly
     *
     * @return tra ve thong tin cua nhan vien quan ly
     */
    @Override
    public void displayInformation() {
        System.out.printf("MÃ: %s |TÊN: %s |CHỨC DANH: %s |BỘ PHẬN: %s |LƯƠNG: %f\n", getMaNhanVien(), getTenNhanVien(), chucDanh, getBoPhanLamViec().getTenBoPhan(), calculateSalary());
    }
}
