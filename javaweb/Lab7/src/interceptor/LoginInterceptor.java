package interceptor;

import java.io.IOException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import po.User;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        String url = request.getRequestURI().toLowerCase();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        if (url.endsWith("/login") || user != null) {
            return true;
        }
        request.setAttribute("msg", "您还没有登录，请先登录");
        RequestDispatcher rDispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
        rDispatcher.forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
}
