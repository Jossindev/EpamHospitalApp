package command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The interface Hospital command.
 */
public interface HospitalCommand {
    /**
     * Execute.
     *
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
