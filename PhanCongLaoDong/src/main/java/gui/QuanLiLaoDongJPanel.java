package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import dao.DiaDiem_DAO;
import dao.QuanLyLaoDong_DAO;
import dao.TrinhDo_DAO;
import entity.DiaDiem;
import entity.LaoDong;
import entity.TrinhDo;

import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class QuanLiLaoDongJPanel extends JPanel implements ActionListener, MouseListener, ItemListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTenLD;
	private JTextField txtSdt;
	private JComboBox<String> cboTrinhDo;
	private JTextField txtCMND;
	private DefaultTableModel modelLaoDong;
	private JTable tableLaoDong;
	private JComboBox<String> cboGioiTinh;
	private JLabel lblPage;
	private JTextField txtMatKhau;
	private JComboBox<String> cboQuanHuyen;
	private JComboBox<String> cboPhuongXa;
	private JComboBox<String> cboTinhTP;
	private ArrayList<String> listTinh = new DiaDiem_DAO().getTinh();
	private QuanLyLaoDong_DAO lDao = new QuanLyLaoDong_DAO();
	private ArrayList<LaoDong> listLaoDong;
	private JTextField txtTimMa;
	private JTextField txtTimTenLD;
	private JDateChooser ngaySinh;
	private int soDau = 1;
	private int soCuoi = 11;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JTextField txtTaiKhoan;
	private JLabel lblTinhTong;

	/**
	 * Create the panel.
	 */
	public QuanLiLaoDongJPanel() {

		setBackground(new Color(250, 250, 250));

		JLabel lblHoTenNV = new JLabel("Họ tên:");
		lblHoTenNV.setBounds(844, 35, 106, 30);
		lblHoTenNV.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JLabel lblSdt = new JLabel("Số điện thoại :");
		lblSdt.setBounds(844, 154, 106, 30);
		lblSdt.setFont(new Font("Times New Roman", Font.BOLD, 14));

		cboTinhTP = new JComboBox<String>();
		cboTinhTP.setBounds(844, 363, 153, 22);
		cboTinhTP.addItem("Tỉnh/Thành phố");
		for (String t : listTinh) {
			cboTinhTP.addItem(t);
		}

		cboQuanHuyen = new JComboBox<String>();
		cboQuanHuyen.setBounds(1007, 363, 151, 22);
		cboQuanHuyen.addItem("Quận/Huyện");

		cboPhuongXa = new JComboBox<String>();
		cboPhuongXa.setBounds(1168, 363, 136, 22);
		cboPhuongXa.addItem("Phường/xã");

		txtTenLD = new JTextField();
		txtTenLD.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenLD.setBounds(956, 35, 348, 22);
		txtTenLD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenLD.setColumns(10);


		
		txtSdt = new JTextField();
		txtSdt.setHorizontalAlignment(SwingConstants.CENTER);
		txtSdt.setBounds(956, 157, 121, 22);
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSdt.setColumns(10);
		
		JLabel lblTaikhoan = new JLabel("Tài khoản:");
		lblTaikhoan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTaikhoan.setBounds(844, 283, 116, 30);
		add(lblTaikhoan);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setEditable(false);
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(956, 284, 136, 22);
		add(txtTaiKhoan);

		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setBounds(1115, 281, 85, 30);
		lblMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtMatKhau = new JTextField();
		txtMatKhau.setBounds(1200, 284, 106, 22);
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMatKhau.setColumns(10);
		

		JLabel lblNgaySinh = new JLabel("Ngày sinh :");
		lblNgaySinh.setBounds(1116, 154, 84, 30);
		lblNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 14));

		cboTrinhDo = new JComboBox<String>();
		cboTrinhDo.setBounds(1198, 224, 106, 22);

		cboTrinhDo.setFont(new Font("Tahoma", Font.PLAIN, 15));

		ArrayList<TrinhDo> trinhDo = new TrinhDo_DAO().getTrinhDo();
		for (TrinhDo t : trinhDo) {
			cboTrinhDo.addItem(t.getTenTrinhDo());
		}

		JLabel lblNewLabel = new JLabel("Trình độ");
		lblNewLabel.setBounds(1116, 221, 116, 30);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JLabel lblNewLabel_2 = new JLabel("Số CMND:");
		lblNewLabel_2.setBounds(844, 95, 140, 30);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtCMND = new JTextField();
		txtCMND.setHorizontalAlignment(SwingConstants.CENTER);
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCMND.setBounds(956, 97, 348, 22);
		txtCMND.setColumns(10);

		String[] colHeader = { "Mã lao động", "Họ tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Số CMND", "Địa chỉ",
				"Trình độ" };
		modelLaoDong = new DefaultTableModel(colHeader, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		tableLaoDong = new JTable(modelLaoDong);
		tableLaoDong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JScrollPane scrollPane = new JScrollPane(tableLaoDong);
		scrollPane.setBounds(33, 78, 801, 423);

		JTableHeader h = tableLaoDong.getTableHeader();
		h.setForeground(new Color(255, 255, 255));
		h.setFont(new Font("Arial", Font.BOLD, 13));
		h.setBackground(new Color(146, 200, 240));

		tableLaoDong.setRowHeight(tableLaoDong.getRowHeight() + 20);

		tableLaoDong.getColumnModel().getColumn(0).setPreferredWidth(35);
		tableLaoDong.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableLaoDong.getColumnModel().getColumn(2).setPreferredWidth(20);
		tableLaoDong.getColumnModel().getColumn(3).setPreferredWidth(10);
		tableLaoDong.getColumnModel().getColumn(4).setPreferredWidth(55);
		tableLaoDong.getColumnModel().getColumn(5).setPreferredWidth(40);
		tableLaoDong.getColumnModel().getColumn(6).setPreferredWidth(50);
		tableLaoDong.getColumnModel().getColumn(7).setPreferredWidth(40);

		JLabel lblNewLabel_3 = new JLabel("Giới tính:");
		lblNewLabel_3.setBounds(844, 223, 106, 30);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));

		cboGioiTinh = new JComboBox<String>();
		cboGioiTinh.setBounds(957, 224, 121, 22);
		cboGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboGioiTinh.addItem("Nam");
		cboGioiTinh.addItem("Nữ");
		cboGioiTinh.setEditable(false);

		JButton btnTurnTop = new JButton("");
		btnTurnTop.setBounds(323, 520, 40, 25);
		btnTurnTop.setFocusPainted(false);
		btnTurnTop.setIcon(
				new ImageIcon(QuanLiLaoDongJPanel.class.getResource("/images/baseline_skip_previous_white_24dp.png")));
		btnTurnTop.setForeground(Color.DARK_GRAY);
		btnTurnTop.setBackground(Color.DARK_GRAY);

		JButton btnTurnLeft = new JButton("");
		btnTurnLeft.setBounds(367, 520, 40, 25);
		btnTurnLeft.setFocusPainted(false);
		btnTurnLeft.setIcon(
				new ImageIcon(QuanLiLaoDongJPanel.class.getResource("/images/baseline_fast_rewind_white_24dp.png")));
		btnTurnLeft.setBackground(Color.DARK_GRAY);

		lblPage = new JLabel("1");
		lblPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPage.setBackground(Color.LIGHT_GRAY);
		lblPage.setOpaque(true);
		lblPage.setBounds(410, 520, 55, 25);

		JButton btnTurnRight = new JButton("");
		btnTurnRight.setBounds(468, 520, 40, 25);
		btnTurnRight.setFocusPainted(false);
		btnTurnRight.setIcon(
				new ImageIcon(QuanLiLaoDongJPanel.class.getResource("/images/baseline_fast_forward_white_24dp.png")));
		btnTurnRight.setBackground(Color.DARK_GRAY);

		JButton btnTurnEnd = new JButton("");
		btnTurnEnd.setBounds(514, 520, 40, 25);
		btnTurnEnd.setFocusPainted(false);
		btnTurnEnd.setIcon(
				new ImageIcon(QuanLiLaoDongJPanel.class.getResource("/images/baseline_skip_next_white_24dp.png")));
		btnTurnEnd.setBackground(Color.DARK_GRAY);
		tableLaoDong.addMouseListener(this);

		btnTurnRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				denTrangSau();
			}
		});
		btnTurnTop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				denTrangDau();
			}
		});
		btnTurnLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				denTrangTruoc();
			}
		});
		btnTurnEnd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				denTrangCuoi();
			}
		});

		cboTinhTP.addItemListener(this);
		cboQuanHuyen.addItemListener(this);
		cboPhuongXa.addItemListener(this);

		ngaySinh = new JDateChooser();
		ngaySinh.setBounds(1198, 155, 106, 22);
		ngaySinh.setDateFormatString("dd/MM/yyyy");

		JLabel lblTmKim = new JLabel("Tìm kiếm:");
		lblTmKim.setBounds(33, 16, 63, 14);
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblMaNV_1 = new JLabel("Mã lao động:");
		lblMaNV_1.setBounds(32, 37, 98, 30);
		lblMaNV_1.setFont(new Font("Times New Roman", Font.BOLD, 16));

		txtTimMa = new JTextField();
		txtTimMa.setBounds(170, 40, 106, 22);
		txtTimMa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimMa.setColumns(10);
		txtTimMa.addKeyListener(this);

		txtTimTenLD = new JTextField();
		txtTimTenLD.setBounds(446, 41, 288, 22);
		txtTimTenLD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimTenLD.setColumns(10);
		txtTimTenLD.addKeyListener(this);

		JLabel lblMaNV_1_1 = new JLabel("Họ tên:");
		lblMaNV_1_1.setBounds(347, 40, 71, 25);
		lblMaNV_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JSeparator separator = new JSeparator();
		separator.setBounds(408, 11, 494, 2);
		setLayout(null);
		add(lblHoTenNV);
		add(lblSdt);
		add(cboTinhTP);
		add(cboQuanHuyen);
		add(cboPhuongXa);
		add(txtTenLD);
		add(txtSdt);
		add(lblMatKhau);
		add(txtMatKhau);
		add(lblNgaySinh);
		add(cboTrinhDo);
		add(lblNewLabel);
		add(lblNewLabel_2);
		add(txtCMND);
		add(scrollPane);
		add(lblNewLabel_3);
		add(cboGioiTinh);
		add(btnTurnTop);
		add(btnTurnLeft);
		add(lblPage);
		add(btnTurnRight);
		add(btnTurnEnd);
		add(ngaySinh);
		add(lblTmKim);
		add(lblMaNV_1);
		add(txtTimMa);
		add(txtTimTenLD);
		add(lblMaNV_1_1);
//		add(separator);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblaCh.setBounds(844, 324, 84, 30);
		add(lblaCh);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(844, 424, 89, 27);
		btnThem.setIcon(new ImageIcon(QuanLiLaoDongJPanel.class.getResource("/images/them.png")));
		add(btnThem);

		btnSua = new JButton("Cập nhật");
		btnSua.setBounds(951, 424, 106, 27);
		btnSua.setIcon(new ImageIcon(QuanLiLaoDongJPanel.class.getResource("/images/cap_nhat.png")));
		add(btnSua);

		btnXoaTrang = new JButton("Làm mới");
		btnXoaTrang.setBounds(1200, 424, 106, 27);
		btnXoaTrang.setIcon(new ImageIcon(QuanLiLaoDongJPanel.class.getResource("/images/lam_moi.png")));
		add(btnXoaTrang);

		btnXoa = new JButton("Nghỉ việc");
		btnXoa.setBounds(1074, 424, 106, 27);
		btnXoa.setIcon(new ImageIcon(QuanLiLaoDongJPanel.class.getResource("/images/xoa.png")));
		add(btnXoa);

		listLaoDong = new ArrayList<LaoDong>();

		listLaoDong = lDao.getAllLaoDong();
		listLaoDong = lDao.phanTrang(1, 11);
		docDuLieu();
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);

		
		JLabel lblTong = new JLabel("Trang:");
		lblTong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTong.setBounds(33, 520, 47, 25);
		add(lblTong);
		
		lblTinhTong = new JLabel("");
		lblTinhTong.setBounds(78, 520, 77, 25);
		add(lblTinhTong);
		
		
		

	}

	private void docDuLieu() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for (LaoDong ld : listLaoDong) {

			modelLaoDong.addRow(new Object[] { ld.getMaLaoDong(), ld.getTenLaoDong(), df.format(ld.getNgaySinh()),
					ld.isGioiTinh() ? "Nam" : "Ná»¯", ld.getSDT(), ld.getCMND(), ld.getDiaChi(),
					ld.getTrinhDo().getTenTrinhDo() });
		}
		
		try {
			LaoDong ld1 = listLaoDong.get(0);
			txtTenLD.setText(ld1.getTenLaoDong());
			txtCMND.setText(ld1.getCMND());
			txtSdt.setText(ld1.getSDT());
			ngaySinh.setDate(ld1.getNgaySinh());
			cboTrinhDo.setSelectedItem(ld1.getTrinhDo().getTenTrinhDo());
			cboTinhTP.setSelectedItem(ld1.getDiaChi().getTinhTP());
			cboQuanHuyen.setSelectedItem(ld1.getDiaChi().getQuanHuyen());
			cboPhuongXa.setSelectedItem(ld1.getDiaChi().getPhuongXa());
			txtTaiKhoan.setText(ld1.getMaLaoDong());
			txtMatKhau.setText(ld1.getMatKhau());
			cboGioiTinh.setSelectedItem(ld1.isGioiTinh() ? "Nam" : "Nữ");
			txtMatKhau.setEditable(false);
		} catch (Exception e) {
		}
		
	}

	/**
	 *
	 */
	private void denTrangTruoc() {

		int trang = Integer.parseInt(lblPage.getText());
		if (trang > 1) {
			lblPage.setText(String.valueOf(trang - 1));
			soDau = 11 * (trang - 2) + 1;
			soCuoi = soDau + 10;
			listLaoDong = lDao.phanTrang(soDau, soCuoi);
			xoaHetModel();
			docDuLieu();
		}
	}

	/**
	 * 
	 */
	public void denTrangSau() {

		int slDb = lDao.demSluongDuLieuTrongDB();
		int trangLonNhat;
		int trang = Integer.parseInt(lblPage.getText());
		if (slDb % 11 == 0) {
			trangLonNhat = slDb / 11;
		} else {
			trangLonNhat = slDb / 11 + 1;
		}
		if (trang < trangLonNhat) {
			lblPage.setText(String.valueOf(trang + 1));
			soDau = 11 * (trang) + 1;
			soCuoi = soDau + 10;
			listLaoDong = lDao.phanTrang(soDau, soCuoi);
			xoaHetModel();
			docDuLieu();
		}
	}

	/**
	 * 
	 */
	private void denTrangDau() {
		listLaoDong = lDao.phanTrang(1, 11);
		xoaHetModel();
		docDuLieu();
		lblPage.setText("1");
	}

	/**
	 * HÃ
	 */
	private void denTrangCuoi() {

		int slDb = lDao.demSluongDuLieuTrongDB();
		int trangLonNhat;
		if (slDb % 11 == 0) {
			trangLonNhat = slDb / 11;
		} else {
			trangLonNhat = slDb / 11 + 1;
		}
		soDau = 11 * (trangLonNhat - 1) + 1;
		soCuoi = soDau + 10;
		listLaoDong = lDao.phanTrang(soDau, soCuoi);
		xoaHetModel();
		docDuLieu();
		lblPage.setText(String.valueOf(trangLonNhat));

	}

	private void xoaHetModel() {
		DefaultTableModel df = (DefaultTableModel) tableLaoDong.getModel();
		df.getDataVector().removeAllElements();
		tableLaoDong.clearSelection();
	}

	public boolean validata() {
		if (txtTenLD.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên không để trống");
			txtTenLD.requestFocus();
			return false;
		}
		if (!txtTenLD.getText()
				.matches("[aAÃ Ã€áº£áº¢Ã£ÃƒÃ¡Ã�áº¡áº ÄƒÄ‚áº±áº°áº³áº²áºµáº´áº¯áº®áº·áº¶Ã¢Ã‚áº§áº¦áº©áº¨áº«áºªáº¥áº¤áº­áº¬bBcCdDÄ‘Ä�eEÃ¨Ãˆáº»áººáº½áº¼Ã©Ã‰áº¹áº¸ÃªÃŠá»�á»€á»ƒá»‚á»…á»„áº¿áº¾á»‡á»†\r\n"
						+ "fFgGhHiIÃ¬ÃŒá»‰á»ˆÄ©Ä¨Ã­Ã�á»‹á»ŠjJkKlLmMnNoOÃ²Ã’á»�á»ŽÃµÃ•Ã³Ã“á»�á»ŒÃ´Ã”á»“á»’á»•á»”á»—á»–á»‘á»�á»™á»˜Æ¡Æ á»�á»œá»Ÿá»žá»¡á» á»›á»šá»£á»¢pPqQrRsStTu\r\n"
						+ "UÃ¹Ã™á»§á»¦Å©Å¨ÃºÃšá»¥á»¤Æ°Æ¯á»«á»ªá»­á»¬á»¯á»®á»©á»¨á»±á»°vVwWxXyYá»³á»²á»·á»¶á»¹á»¸Ã½Ã�á»µá»´zZ ]+")) {
			JOptionPane.showMessageDialog(null, "TÃªn khÃ´ng Ä‘Æ°á»£c chá»©a kÃ½ tá»± Ä‘áº·c biá»‡t");
			txtTenLD.selectAll();
			txtTenLD.requestFocus();
			return false;
		}

		if (txtCMND.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "CMND Không để trống");
			txtCMND.requestFocus();
			return false;
		}

		if (!txtCMND.getText().matches("([0-9]{9}|[0-9]{12})")) {
			JOptionPane.showMessageDialog(null, "CMND phải bao gồm 9 số và 12 số");
			txtCMND.selectAll();
			txtCMND.requestFocus();
			return false;
		}

		if (txtSdt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống");
			txtSdt.requestFocus();
			return false;
		}

		if (!txtSdt.getText().matches("^0[0-9]{9}")) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không há»£p lá»‡");
			txtSdt.selectAll();
			txtSdt.requestFocus();
			return false;
		}

		if (ngaySinh.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh");
			return false;
		}
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String s[] = df.format(ngaySinh.getDate()).split("/");
		LocalDate ns = LocalDate.of(Integer.parseInt(s[2]), Integer.parseInt(s[1]), Integer.parseInt(s[0]));
		
		if(Period.between(ns, LocalDate.now()).getYears()<18) {
			JOptionPane.showMessageDialog(null, "Lao động phải trên 18 tuổi");
			ngaySinh.setDate(null);
			return false;
		}

		if(cboGioiTinh.getSelectedIndex()==0) {
			if(Period.between(ns, LocalDate.now()).getYears()>65) {
				JOptionPane.showMessageDialog(null, "Lao động nam phải nhỏ hơn 65 tuổi");
				ngaySinh.setDate(null);
				return false;
			}
		}
		else {
			if(Period.between(ns, LocalDate.now()).getYears()>55) {
				JOptionPane.showMessageDialog(null, "Lao động nữ phải nhỏ hơn 55 tuổi");
				ngaySinh.setDate(null);
				return false;
			}
		}
		
		if (cboTinhTP.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn tỉnh/thành phố");
			return false;
		}

		if (cboQuanHuyen.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn quận/huyện");
			return false;
		}
		if (cboPhuongXa.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn phường xã ");
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		if (o.equals(btnThem)) {
			if (tableLaoDong.getSelectedRow() > -1) {
				JOptionPane.showMessageDialog(null, "Vui lÃ²ng lÃ m má»›i trÆ°á»›c khi thÃªm");
				return;
			}
			if (validata()) {
				String ma = taoMaLD();
				String ten = txtTenLD.getText();
				String cmnd = txtCMND.getText();
				String sdt = txtSdt.getText();
				boolean gt = cboGioiTinh.getSelectedIndex() == 0;
				Date d = ngaySinh.getDate();
				String s[] = df.format(d).split("/");
				@SuppressWarnings("deprecation")
				java.sql.Date ngay = new java.sql.Date(Integer.parseInt(s[2]) - 1900, Integer.parseInt(s[1]) - 1,
						Integer.parseInt(s[0]));
				String td = cboTrinhDo.getSelectedItem().toString();
				String tinh = cboTinhTP.getSelectedItem().toString();
				String huyen = cboQuanHuyen.getSelectedItem().toString();
				String xa = cboPhuongXa.getSelectedItem().toString();
				if(lDao.timLDDuaVaoCMND(txtCMND.getText().trim()) == null) {
					int x = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm", "Thông báo", JOptionPane.YES_NO_OPTION);
					if (x == JOptionPane.YES_OPTION) {
						boolean t = lDao.themLD(new LaoDong(ma, ten, ngay, gt, cmnd, new DiaDiem(tinh, huyen, xa),
								new TrinhDo(td), sdt, "12345678"));
						if (t) {
							JOptionPane.showMessageDialog(this, "Thêm thành công");
							xoaRong();
							
						}
						else
							JOptionPane.showMessageDialog(this, "Thêm không thành công");
					}
				}
				else {
					JOptionPane.showMessageDialog(this, "Trùng nhân viên");
				}
				
			}
		} else if (o.equals(btnSua)) {
			int row = tableLaoDong.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn lao động");
				return;
			} else {
				if (validata()) {
					if (txtMatKhau.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Mật khẩu không được trống");
						return;
					}
					if (txtMatKhau.getText().length() < 8) {
						JOptionPane.showMessageDialog(null, "Mật khẩu phải lớn hơn 8 ký tự");
						txtMatKhau.selectAll();
						txtMatKhau.requestFocus();
						return;
					}
					LaoDong ld = listLaoDong.get(row);
					String ma = ld.getMaLaoDong();
					String ten = txtTenLD.getText();
					String cmnd = txtCMND.getText();
					String sdt = txtSdt.getText();
					boolean gt = cboGioiTinh.getSelectedIndex() == 0;
					Date d = ngaySinh.getDate();
					String s[] = df.format(d).split("/");
					@SuppressWarnings("deprecation")
					java.sql.Date ngay = new java.sql.Date(Integer.parseInt(s[2]) - 1900, Integer.parseInt(s[1]) - 1,
							Integer.parseInt(s[0]));
					String td = cboTrinhDo.getSelectedItem().toString();
					String tinh = cboTinhTP.getSelectedItem().toString();
					String huyen = cboQuanHuyen.getSelectedItem().toString();
					String xa = cboPhuongXa.getSelectedItem().toString();
					String matkhau = txtMatKhau.getText();
					ld = new LaoDong(ma, ten, ngay, gt, cmnd, new DiaDiem(tinh, huyen, xa), new TrinhDo(td), sdt,
							matkhau);
					int kt = JOptionPane.showConfirmDialog(null, "Bạn có mốn sửa", "Thông báo",
							JOptionPane.YES_NO_OPTION);
					if (kt == JOptionPane.YES_OPTION) {
						boolean t = lDao.suaLD(ld);
						if (t) {
							JOptionPane.showMessageDialog(this, "Sửa thành công");
							modelLaoDong.setValueAt(ma, row, 0);
							modelLaoDong.setValueAt(ten, row, 1);
							modelLaoDong.setValueAt(df.format(ngay), row, 2);
							modelLaoDong.setValueAt(gt ? "Nam" : "Nữ", row, 3);
							modelLaoDong.setValueAt(sdt, row, 4);
							modelLaoDong.setValueAt(cmnd, row, 5);
							modelLaoDong.setValueAt(tinh + ", " + huyen + ", " + xa, row, 6);
							modelLaoDong.setValueAt(td, row, 7);
							listLaoDong.add(row, ld);
							listLaoDong.remove(row + 1);
							xoaRong();
						} else
							JOptionPane.showMessageDialog(this, "Sủa không thành công");
					}
				}
			}
		} else if (o.equals(btnXoa)) {
			int row = tableLaoDong.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn lao động");
				return;
			} else {
				LaoDong ld = listLaoDong.get(row);
				int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn cho lao dộng nghỉ việc", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (a == JOptionPane.YES_OPTION) {
					boolean t = lDao.capNhatTrangThai(ld, false);
					if (t) {
						JOptionPane.showMessageDialog(this, "Thành công");
						listLaoDong = lDao.phanTrang(soDau, soCuoi);
						xoaRong();
						xoaHetModel();
						docDuLieu();
					} else
						JOptionPane.showMessageDialog(this, "Không thành công");
				}
			}
		} else {
			xoaRong();
		}
	}

	public void xoaRong() {
		txtTenLD.setText("");
		txtCMND.setText("");
		txtSdt.setText("");
		cboGioiTinh.setSelectedIndex(0);
		ngaySinh.setDate(null);
		cboTrinhDo.setSelectedIndex(0);
		cboTinhTP.setSelectedIndex(0);
		txtMatKhau.setText("");
		tableLaoDong.clearSelection();
		txtMatKhau.setEditable(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableLaoDong.getSelectedRow();
		LaoDong ld = listLaoDong.get(row);
		txtTenLD.setText(ld.getTenLaoDong());
		txtCMND.setText(ld.getCMND());
		txtSdt.setText(ld.getSDT());
		ngaySinh.setDate(ld.getNgaySinh());
		
		cboTrinhDo.setSelectedItem(ld.getTrinhDo().getTenTrinhDo());
		cboTinhTP.setSelectedItem(ld.getDiaChi().getTinhTP());
		cboQuanHuyen.setSelectedItem(ld.getDiaChi().getQuanHuyen());
		cboPhuongXa.setSelectedItem(ld.getDiaChi().getPhuongXa());
		txtTaiKhoan.setText(ld.getMaLaoDong());
		txtMatKhau.setText(ld.getMatKhau());
		cboGioiTinh.setSelectedItem(ld.isGioiTinh() ? "Nam" : "Nữ");
		txtMatKhau.setEditable(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object o = e.getSource();
		if (o.equals(cboTinhTP)) {
			String tinh = cboTinhTP.getSelectedItem().toString();
			ArrayList<String> quan = new DiaDiem_DAO().getQuan(tinh);
			for (int i = cboQuanHuyen.getItemCount() - 1; i >= 1; i--) {
				cboQuanHuyen.removeItemAt(i);
			}
			for (String q : quan) {
				cboQuanHuyen.addItem(q);
			}

		} else if (o.equals(cboQuanHuyen)) {
			String tinh = cboTinhTP.getSelectedItem().toString();
			String quan = cboQuanHuyen.getSelectedItem().toString();
			ArrayList<String> phuong = new DiaDiem_DAO().getPhuong(tinh, quan);
			for (int i = cboPhuongXa.getItemCount() - 1; i >= 1; i--) {
				cboPhuongXa.removeItemAt(i);
			}
			for (String p : phuong) {
				cboPhuongXa.addItem(p);
			}

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (!txtTimMa.getText().equals("") || !txtTimTenLD.getText().equals("")) {
			listLaoDong = lDao.timKiemLaoDong(txtTimMa.getText(), txtTimTenLD.getText());
			xoaHetModel();
			docDuLieu();

		} else {
			xoaHetModel();
			listLaoDong = lDao.phanTrang(1, 11);
			docDuLieu();
		}

	}

	public String taoMaLD() {
		String maCuoi = lDao.getLDCuoi().getMaLaoDong();
		long so = Long.parseLong(maCuoi.substring(2)) + 100000000 + 1;
		String soMoi = ("" + so).substring(1);
		return "LD" + soMoi;
	}
}
