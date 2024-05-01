package bookManage;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class bookLibrary {
    private Map<String, ArrayList<BookInput>> bookInventory;
    private final Scanner sc;

    public bookLibrary() {
        bookInventory = new HashMap<>();
        bookInventory.put("tieuthuyet", new ArrayList<>());
        bookInventory.put("hoiki", new ArrayList<>());
        bookInventory.put("kynangsong", new ArrayList<>());
        bookInventory.put("khoahocvakienthuctongquat", new ArrayList<>());
        bookInventory.put("sachthieunhi", new ArrayList<>());
        bookInventory.put("sachkhac", new ArrayList<>());
        sc = new Scanner(System.in);

        MemoryDemo.addPredefinedBooks(this);
    }

    public void countBook(String bookType, BookInput book) {
        ArrayList<BookInput> books = bookInventory.get(bookType);
        books.add(book);
        bookInventory.put(bookType, books);
    }

    public void findBookCount() {
        String bookType;
        System.out.println("Vui lòng chọn loại sách cần tìm. ");
        System.out.println("1, Tiểu thuyết.");
        System.out.println("2, Hồi kí.");
        System.out.println("3, Kỹ năng sống.");
        System.out.println("4, Khoa học và kiến thức tổng quát.");
        System.out.println("5, Sách thiếu nhi.");
        System.out.println("6, Sách khác.");
        int choice = sc.nextInt();
        sc.nextLine();
        int count = 0;
        switch (choice) {
            case 1:
                bookType = "tieuthuyet";
                count = bookInventory.getOrDefault(bookType, new ArrayList<>()).size();
                System.out.println("Số lượng sách loại tiểu thuyết: " + count);
                break;
            case 2:
                bookType = "hoiki";
                count = bookInventory.getOrDefault(bookType, new ArrayList<>()).size();
                System.out.println("Số lượng sách loại hồi kí: " + count);
                break;
            case 3:
                bookType = "kynangsong";
                count = bookInventory.getOrDefault(bookType, new ArrayList<>()).size();
                System.out.println("Số lượng sách loại kỹ năng sống: " + count);
                break;
            case 4:
                bookType = "khoahocvakienthuctongquat";
                count = bookInventory.getOrDefault(bookType, new ArrayList<>()).size();
                System.out.println("Số lượng sách loại khoa học và kiến thức tổng quát: " + count);
                break;
            case 5:
                bookType = "sachthieunhi";
                count = bookInventory.getOrDefault(bookType, new ArrayList<>()).size();
                System.out.println("Số lượng sách loại sách thiếu nhi: " + count);
                break;
            default:
                bookType = "sachkhac";
                count = bookInventory.getOrDefault(bookType, new ArrayList<>()).size();
                System.out.println("Số lượng sách khác: " + count);
                break;
        }
        int stt = 1;
        if (count > 0) {
            System.out.println("Thông tin loại sách này.");
            System.out.println("+-----+--------------------------+-----------------------+------------------+---------+--------------+------------+-------------+---------------+---------------------+");
            System.out.println("| STT |          Tên             |     Thể loại          |   Nhà xuất bản   | Tái bản |  Mã số sách  | Giá tiền   |  Trạng thái | Ngày xuất bản |    Thời gian nhập   |");
            System.out.println("+-----+--------------------------+-----------------------+------------------+---------+--------------+------------+-------------+---------------+---------------------+");
            ArrayList<BookInput> books = bookInventory.getOrDefault(bookType, new ArrayList<>());
            for (BookInput book : books) {
                String tieuDe = "";
                if (book instanceof tieuThuyet) {
                    tieuDe = ((tieuThuyet) book).getTieuDe();
                } else if (book instanceof hoiKi) {
                    tieuDe = ((hoiKi) book).getTieuDe();
                } else if (book instanceof kyNangSong) {
                    tieuDe = ((kyNangSong) book).getTieuDe();
                } else if (book instanceof khoaHocvaKienThuc) {
                    tieuDe = ((khoaHocvaKienThuc) book).getTieuDe();
                } else if (book instanceof sachThieuNhi) {
                    tieuDe = ((sachThieuNhi) book).getTieuDe();
                } else if (book instanceof sachKhac) {
                    tieuDe = ((sachKhac) book).getTieuDe();
                }
                System.out.printf("| %-4d| %-25s| %-22s| %-17s| %-8d| %-13s| %-11s| %-12s| %-14s| %-16s |%n",
                stt++, tieuDe, getTypeName(bookType), book.getNhaXuatBan(), book.getSoLanTaiBan(),
                book.getIdSach(), formatGiaTien(book.getGiaTien())+ "đ",
                book.getStatus(), book.getNgayXuatBan().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),book.getGioHienTai().format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")));
            }
            System.out.println("+-----+--------------------------+-----------------------+------------------+---------+--------------+------------+-------------+---------------+---------------------+");

        } else {
            System.out.println("Không có loại sách này.");
        }
    }

    public void findAllBookCounts() {
        System.out.println("Số lượng sách mỗi loại:");
        for (String type : bookInventory.keySet()) {
            int count = bookInventory.get(type).size();
            System.out.println("Số lượng sách loại " + getTypeName(type) + " là: " + count);
        }

        System.out.println("Thông tin cho các cuốn sách:");
        System.out.println("+-----+--------------------------+-----------------------+------------------+---------+--------------+------------+-------------+---------------+---------------------+");
        System.out.println("| STT |          Tên             |     Thể loại          |   Nhà xuất bản   | Tái bản |  Mã số sách  | Giá tiền   |  Trạng thái | Ngày xuất bản |    Thời gian nhập   |");
        System.out.println("+-----+--------------------------+-----------------------+------------------+---------+--------------+------------+-------------+---------------+---------------------+");

        int stt = 1;
        for (String type : bookInventory.keySet()) {
            ArrayList<BookInput> books = bookInventory.getOrDefault(type, new ArrayList<>());
            for (BookInput book : books) {
                String tieuDe = "";
                if (book instanceof tieuThuyet) {
                    tieuDe = ((tieuThuyet) book).getTieuDe();
                } else if (book instanceof hoiKi) {
                    tieuDe = ((hoiKi) book).getTieuDe();
                } else if (book instanceof kyNangSong) {
                    tieuDe = ((kyNangSong) book).getTieuDe();
                } else if (book instanceof khoaHocvaKienThuc) {
                    tieuDe = ((khoaHocvaKienThuc) book).getTieuDe();
                } else if (book instanceof sachThieuNhi) {
                    tieuDe = ((sachThieuNhi) book).getTieuDe();
                } else if (book instanceof sachKhac) {
                    tieuDe = ((sachKhac) book).getTieuDe();
                }

                System.out.printf("| %-4d| %-25s| %-22s| %-17s| %-8d| %-13s| %-11s| %-12s| %-14s| %-16s |%n",
                        stt++, tieuDe, getTypeName(type), book.getNhaXuatBan(), book.getSoLanTaiBan(),
                        book.getIdSach(), formatGiaTien(book.getGiaTien())+ "đ",
                        book.getStatus(), book.getNgayXuatBan().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),book.getGioHienTai().format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")));
            }
        }
        System.out.println("+-----+--------------------------+-----------------------+------------------+---------+--------------+------------+-------------+---------------+---------------------+");
    }

    private String getTypeName(String type) {
        switch (type) {
            case "tieuthuyet":
                return "Tiểu thuyết";
            case "hoiki":
                return "Hồi kí";
            case "kynangsong":
                return "Kỹ năng sống";
            case "khoahocvakienthuctongquat":
                return "Khoa học ";
            case "sachthieunhi":
                return "Sách thiếu nhi";
            default:
                return "Sách khác";
        }
    }

    private String formatGiaTien(double giaTien) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
        return decimalFormat.format(giaTien);
    }

    public void addBook() {
        int choice;
        do {
            System.out.println("Vui lòng chọn loại sách cần thêm.");
            System.out.println("1. Tiểu thuyết.");
            System.out.println("2. Hồi kí.");
            System.out.println("3. Kỹ năng sống.");
            System.out.println("4. Khoa học và kiến thức tổng quát.");
            System.out.println("5. Sách thiếu nhi.");
            System.out.println("6. Sách khác.");
            System.out.println("7. Thoát khỏi chương trình.");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    tieuThuyet tieuthuyet = new tieuThuyet();
                    tieuthuyet.input();
                    countBook("tieuthuyet", tieuthuyet);
                    tieuthuyet.output();
                    break;
                case 2:
                    hoiKi hoiki = new hoiKi();
                    hoiki.input();
                    countBook("hoiki", hoiki);
                    hoiki.output();
                    break;
                case 3:
                    kyNangSong kynangsong = new kyNangSong();
                    kynangsong.input();
                    countBook("kynangsong", kynangsong);
                    kynangsong.output();
                    break;
                case 4:
                    khoaHocvaKienThuc khoahocvakienthuc = new khoaHocvaKienThuc();
                    khoahocvakienthuc.input();
                    countBook("khoahocvakienthuctongquat", khoahocvakienthuc);
                    khoahocvakienthuc.output();
                    break;
                case 5:
                    sachThieuNhi sachthieunhi = new sachThieuNhi();
                    sachthieunhi.input();
                    countBook("sachthieunhi", sachthieunhi);
                    sachthieunhi.output();
                    break;
                case 6:
                    sachKhac sachkhac = new sachKhac();
                    sachkhac.input();
                    countBook("sachkhac", sachkhac);
                    sachkhac.output();
                    break;
                case 7:
                    break;
            }
        } while (choice != 7);
    }

    public void performAction() {
        String choice;
        do {
            System.out.println("Vui lòng lựa chọn hoạt động.");
            System.out.println("0, Thoát khỏi chương trình.");
            System.out.println("1, Thêm sách.");
            System.out.println("2, Tìm sách.");
            System.out.println("    2.1, Tìm sách theo từng loại.");
            System.out.println("    2.2, Tìm tất cả nhà sách.");
            System.out.println("    2.3, Tìm sách theo tên tác giả.");
            System.out.println("    2.4, Tìm sách theo id.");
            choice = sc.nextLine();
            switch (choice) {
                case "0":
                    break;
                case "1":
                    addBook();
                    break;
                case "2.1":
                    findBookCount();
                    break;
                case "2.2":
                    findAllBookCounts();
                    break;
                default:
                    System.out.println("Không có hoạt động khớp với lệnh nhập. Nhập lại.");
                    choice = sc.nextLine();
                    break;
            }
        } while (!choice.equals("0"));
    }
}
