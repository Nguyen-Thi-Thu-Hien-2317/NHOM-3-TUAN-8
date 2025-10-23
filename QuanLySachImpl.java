import java.util.ArrayList;
import java.util.List;

public class QuanLySachImpl implements IQuanLySach {
    private List<Sach> danhSach = new ArrayList<>();

    @Override
    public void themSach(Sach s) {
        danhSach.add(s);
        System.out.println("Da them sach: " + s.getTieuDe());
    }

    @Override
    public Sach timKiemTheoMa(String maSach) {
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean xoaSach(String maSach) {
        Sach s = timKiemTheoMa(maSach);
        if (s != null) {
            danhSach.remove(s);
            System.out.println("Da xoa sach: " + s.getTieuDe());
            return true;
        }
        return false;
    }

    @Override
    public void hienThiTatCa() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach trong!");
        } else {
            System.out.println("===== DANH SACH SACH =====");
            for (Sach s : danhSach) {
                System.out.println(s);
            }
        }
    }

    @Override
    public List<Sach> getDanhSach() {
        return danhSach;
    }
}
