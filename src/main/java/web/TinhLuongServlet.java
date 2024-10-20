package web;

import dao.TinhLuongDAO;
import model.TinhLuong;
import model.TinhLuong;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class TinhLuongServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TinhLuongDAO tinhLuongDAO;

    public void init() {
        tinhLuongDAO = new TinhLuongDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/updateLuong":
                	updateLuong(request,response);
                	break;
                case"/editLuong":
                	showEditForm(request, response);
                    break;
                case "/newLuong":
                    showNewForm(request, response);
                    break;
                case "/insertLuong":
                    insertLuong(request, response);
                    break;
                case "/deleteLuong":
                    deleteLuong(request, response);
                    break;
                default:
                    listLuong(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("tinhluong-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertLuong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String maNV = request.getParameter("maNV");
        String thangNam = request.getParameter("thangNam");
        BigDecimal tongSoGioLam = new BigDecimal(request.getParameter("tongSoGioLam"));
        BigDecimal heSoLuong = new BigDecimal(request.getParameter("heSoLuong"));
        BigDecimal luongTheoGio = new BigDecimal(request.getParameter("luongTheoGio"));
        BigDecimal phuCap = new BigDecimal(request.getParameter("phuCap"));

        BigDecimal tongLuong = tongSoGioLam.multiply(luongTheoGio).add(phuCap);

        TinhLuong newLuong = new TinhLuong(maNV,thangNam,tongSoGioLam,heSoLuong,luongTheoGio,phuCap, tongLuong);
        tinhLuongDAO.insertLuong(newLuong);
        response.sendRedirect("listLuong");
    }


    private void deleteLuong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int maBangLuong = Integer.parseInt(request.getParameter("maBangLuong"));
        tinhLuongDAO.deleteLuong(maBangLuong);
        response.sendRedirect("listLuong");
    }

    private void listLuong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TinhLuong> listLuong = tinhLuongDAO.selectAllLuong();
        request.setAttribute("listLuong", listLuong);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tinhluong-list.jsp");
        dispatcher.forward(request, response);
    }
    public void updateLuong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int maBangLuong = Integer.parseInt(request.getParameter("maBangLuong"));
        String maNV = request.getParameter("maNV");
        String thangNam = request.getParameter("thangNam");
        BigDecimal tongSoGioLam = new BigDecimal(request.getParameter("tongSoGioLam"));
        BigDecimal heSoLuong = new BigDecimal(request.getParameter("heSoLuong"));
        BigDecimal luongTheoGio = new BigDecimal(request.getParameter("luongTheoGio"));
        BigDecimal phuCap = new BigDecimal(request.getParameter("phuCap"));
        
        TinhLuong luong = new TinhLuong(maBangLuong, maNV, thangNam, tongSoGioLam, heSoLuong, luongTheoGio, phuCap, BigDecimal.ZERO);
        tinhLuongDAO.updateLuong(luong);
        response.sendRedirect("listLuong");
    }

    public void showEditForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int maBangLuong=Integer.parseInt(request.getParameter("maBangLuong"));
		TinhLuong exitstringTinhLuong = tinhLuongDAO.selectTinhLuong(maBangLuong);
		RequestDispatcher dispatcher=request.getRequestDispatcher("tinhluong-form.jsp");
		request.setAttribute("tinhluong", exitstringTinhLuong);
		dispatcher.forward(request, response);
	}

}
