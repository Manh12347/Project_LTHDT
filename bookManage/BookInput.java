package bookManage;

import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BookInput {
    protected Status status;
    protected String idSach;
    protected String nhaXuatBan;
    protected int soLanTaiBan;
    protected long giaTien;
    protected LocalDate ngayXuatBan;
    protected Scanner sc;

    public BookInput(String idSach, String nhaXuatBan, int soLanTaiBan, long giaTien, String ngayXuatBan, Status status, Scanner scanner) {
        this.status = status;
        this.idSach = idSach;
        this.nhaXuatBan = nhaXuatBan;
        this.soLanTaiBan = soLanTaiBan;
        this.giaTien = giaTien;
        this.ngayXuatBan = LocalDate.parse(ngayXuatBan, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.sc = scanner;
    }

    public BookInput() {
        status = Status.NOT_LENT_YET;
        this.idSach = "";
        this.nhaXuatBan = "";
        this.soLanTaiBan = 0;
        this.giaTien = 0;
        this.ngayXuatBan = LocalDate.parse("14/12/2005", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.sc = new Scanner(System.in);
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getSoLanTaiBan() {
        return soLanTaiBan;
    }

    public void setSoLanTaiBan(int soLanTaiBan) {
        this.soLanTaiBan = soLanTaiBan;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(long giaTien) {
        this.giaTien = giaTien;
    }

    public LocalDate getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(LocalDate ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public void input() {
        System.out.println("Nhập id sách: ");
        idSach = sc.nextLine();
        System.out.println("Chọn nhà xuất bản.");
        System.out.println("1. Kim Đồng");
        System.out.println("2. Lao Động");
        System.out.println("3. Quốc Gia");
        System.out.println("4. Thanh Niên");
        System.out.println("5. Khác");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                nhaXuatBan = "Kim Đồng";
                break;
            case 2:
                nhaXuatBan = "Lao Động";
                break;
            case 3:
                nhaXuatBan = "Quốc Gia";
                break;
            case 4:
                nhaXuatBan = "Thanh Niên";
                break;
            default:
                System.out.println("Nhà xuất bản khác. Vui lòng nhập tên: ");
                nhaXuatBan = sc.nextLine();
                break;
        }
        System.out.println("Nhập số lần tái bản: ");
        soLanTaiBan = sc.nextInt();
        System.out.println("Nhập giá tiền: ");
        giaTien = sc.nextLong();
        sc.nextLine();
        do {
            System.out.println("Nhập ngày xuất bản(dd/MM/yyyy): ");
            String ngayNhap = sc.nextLine();
            try {
                ngayXuatBan = LocalDate.parse(ngayNhap, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (DateTimeException e) {
                System.out.println("Ngày không hợp lệ vui lòng nhập lại (dd/MM/yyyy)");
            }
        } while (true);
        System.out.println("Nhập trạng thái của sách.");
        System.out.println("1. Loanted. ");
        System.out.println("2. Sold.");
        System.out.println("3. Not lent yet.");
        int choices = sc.nextInt();
        sc.nextLine();
            switch (choices) {
                case 1:
                    status = Status.LOANTED;                
                    break;
                case 2:
                    status = Status.SOLD;
                    break;
                default:
                    status = Status.NOT_LENT_YET;
                    break;
            }
    }

    public void output() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Mã số sách là: " + getIdSach());
        System.out.println("Tên nhà xuất bản: " + getNhaXuatBan());
        System.out.println("Số lần tái bản: " + getSoLanTaiBan());
        System.out.println("Giá tiền: " + formatGiaTien(getGiaTien()) + " vnd");
        System.out.println("Ngày xuất bản: " + getNgayXuatBan().format(dateTimeFormatter));
        System.out.println("Trạng thái: " + getStatus());
    }

    public String formatGiaTien(double giaTien) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
        return decimalFormat.format(giaTien);
    }

    @Override
    public String toString() {
        return "BookInput [status=" + status + ", idSach=" + idSach + ", nhaXuatBan=" + nhaXuatBan + ", soLanTaiBan="
                + soLanTaiBan + ", giaTien=" + giaTien + ", ngayXuatBan=" + ngayXuatBan + ", sc=" + sc + "]";
    }

   
}

class tieuThuyet extends BookInput {
    protected String tieuDe;

    public tieuThuyet(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    public tieuThuyet() {
        this.tieuDe = "";
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    @Override
    public void input() {
        System.out.println("Nhập tiêu đề sách: ");
        tieuDe = sc.nextLine();
        super.input();

    }
    @Override
    public void output() {
        super.output();
        System.out.println("Thể loại tiểu thuyết.");
        System.out.println("Tiêu đề: " + getTieuDe());
    }
}
class hoiKi extends BookInput {
    protected String tieuDe;

    public hoiKi(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    public hoiKi() {
        this.tieuDe = "";
    }
    

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    @Override
    public void input() {
        System.out.println("Nhập tiêu đề sách");
        tieuDe = sc.nextLine();
        super.input();
    }
    @Override
    public void output() {
        super.output();
        System.out.println("Thể loại Hồi kí.");
        System.out.println("Tiêu đề: " + getTieuDe());
    }
}
class kyNangSong extends BookInput {
    protected String tieuDe;

    public kyNangSong(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    public kyNangSong() {
        this.tieuDe = "";
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    @Override
    public void input() {
        System.out.println("Nhập tiêu đề sách: ");
        tieuDe = sc.nextLine();
        super.input();
    }
    @Override
    public void output() {
        super.output();
        System.out.println("Thể loại Kỹ năng sống.");
        System.out.println("Tiêu đề: " + getTieuDe());
    }
}
class khoaHocvaKienThuc extends BookInput {
    protected String tieuDe;

    public khoaHocvaKienThuc(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    public khoaHocvaKienThuc() {
        this.tieuDe = "";
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    @Override
    public void input() {
        System.out.println("Nhập tiêu đề sách: ");
        tieuDe = sc.nextLine();
        super.input();
    }
    @Override
    public void output() {
        System.out.println("Thể loại Khoa học và Kiến thức.");
        System.out.println("Tiêu đề: " + getTieuDe());
    }
}
class sachThieuNhi extends BookInput{
    protected String tieuDe;

    public sachThieuNhi(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    public sachThieuNhi() {
        this.tieuDe = "";
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    @Override
    public void input() {
        System.out.println("Nhập tiêu đề sách: ");
        tieuDe = sc.nextLine();
        super.input();
        
    }
    @Override
    public void output() {
        super.output();
        System.out.println("Thể loại sách thiếu nhi.");
        System.out.println("Tiêu đề: " + getTieuDe());
    }
}
class sachKhac extends  BookInput {
    protected String tieuDe;
    private String theLoai;

    public sachKhac(String tieuDe,String theLoai) {
        this.tieuDe = tieuDe;
        this.theLoai = theLoai;
    }
    public sachKhac() {
        this.tieuDe = "";
        this.theLoai = "";
    }
    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    @Override
    public void input() {
        System.out.println("Nhập thể loại sách: ");
        theLoai = sc.nextLine();
        System.out.println("Nhập tiêu đề sách: ");
        tieuDe = sc.nextLine();  
        super.input();     
    }
    @Override
    public void output() {
        super.output();
        System.out.println("Thể loại " + getTheLoai() + ".");
        System.out.println("Tiêu đề: " + getTieuDe());
    }
}

