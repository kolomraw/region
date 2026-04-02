package controller;

import dao.DistrictDAO;
import domain.District;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/district")
public class DistrictServlet extends HttpServlet {

    private final DistrictDAO dao = new DistrictDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        handleActions(request, response);

        List<District> districts = dao.findAll();
        request.setAttribute("districts", districts);

        request.getRequestDispatcher("/views/district.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        District d = buildDistrict(request);

        String id = request.getParameter("id");

        try {
            if (id != null && !id.isEmpty()) {
                d.setId(Long.parseLong(id));
                dao.update(d);
            } else {
                dao.insert(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("district");
    }

    private void handleActions(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String deleteId = request.getParameter("deleteId");
        String editId = request.getParameter("editId");

        try {
            if (deleteId != null) {
                dao.delete(Long.parseLong(deleteId));
                response.sendRedirect("district");
                return;
            }

            if (editId != null) {
                District edit = dao.findAll().stream()
                        .filter(d -> d.getId().equals(Long.parseLong(editId)))
                        .findFirst()
                        .orElse(null);

                request.setAttribute("editDistrict", edit);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private District buildDistrict(HttpServletRequest request) {
        return new District(
                request.getParameter("name"),
                request.getParameter("area"),
                request.getParameter("adminCenter"),
                request.getParameter("head"),
                null
        );
    }
}