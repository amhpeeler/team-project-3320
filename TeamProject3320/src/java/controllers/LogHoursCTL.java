@WebServlet(name = "LogHoursCTL", urlPatterns = {"/logHours"})
public class LogHoursCTL extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String projectId = request.getParameter("projectId");
        String hours = request.getParameter("hours");

        // Validate input
        if (projectId == null || hours == null || projectId.isEmpty() || hours.isEmpty()) {
            // Handle invalid input
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameters");
            return;
        }

        HttpSession session = request.getSession();
        String studentID = (String) session.getAttribute("user");

        // Call a method to log the hours for the student on the project
        // You need to implement this method in your Project model

        // Redirect back to the project page after logging hours
        response.sendRedirect(request.getContextPath() + "/studentProjectsCTL");
    }
}