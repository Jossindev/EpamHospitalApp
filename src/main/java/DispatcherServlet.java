import command.HospitalCommand;
import utils.factory.provider.CommandProvider;
import utils.factory.provider.creator.Creator;
import utils.factory.provider.creator.GetCommandCreator;
import utils.factory.provider.creator.PostCommandCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Creator getCreator = new GetCommandCreator();
    private static final Creator postCreator = new PostCommandCreator();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        execute(request, response, getCreator, uri);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        execute(request, response, postCreator, uri);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response, Creator creator, String uri) throws ServletException, IOException {
        CommandProvider commandProvider = creator.createCommandProvider();
        HospitalCommand command = commandProvider.provideCommand(uri);
        command.execute(request, response);
    }
}
