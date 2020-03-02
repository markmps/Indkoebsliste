import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LogInServlet", urlPatterns = {"/LogInServlet"})
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        HttpSession session = request.getSession();
        //Session objektet hænger på browseren
        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");

        //response.getWriter().println("du har ramt loginservletten");

        if(servletContext.getAttribute("brugerMap") == null) {

            Map<String,String> brugerMap = new HashMap<>();

            brugerMap.put("test","test");
            brugerMap.put("admin","1234");

            servletContext.setAttribute("brugerMap", brugerMap);
        }



        if(!((Map<String,String>)servletContext.getAttribute("brugerMap")).containsKey(navn)){



            request.setAttribute("besked","Opret dig som bruger");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request,response);

        }

        if(((Map<String,String>)servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)) {

            if(navn.equalsIgnoreCase("admin")){
                //
                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request,response);
            }

            session.setAttribute("besked","Du er logget ind med navnet " + navn);
            request.getRequestDispatcher("WEB-INF/HuskeListe.jsp").forward(request,response);

        }
        //todo gå til login dvs index siden.
        request.setAttribute("besked","din kode var forkert, prøv igen");
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
