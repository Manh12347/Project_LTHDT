package bookManage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MemoryDemo {
    public static void addPredefinedBooks(bookLibrary library) {
        tieuThuyet tieuThuyet1 = new tieuThuyet("Ngày chưa giông bão.");
        tieuThuyet1.setIdSach("127842");
        tieuThuyet1.setNhaXuatBan("Kim Đồng");
        tieuThuyet1.setSoLanTaiBan(2);
        tieuThuyet1.setGiaTien(50000);
        tieuThuyet1.setNgayXuatBan(LocalDate.parse("24/06/2012", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        tieuThuyet1.setStatus(Status.NOT_LENT_YET);
        library.countBook("tieuthuyet", tieuThuyet1);

        hoiKi hoiki1 = new hoiKi("Khi thơ bé");
        hoiki1.setIdSach("123142");
        hoiki1.setNhaXuatBan("Lao Động");
        hoiki1.setSoLanTaiBan(5);
        hoiki1.setGiaTien(45000);
        hoiki1.setNgayXuatBan(LocalDate.parse("13/12/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        hoiki1.setStatus(Status.NOT_LENT_YET);
        library.countBook("hoiki", hoiki1);

        kyNangSong kynangsong1 = new kyNangSong("7 Điều cân biết.");
        kynangsong1.setIdSach("1212842");
        kynangsong1.setNhaXuatBan("Quốc Gia");
        kynangsong1.setSoLanTaiBan(2);
        kynangsong1.setGiaTien(33000);
        kynangsong1.setNgayXuatBan(LocalDate.parse("15/05/2012", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        kynangsong1.setStatus(Status.NOT_LENT_YET);
        library.countBook("kynangsong", kynangsong1);

        khoaHocvaKienThuc khoahocvakienthuc1 = new khoaHocvaKienThuc("Khoa học lượng tử");
        khoahocvakienthuc1.setIdSach("143242");
        khoahocvakienthuc1.setNhaXuatBan("Thanh Niên");
        khoahocvakienthuc1.setSoLanTaiBan(3);
        khoahocvakienthuc1.setGiaTien(534000);
        khoahocvakienthuc1.setNgayXuatBan(LocalDate.parse("01/01/2001", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        khoahocvakienthuc1.setStatus(Status.NOT_LENT_YET);
        library.countBook("khoahocvakienthuctongquat", khoahocvakienthuc1);

        sachThieuNhi sachthieunhi1 = new sachThieuNhi("Tranh chữ cho bé");
        sachthieunhi1.setIdSach("144234");
        sachthieunhi1.setNhaXuatBan("Thanh Niên");
        sachthieunhi1.setSoLanTaiBan(30);
        sachthieunhi1.setGiaTien(13200);
        sachthieunhi1.setNgayXuatBan(LocalDate.parse("10/06/2012", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        sachthieunhi1.setStatus(Status.NOT_LENT_YET);
        library.countBook("sachthieunhi", sachthieunhi1);

        sachKhac sachkhac1 = new sachKhac("Trạng Quỷnh", "Truyện Hài");
        sachkhac1.setIdSach("124212");
        sachkhac1.setNhaXuatBan("Kim Đồng");
        sachkhac1.setSoLanTaiBan(15);
        sachkhac1.setGiaTien(17000);
        sachkhac1.setNgayXuatBan(LocalDate.parse("04/02/2007", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        sachkhac1.setStatus(Status.NOT_LENT_YET);
        library.countBook("sachkhac", sachkhac1);
    }
}
