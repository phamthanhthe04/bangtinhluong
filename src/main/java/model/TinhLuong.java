package model;

import java.math.BigDecimal;

public class TinhLuong {
    private int maBangLuong;
    private String maNV;
    private String thangNam;
    private BigDecimal tongSoGioLam;
    private BigDecimal heSoLuong;
    private BigDecimal luongTheoGio;
    private BigDecimal phuCap;
    private BigDecimal tongLuong;

    public TinhLuong(int maBangLuong, String maNV, String thangNam, BigDecimal tongSoGioLam, BigDecimal heSoLuong, BigDecimal luongTheoGio, BigDecimal phuCap, BigDecimal tongLuong) {
        this.maBangLuong = maBangLuong;
        this.maNV = maNV;
        this.thangNam = thangNam;
        this.tongSoGioLam = tongSoGioLam;
        this.heSoLuong = heSoLuong;
        this.luongTheoGio = luongTheoGio;
        this.phuCap = phuCap;
        this.tongLuong = tongLuong;
    }
    

    public TinhLuong(String maNV, String thangNam, BigDecimal tongSoGioLam, BigDecimal heSoLuong,
			BigDecimal luongTheoGio, BigDecimal phuCap, BigDecimal tongLuong) {
		super();
		this.maNV = maNV;
		this.thangNam = thangNam;
		this.tongSoGioLam = tongSoGioLam;
		this.heSoLuong = heSoLuong;
		this.luongTheoGio = luongTheoGio;
		this.phuCap = phuCap;
		this.tongLuong = tongLuong;
	}
    


	public TinhLuong(int maBangLuong, String maNV, String thangNam, BigDecimal tongSoGioLam, BigDecimal heSoLuong,
			BigDecimal luongTheoGio, BigDecimal phuCap) {
		super();
		this.maBangLuong = maBangLuong;
		this.maNV = maNV;
		this.thangNam = thangNam;
		this.tongSoGioLam = tongSoGioLam;
		this.heSoLuong = heSoLuong;
		this.luongTheoGio = luongTheoGio;
		this.phuCap = phuCap;
	}


	public int getMaBangLuong() {
		return maBangLuong;
	}


	public void setMaBangLuong(int maBangLuong) {
		this.maBangLuong = maBangLuong;
	}


	public String getMaNV() {
		return maNV;
	}


	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}


	public String getThangNam() {
		return thangNam;
	}


	public void setThangNam(String thangNam) {
		this.thangNam = thangNam;
	}


	public BigDecimal getTongSoGioLam() {
		return tongSoGioLam;
	}


	public void setTongSoGioLam(BigDecimal tongSoGioLam) {
		this.tongSoGioLam = tongSoGioLam;
	}


	public BigDecimal getHeSoLuong() {
		return heSoLuong;
	}


	public void setHeSoLuong(BigDecimal heSoLuong) {
		this.heSoLuong = heSoLuong;
	}


	public BigDecimal getLuongTheoGio() {
		return luongTheoGio;
	}


	public void setLuongTheoGio(BigDecimal luongTheoGio) {
		this.luongTheoGio = luongTheoGio;
	}


	public BigDecimal getPhuCap() {
		return phuCap;
	}


	public void setPhuCap(BigDecimal phuCap) {
		this.phuCap = phuCap;
	}


	public BigDecimal getTongLuong() {
		return tongLuong;
	}


	public void setTongLuong(BigDecimal tongLuong) {
		this.tongLuong = tongLuong;
	}
    


}
