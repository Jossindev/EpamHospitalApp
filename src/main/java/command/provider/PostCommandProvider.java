package command.provider;

import command.HospitalCommand;
import command.impl.*;
import constant.HospitalPaths;
import utils.factory.provider.CommandProvider;

import java.util.HashMap;
import java.util.Map;

public class PostCommandProvider implements CommandProvider {
    private final Map<String, HospitalCommand> command = new HashMap<>();

    public PostCommandProvider() {
        command.put(HospitalPaths.HOME_HOSPITAL, new HomeCommand());
        command.put(HospitalPaths.LOGIN, new LoginCommand());
        command.put(HospitalPaths.REGISTER, new RegisterCommand());
        command.put(HospitalPaths.ADMIN_HOME, new AdminHomepage());
        command.put(HospitalPaths.DOCTOR_HOME, new DoctorHomepage());
        command.put(HospitalPaths.NURSE_HOME, new NurseHomepage());
        command.put(HospitalPaths.PATIENT_HOME, new PatientHomepage());
        command.put(HospitalPaths.ADMIN_REGISTER_PATIENT, new PatientRegister());
        command.put(HospitalPaths.ADMIN_REGISTER_DOCTOR, new DoctorRegister());
    }

    @Override
    public HospitalCommand provideCommand(String uri) {
        HospitalCommand hospitalCommand = command.get(uri);
        if (hospitalCommand == null) {
            return command.get(HospitalPaths.HOME_HOSPITAL);
        }
        return hospitalCommand;
    }
}
