package command.provider;

import command.HospitalCommand;
import command.impl.HomeCommand;
import command.impl.LogoutCommand;
import utils.factory.provider.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetCommandProvider implements CommandProvider {
    private final Map<String, HospitalCommand> command = new HashMap<>();

    public GetCommandProvider() {
        command.put("HOME", new HomeCommand());
        command.put("LOGOUT", new LogoutCommand());
        command.put("LOGIN", (req, res) -> forward(req, res, "SIGN_IN"));
        command.put("REGISTER", (req, res) -> forward(req, res, "SIGN_UP"));
    }

    @Override
    public HospitalCommand provideCommand(String uri) {
        HospitalCommand hospitalCommand = command.get(uri);
        if (hospitalCommand == null) {
            return command.get(1);
        }
        return hospitalCommand;
    }

    private static void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request, response);
    }
}
