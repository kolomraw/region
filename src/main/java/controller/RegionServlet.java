package controller;

import dao.RegionDAO;
import domain.Region;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/region")
public class RegionServlet extends HttpServlet {

    private RegionDAO dao = new RegionDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String deleteId = request.getParameter("deleteId");
        String editId = request.getParameter("editId");

        try {
            if (deleteId != null) {
                dao.delete(Long.parseLong(deleteId));
                response.sendRedirect("region");
                return;
            }

            if (editId != null) {
                Region edit = dao.findAll().stream()
                        .filter(r -> r.getId().equals(Long.parseLong(editId)))
                        .findFirst().orElse(null);

                request.setAttribute("editRegion", edit);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Region> regions = dao.findAll();
        request.setAttribute("regions", regions);

        request.getRequestDispatcher("/views/region.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        Region r = new Region(
                request.getParameter("name"),
                request.getParameter("area"),
                request.getParameter("adminCenter"),
                request.getParameter("head")
        );

        try {
            if (id != null && !id.isEmpty()) {
                r.setId(Long.parseLong(id));
                dao.update(r);
            } else {
                dao.insert(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("region");
    }
}