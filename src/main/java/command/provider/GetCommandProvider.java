package command.provider;

import command.HospitalCommand;
import command.impl.*;
import constant.HospitalPages;
import constant.HospitalPaths;
import utils.factory.provider.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * The type Get command provider.
 */
public class GetCommandProvider implements CommandProvider {
    private final Map<String, HospitalCommand> command = new HashMap<>();

    /**
     * Instantiates a new Get command provider.
     */
    public GetCommandProvider() {
        command.put(HospitalPaths.HOME_HOSPITAL, new HomeCommand());
        command.put(HospitalPaths.LOGOUT, new LogoutCommand());
        command.put(HospitalPaths.ABOUT, new AboutCommand());
        command.put(HospitalPaths.LOGIN, (req, res) -> forward(req, res, HospitalPages.SIGN_IN));
        command.put(HospitalPaths.REGISTER, (req, res) -> forward(req, res, HospitalPages.SIGN_UP));

        command.put(HospitalPaths.ADMIN_HOME, new AdminHomepage());
        command.put(HospitalPaths.DOCTOR_HOME, new DoctorHomepage());
        command.put(HospitalPaths.NURSE_HOME, new NurseHomepage());
        command.put(HospitalPaths.PATIENT_HOME, new PatientHomepage());

        command.put(HospitalPaths.ADMIN_REGISTER_DOCTOR, (req, res) -> forward(req, res, HospitalPages.REGISTER_DOCTOR));
        command.put(HospitalPaths.ADMIN_REGISTER_PATIENT, (req, res) -> forward(req, res, HospitalPages.REGISTER_PATIENT));
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
