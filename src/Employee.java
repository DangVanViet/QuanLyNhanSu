import java.time.LocalDate;

public class Employee extends Staff implements ICalculator {
    private final static long LUONG_CO_BAN_NV = 3000000;
    private final static long LUONG_LAM_THEM_THEO_GIO = 200000;
    private int soGioLamThem;

//    Contructor
    public Employee() {super();}

    public Employee(String maNhanVien, String tenNhanVien, int tuoiNhanVien, double heSoLuong, LocalDate ngayVaoLam, Department boPhanLamViec, int soNgayNghiPhep, int soGioLamThem) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep);
        this.soGioLamThem = soGioLamThem;
    }

    public int getSoGioLamThem() {return soGioLamThem;}
    public void setSoGioLamThem() {this.soGioLamThem = soGioLamThem;}

    /**
     * Ham tinh luong cua nhan vien
     *
     * @return (hesoluong * 3000000 +soGioLamThem * 200000)
     */
    @Override
    public double calculateSalary() {
        return getHeSoLuong() * LUONG_CO_BAN_NV + soGioLamThem * LUONG_LAM_THEM_THEO_GIO;
    }

    /**
     * Ham hien thi thong tin cua nhan vien
     *
     * @return tra ve thong tin cua nhan vien
     */
    @Override
    public void displayInformation() {
        System.out.printf("MÃ: %s |TÊN: %s |CHỨC DANH: %s |BỘ PHẬN: %s |LƯƠNG: %f\n", getMaNhanVien(), getTenNhanVien(), "Nhan Vien", getBoPhanLamViec().getTenBoPhan(), calculateSalary());
    }
}
