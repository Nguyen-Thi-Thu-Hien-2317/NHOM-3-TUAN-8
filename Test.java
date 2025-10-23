import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IQuanLySach ql = new QuanLySachImpl();
        int chon;

        do {

            System.out.println("\n========== MENU QUAN LY SACH ==========");
            System.out.println("1. Nhap sach giao trinh");
            System.out.println("2. Nhap sach tieu thuyet");
            System.out.println("3. Hien thi tat ca sach");
            System.out.println("4. Kiem tra ton kho + cap nhat vi tri");
            System.out.println("5. Xoa sach theo ma");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: {
                    System.out.print("Nhap so luong sach giao trinh: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Sach giao trinh thu " + (i + 1) + " ---");
                        System.out.print("Ma sach: ");
                        String ma = sc.nextLine();
                        System.out.print("Tua de: ");
                        String td = sc.nextLine();
                        System.out.print("Tac gia: ");
                        String tg = sc.nextLine();
                        System.out.print("Nam XB: ");
                        int nam = sc.nextInt();
                        System.out.print("So luong: ");
                        int sl = sc.nextInt();
                        System.out.print("Gia co ban: ");
                        double gia = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Mon hoc: ");
                        String mh = sc.nextLine();
                        System.out.print("Cap do: ");
                        String cd = sc.nextLine();

                        ql.themSach(new SachGiaoTrinh(ma, td, tg, nam, sl, gia, mh, cd));
                    }
                    break;
                }
                case 2: {
                    System.out.print("Nhap so luong sach tieu thuyet: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Sach tieu thuyet thu " + (i + 1) + " ---");
                        System.out.print("Ma sach: ");
                        String ma = sc.nextLine();
                        System.out.print("Tua de: ");
                        String td = sc.nextLine();
                        System.out.print("Tac gia: ");
                        String tg = sc.nextLine();
                        System.out.print("Nam XB: ");
                        int nam = sc.nextInt();
                        System.out.print("So luong: ");
                        int sl = sc.nextInt();
                        System.out.print("Gia co ban: ");
                        double gia = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("The loai: ");
                        String tl = sc.nextLine();
                        System.out.print("Co phai series (true/false): ");
                        boolean sr = sc.nextBoolean();
                        sc.nextLine();

                        ql.themSach(new SachTieuThuyet(ma, td, tg, nam, sl, gia, tl, sr));
                    }
                    break;
                }
                case 3:
                    ql.hienThiTatCa();
                    break;

                case 4: {
                    System.out.print("Nhap ma sach muon kiem tra: ");
                    String ma = sc.nextLine();
                    Sach s = ql.timKiemTheoMa(ma);
                    if (s == null)
                        System.out.println(" Khong tim thay sach!");
                    else {
                        System.out.print("Nhap so luong toi thieu: ");
                        int min = sc.nextInt();
                        sc.nextLine();
                        boolean du = s.kiemTraTonKho(min);
                        System.out.println("Ton kho >= " + min + ": " + du);
                        System.out.print("Nhap vi tri moi: ");
                        String vt = sc.nextLine();
                        s.capNhatViTri(vt);
                    }
                    break;
                }
                case 5: {
                    System.out.print("Nhap ma sach can xoa: ");
                    String ma = sc.nextLine();
                    if (!ql.xoaSach(ma))
                        System.out.println(" Khong tim thay sach de xoa!");
                    break;
                }
                case 0:
                    System.out.println(" Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);

        sc.close();
    }
}
