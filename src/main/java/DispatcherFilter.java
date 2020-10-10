import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constant.HospitalPages.FORBIDDEN_PAGE;
import static constant.HospitalPaths.*;

@WebFilter("/*")
public class DispatcherFilter implements Filter {
    private static final Map<String, String> PROTECTED_URIS = new HashMap<>();
    private static final List<String> GUEST = new ArrayList<>();


    static {
        GUEST.add(LOGIN);
        GUEST.add(REGISTER);

        PROTECTED_URIS.put(DOCTOR_HOME, "DOCTOR");
        PROTECTED_URIS.put(ADMIN_HOME, "ADMIN");
        PROTECTED_URIS.put(PATIENT_HOME, "PATIENT");
        PROTECTED_URIS.put(NURSE_HOME, "DOCTOR");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();
        String uri = httpServletRequest.getRequestURI();

        String currentRole = PROTECTED_URIS.get(uri);
        String sessionRole = (String) session.getAttribute("role");

        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        if (GUEST.contains(uri) && sessionRole != null) {
            request.getRequestDispatcher(FORBIDDEN_PAGE).forward(request, response);
            return;
        }

        if (PROTECTED_URIS.containsKey(uri)) {
            if (sessionRole == null) {
                request.getRequestDispatcher(HOME_HOSPITAL).forward(request, response);
            }
            if (!currentRole.equals(sessionRole)) {
                request.getRequestDispatcher(FORBIDDEN_PAGE).forward(request, response);
            }
        }

        chain.doFilter(request, response);
    }
}
