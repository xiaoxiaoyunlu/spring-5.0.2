package deubg;

import org.springframework.http.HttpMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyServlet
 * @Description TODO
 * @Author USER
 * @Date 2020/4/2 14:42
 * @Company
 **/
public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);

		ServletContext servletContext = getServletContext();

		RequestDispatcher requestDispatcher =
				servletContext.getRequestDispatcher("/login.jsp");

		if(req.getMethod()==HttpMethod.GET.name()){
			this.doGet(req,resp);
		}else if(req.getMethod()==HttpMethod.POST.name()){
			this.doPost(req,resp);
		}else{
			throw new RuntimeException("not support http method");
		}

	}
}
