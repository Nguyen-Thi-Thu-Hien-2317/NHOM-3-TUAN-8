import java.util.ArrayList;

public class QuanLySachImpl implements IQuanLySach {
    private ArrayList<Sach> danhSach = new ArrayList<>();

    @Override
    public void themSach(Sach s) {
        danhSach.add(s);
        System.out.println("Da them sach: " + s.getTieuDe());
    }

    @Override
    public Sach timKiemSach(String maSach) {
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean xoaSach(String maSach) {
        Sach s = timKiemSach(maSach);
        if (s != null) {
            danhSach.remove(s);
            System.out.println("Da xoa sach co ma: " + maSach);
            return true;
        }
        return false;
    }

    @Override
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach sach rong.");
            return;
        }
        System.out.println("\n===== DANH SACH TAT CA SACH =====");
        for (Sach s : danhSach) {
            System.out.println(s);
        }
    }
    
    @Override
    public void baoCaoTonKho(int soLuongToiThieu) {
        System.out.println("\n===== BAO CAO TON KHO TOI THIEU (" + soLuongToiThieu + " CUON) =====");
        for (Sach s : danhSach) {
            if (s.kiemTraTonKho(soLuongToiThieu)) {
                System.out.println("TON KHO DAT: " + s.getTieuDe() + " (" + s.getSoLuong() + " cuon)");
            } else {
                System.out.println("TON KHO THAP: " + s.getTieuDe() + " (Chi co " + s.getSoLuong() + " cuon)");
            }
        }
    }
}