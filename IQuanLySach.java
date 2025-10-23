import java.util.List;

public interface IQuanLySach {
    void themSach(Sach s);

    Sach timKiemTheoMa(String maSach);

    boolean xoaSach(String maSach);

    void hienThiTatCa();

    List<Sach> getDanhSach();
}