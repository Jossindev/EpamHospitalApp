package command.provider;

import command.HospitalCommand;
import command.impl.AboutCommand;
import command.impl.HomeCommand;
import command.impl.LogoutCommand;
import constant.HospitalPages;
import constant.HospitalPaths;
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
        command.put(HospitalPaths.HOME_HOSPITAL, new HomeCommand());
        command.put(HospitalPaths.LOGOUT, new LogoutCommand());
        command.put(HospitalPaths.ABOUT, new AboutCommand());
        command.put(HospitalPaths.LOGIN, (req, res) -> forward(req, res, HospitalPages.SIGN_IN));
        command.put(HospitalPaths.REGISTER, (req, res) -> forward(req, res, HospitalPages.SIGN_UP));
    }

    @Override
    public HospitalCommand provideCommand(String uri) {
        HospitalCommand hospitalCommand = command.get(uri);
        if (hospitalCommand == null) {
            return command.get(HospitalPaths.HOME_HOSPITAL);
        }
        return hospitalCommand;
    }

    private static void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request, response);
    }
}
