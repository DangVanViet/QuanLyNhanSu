import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class HummanResources {
    // Tạo ArrayList để chứa những đối tượng được tạo ra từ Employee, Manager và Department
    public static ArrayList<Staff> danhSachNhanSu = new ArrayList<>();
    public static ArrayList<Department> danhSachBoPhan = new ArrayList<>();

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
          /*
        1. Hiển thị danh sách nhân viên (bao gồm cả quản lý) hiện có trong công ty
        2. Hiển thị các bộ phận trong công ty
        3. Hiển thi các nhân viên và quản lý theo từng bộ phận
        4. Thêm nhân viên thông thường mới vào công ty
        5. Them nhan vien là quản lý vào công ty
        6. Tìm kiếm nhân viên hoặc quản lý theo tên hoặc mã
        7. Hiển thị bảng lương công ty theo thứ tự giảm dần
        8. Hien thi bang luong công ty theo thứ tự tăng dần
        9. Thoát chương trình*/

        startBase(); // Khởi tao những giá trị đầu tiên để test chương trình

        HummanResources humanResources = new HummanResources();

        String text = "";
        do {
            humanResources.displayMainMenu();
            text = scan.nextLine();
            switch(text) {
                case "1":
                    humanResources.displayFullStaffInformation();
                    break;
                case "2":
                    humanResources.displayFullDepartmentInformation();
                    break;
                case "3":
                    humanResources.displayStaffbyDepartment();
                    break;
                case "4":
                    humanResources.addEmployee();
                    break;
                case "5":
                    humanResources.addManager();
                    break;
                case "6":
                    humanResources.searchStaff();
                    break;
                case "7":
                    humanResources.displayFullStaffDownOrderBySalary();
                    break;
                case "8":
                    humanResources.displayFullStaffUpOrderBySalary();
                    break;
                case "9":
                    System.out.println("Hẹn gặp lại");
                    break;
                default:
                    System.out.println("Lua chon khong phu hop!");
            }
        } while(!text.equals("9"));
    }

    public void displayMainMenu() {
        System.out.println("***********************== MENU ==***********************");
        System.out.println("Hãy chọn thao tác trong bảng sau");
        System.out.println("1. Hiển thị danh sách nhân viên và quản lý trong công ty");
        System.out.println("2.Hiển thị các bộ phận trong công ty");
        System.out.println("3.Hiển thị nhân viên theo từng bộ phận");
        System.out.println("4.Thêm nhân viên");
        System.out.println("5.Thêm quản lý");
        System.out.println("6.Tìm kiếm nhân viên");
        System.out.println("7.Hiển thị bảng lương theo thu tu giam dan");
        System.out.println("8.Hiển thị bảng lương the thứ tự tăng dần");
        System.out.println("9.Dừng chương trình");
    }

    public static void displayFullStaffInformation() {
        if (danhSachNhanSu != null && !danhSachNhanSu.isEmpty()) {
            System.out.println("****************== Danh sach nhan vien va quan ly trong cong ty ==************");
            for (Staff e : danhSachNhanSu) {
                e.displayInformation();
            }
            System.out.println("********************************************************");
        } else {
            System.out.println("Thông báo: Hiện chưa có nhân viên và quản lý nào!");
        }
        System.out.print("\nẤn Enter để quay lại menu ... ");
        scan.nextLine();
    }

    public static void displayFullDepartmentInformation() {
        System.out.println("\nDanh sách các bộ phận:");
        for(Department d : danhSachBoPhan) {
            System.out.println(d);
        }
        System.out.print("\nẤn Enter để quay lại menu ... ");
        scan.nextLine();
    }

    public static  void displayStaffbyDepartment() {
        System.out.println("\nDanh sách nhân viên theo từng bộ phận");
        for(Department d : danhSachBoPhan) {
            System.out.println();
            System.out.println("Danh sách nhân sự của " + d.getTenBoPhan());
            for(Staff e : danhSachNhanSu) {
                if(e.getBoPhanLamViec().getTenBoPhan().equals(d.getTenBoPhan())) {
                    e.displayInformation();
                }
            }
        }
        System.out.print("\nẤn Enter để quay lại menu ... ");
        scan.nextLine();
    }
    public static void addEmployee() {
        Scanner keyboard = new Scanner(System.in);  //Tạo biến chuyên dùng để nhập String
        Scanner Number = new Scanner(System.in);    //Tạo biến chuyên dùng để nhập số

       System.out.println("Hãy nhập lần lượt thông tin của nhân viên cần thêm vào:");
        String maNhanVien;
        while(true){                                     //Lặp cho đến khi nhập mã đúng
            System.out.print("Mã nhân viên: ");
            maNhanVien = scan.nextLine().toUpperCase();
            if(checkNhanSu(maNhanVien)) break;        // Kiểm tra xem mã Nhân Viên đã tồn tại hay chưa
            else System.out.println("Mã nhân viên này đã tồn tại!");
        }

        System.out.println("Nhập tên nhân viên: ");
        String tenNv = keyboard.nextLine().trim();
        System.out.println("Nhap tuoi:");
        int tuoi = Integer.parseInt(keyboard.nextLine().trim());
        System.out.println("Nhap he so luong:");
        double hesoluong = Double.parseDouble(keyboard.nextLine().trim());

        LocalDate ngayVaoLam;
        while (true) {
            System.out.println("Nhap ngay vao lam viec (dd/MM/yyyy):");
            String d = keyboard.nextLine();
            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                ngayVaoLam = LocalDate.parse(d,f);   // Chuyển chuỗi sang kiểu ngày tháng
                break;
            }catch (DateTimeParseException e) {              // Nếu lỗi thì yêu cầu nhập lại
                System.out.println("Hãy nhập đúng ngày tháng năm như yêu cầu");
            }
        }

        System.out.println("Nhập bộ phận làm việc: ");
        Department boPhanLamViec;
        for(int i = 0; i < danhSachBoPhan.size(); i++) {       // Lựa chọn bộ phận bằng cách chọn số
            System.out.println((i + 1) + ": " + danhSachBoPhan.get(i).getTenBoPhan());
        }
        while(true) {
            System.out.print("Chọn Phòng Số: ");
            int c = Number.nextInt();
            if(c > 0 && c <= danhSachBoPhan.size()) {
                boPhanLamViec = danhSachBoPhan.get(c - 1);
                break;
            } else {
                System.out.println("Hãy chọn lại số bộ phận (nhập số thứ tự tương ứng)");
            }
        }

        System.out.println("Nhập số ngày nghỉ phép:");
        int soNgayNghiPhep = Number.nextInt();
        System.out.println("Nhập số giờ làm thêm:");
        int soGioLamThem = Number.nextInt();

        Employee newE = new Employee(maNhanVien, tenNv, tuoi, hesoluong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep, soGioLamThem);
        danhSachNhanSu.add(newE);
        boPhanLamViec.setSoLuongNhanVien(boPhanLamViec.getSoLuongNhanVien() + 1);
        System.out.print("Đã thêm mới Nhân viên " + "\"" + tenNv + "\"" + " vào danh sách nhân viên" );

        System.out.print("\nẤn Enter để quay lại menu ... ");
        scan.nextLine();
    }

    public static void addManager() {
        Scanner keyboard = new Scanner(System.in);
        Scanner Number = new Scanner(System.in);

        System.out.println("Hãy nhập lần lượt thông tin của Quản lý cần thêm vào:");
        String maNhanVien;
        while(true){
            System.out.print("Mã quản lý: ");
            maNhanVien = keyboard.nextLine().toUpperCase();
            if(checkNhanSu(maNhanVien)) break;      // Kiểm tra xem mã quản lý có tồn tại hay chưa
            else System.out.println("Mã quản lý này đã tồn tại!");
        }

        System.out.println("Nhập tên quản lý: ");
        String tenNv = keyboard.nextLine().trim();
        System.out.println("Nhập tuổi:");
        int tuoi = Integer.parseInt(keyboard.nextLine().trim());

        int chucDanhIdx = 0;
        String chucDanh = "";
        do {
            System.out.println("Nhap chuc danh cho quan ly (1/2/3)");
            System.out.println("1 - Business Leader");
            System.out.println("2 - Project Leader");
            System.out.println("3 - Technical Leader");
            chucDanhIdx = Number.nextInt();
            switch (chucDanhIdx) {
                case 1:
                    chucDanh = "Business Leader";
                    break;
                case 2:
                    chucDanh = "Project Leader";
                    break;
                case 3:
                    chucDanh = "Technical Leader";
                    break;
                default:
                    System.out.println("Vui long chon 1, 2 hoac 3");
            }
        } while (chucDanhIdx != 1 && chucDanhIdx != 2 && chucDanhIdx != 3);     //chọn lại số cho đến khi hợp lệ

        System.out.println("Nhap he so luong:");
        double hesoluong = Double.parseDouble(keyboard.nextLine().trim());

        LocalDate ngayVaoLam;
        while (true) {
            System.out.println("Nhap ngay vao lam viec (dd/MM/yyyy):");
            String d = keyboard.nextLine();
            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                ngayVaoLam = LocalDate.parse(d,f);   // Chuyển chuỗi sang kiểu ngày tháng
                break;
            } catch (DateTimeParseException e) {             // Nhập lại nếu lỗi
                System.out.println("Vui lòng nhập đúng chuẩn ngày tháng năm như yêu cầu");
            }
        }

        System.out.println("Nhập bộ phận làm việc: ");
        Department boPhanLamViec;
        for(int i = 0; i < danhSachBoPhan.size(); i++) {
            System.out.println((i + 1) + ": " + danhSachBoPhan.get(i).getTenBoPhan());
        }
        while(true) {
            System.out.print("Chon Phong So: ");
            int c = Number.nextInt();
            if(c > 0 && c <= danhSachBoPhan.size()) {
                boPhanLamViec = danhSachBoPhan.get(c - 1);
                break;
            } else {
                System.out.println("Hãy chọn lại số bộ phận (nhập số thứ tự tương ứng)");
            }
        }

        System.out.println("Nhập số ngày nghỉ phép:");
        int soNgayNghiPhep = Number.nextInt();

        Manager newM = new Manager(maNhanVien, tenNv, tuoi, hesoluong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep,chucDanh);
        danhSachNhanSu.add(newM);
        boPhanLamViec.setSoLuongNhanVien(boPhanLamViec.getSoLuongNhanVien() + 1);
        System.out.print("Đã thêm mới Quản lý " + "\"" + tenNv + "\"" + " vào danh sách Quản lý" );

        System.out.print("\nẤn Enter để quay lại menu ... ");
        scan.nextLine();
    }
    public static void searchStaff() {
        System.out.print("Nhập tên hoặc mã Nhân Viên và quản lý cần tìm: ");
        String s = scan.nextLine().toUpperCase();
        int count = 0;
        for(Staff e : danhSachNhanSu) {
            if(s.equals(e.getMaNhanVien().toUpperCase()) || s.equals(e.getTenNhanVien().toUpperCase())) {
                e.displayInformation();
                count++;
            }
        }
        if(count == 0) {System.out.println("Không tìm thấy từ nhân sự theo yêu cầu");}

        System.out.print("\nẤn Enter để quay lại menu ... ");
        scan.nextLine();
    }

    public static void displayFullStaffDownOrderBySalary() {    // Hàm hiển thị lương giảm dần
        ArrayList<Staff> bangLuong = new ArrayList<>();     // Tạo ArrayList thêm toàn bộ nhân viên
        bangLuong.addAll(danhSachNhanSu);
//        for(int i = 0; i < bangLuong.size(); i++) {
//            System.out.print(((ICalculator) bangLuong.get(i)).calculateSalary());
//        }
        while(bangLuong.size() != 0) {      // lặp cho đến khi mảng bangLuong bị xóa đến khi không còn phần tử nào nữa
            double Max = ((ICalculator) bangLuong.get(0)).calculateSalary();   // Gán Max cho lương phần tử đầu tiên của mảng
            for(int i = 1; i < bangLuong.size(); i++) {
                if(Max < ((ICalculator) bangLuong.get(i)).calculateSalary()) {
                    Max = ((ICalculator) bangLuong.get(i)).calculateSalary(); // Tìm giá trị lương cao nhất trong mảng
                }
            }
            for(int i = 0; i < bangLuong.size(); i++) {
                if(Max == ((ICalculator) bangLuong.get(i)).calculateSalary()) {
                    bangLuong.get(i).displayInformation();          // In lần lượt giá trị lớn nhất rồi xóa nó khỏi mảng
                    bangLuong.remove(i);
                }
            }
        }
        System.out.print("\nẤn Enter để quay lại menu ... ");
        scan.nextLine();
    }

    public static void displayFullStaffUpOrderBySalary() {      // Hàm hiển thị lương tăng dần
        ArrayList<Staff> bangLuong = new ArrayList<>();
        bangLuong.addAll(danhSachNhanSu);
//        for(int i = 0; i < bangLuong.size(); i++) {
//            System.out.print(((ICalculator) bangLuong.get(i)).calculateSalary());
//        }
        while(bangLuong.size() != 0) {
           double Min = ((ICalculator) bangLuong.get(0)).calculateSalary();
           for(int i = 1; i < bangLuong.size(); i++) {
               if(Min > ((ICalculator) bangLuong.get(i)).calculateSalary()) {
                  Min = ((ICalculator) bangLuong.get(i)).calculateSalary();     // Tìm giá trị lương nhỏ nhất trong mảng
               }
           }
           for(int i = 0; i < bangLuong.size(); i++) {
               if(Min == ((ICalculator) bangLuong.get(i)).calculateSalary()) {
                   bangLuong.get(i).displayInformation();   //  Hiển thị lương nhỏ nhất và xóa phần tử đó đi
                   bangLuong.remove(i);
               }
           }
        }
        System.out.print("\nẤn Enter để quay lại menu ... ");
        scan.nextLine();
    }

    // Tạo hàm trả về kiểu dữ liệu boolean để kiểm tra Mã Nhân Viên hay Mã Quản Lý có tồn tại hay chưa
    public static boolean checkNhanSu(String maNhanVien) {
        for (Staff e : danhSachNhanSu) {
            if (maNhanVien.equals(e.getMaNhanVien().toUpperCase())) return false;
        }
        return true;
    }

    public static void startBase() {
        // Tạo 3 đối tượng phòng ban và cho nó vào "danhsachbophan"
        danhSachBoPhan.add(new Department("PKD", "Phòng Kinh Doanh", 0));
        danhSachBoPhan.add(new Department("PDA", "Phòng Dự Án", 0));
        danhSachBoPhan.add(new Department("PKT", "Phòng Kỹ Thuật", 0));

        Staff staffManager1 = new Manager();
        Manager manager1 = (Manager) staffManager1;
        manager1.chucDanh = "Business Leader";
        manager1.setMaNhanVien("M01");
        manager1.setTenNhanVien("Nguyễn Thanh Loan");
        manager1.setTuoiNhanVien(25);
        manager1.setHeSoLuong(5.9);
        Department d1 = danhSachBoPhan.get(0);
        manager1.setBoPhanLamViec(d1);
        manager1.setSoNgayNghiPhep(30);
        manager1.setNgayVaoLam(LocalDate.of(2018, 11, 19));
        danhSachNhanSu.add(manager1);
        d1.setSoLuongNhanVien(d1.getSoLuongNhanVien() + 1);

        Staff staffManager2 = new Manager();
        Manager manager2 = (Manager) staffManager2;
        manager2.chucDanh = "Project Leader";
        manager2.setMaNhanVien("M02");
        manager2.setTenNhanVien("Nguyễn Bố Hải");
        manager2.setTuoiNhanVien(65);
        manager2.setHeSoLuong(6.9);
        Department d2 = danhSachBoPhan.get(1);
        manager2.setBoPhanLamViec(d2);
        manager2.setSoNgayNghiPhep(2);
        manager2.setNgayVaoLam(LocalDate.of(1997, 10, 20));
        danhSachNhanSu.add(manager2);
        d2.setSoLuongNhanVien(d2.getSoLuongNhanVien() + 1);

        Staff staffManager3 = new Manager();
        Manager manager3 = (Manager) staffManager3;
        manager3.chucDanh = "Technical Leader";
        manager3.setMaNhanVien("M03");
        manager3.setTenNhanVien("Nguyễn Mẹ Khoa");
        manager3.setTuoiNhanVien(65);
        manager3.setHeSoLuong(6.9);
        Department d3 = danhSachBoPhan.get(2);
        manager3.setBoPhanLamViec(d3);
        manager3.setSoNgayNghiPhep(25);
        manager3.setNgayVaoLam(LocalDate.of(2013, 11, 11));
        danhSachNhanSu.add(manager3);
        d3.setSoLuongNhanVien(d3.getSoLuongNhanVien() + 1);

        Staff employee1 = new Employee();
        employee1.setMaNhanVien("E01");
        employee1.setTenNhanVien("Đặng Văn Việt");
        employee1.setTuoiNhanVien(27);
        employee1.setHeSoLuong(1.2);
        employee1.setBoPhanLamViec(d1);
        employee1.setSoNgayNghiPhep(0);
        employee1.setNgayVaoLam(LocalDate.of(2016, 3, 26));
        danhSachNhanSu.add(employee1);
        d1.setSoLuongNhanVien(d1.getSoLuongNhanVien() + 1);

        Staff employee2 = new Employee();
        employee2.setMaNhanVien("E02");
        employee2.setTenNhanVien("Trần Văn Vũ");
        employee2.setTuoiNhanVien(27);
        employee2.setHeSoLuong(1.4);
        employee2.setBoPhanLamViec(d2);
        employee2.setSoNgayNghiPhep(12);
        employee2.setNgayVaoLam(LocalDate.of(2016, 6, 22));
        danhSachNhanSu.add(employee2);
        d2.setSoLuongNhanVien(d2.getSoLuongNhanVien() + 1);

        Staff employee3 = new Employee();
        employee3.setMaNhanVien("E03");
        employee3.setTenNhanVien("Nguyễn Em Hoàng");
        employee3.setTuoiNhanVien(27);
        employee3.setHeSoLuong(2.0);
        employee3.setBoPhanLamViec(d3);
        employee3.setSoNgayNghiPhep(13);
        employee3.setNgayVaoLam(LocalDate.of(2014, 7, 3));
        danhSachNhanSu.add(employee3);
        d3.setSoLuongNhanVien(d3.getSoLuongNhanVien() + 1);
    }
}
