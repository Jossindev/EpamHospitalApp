package command.provider;

import command.HospitalCommand;
import command.impl.*;
import utils.factory.provider.CommandProvider;

import java.util.HashMap;
import java.util.Map;

import static constant.HospitalPaths.*;

public class PostCommandProvider implements CommandProvider {
    private final Map<String, HospitalCommand> command = new HashMap<>();

    public PostCommandProvider() {
        command.put(HOME_HOSPITAL, new HomeCommand());
        command.put(LOGIN, new LoginCommand());
        command.put(REGISTER, new RegisterCommand());
        command.put(ADMIN_HOME, new AdminHomepage());
        command.put(DOCTOR_HOME, new DoctorHomepage());
        command.put(NURSE_HOME, new NurseHomepage());
        command.put(PATIENT_HOME, new PatientHomepage());
        command.put(ADMIN_REGISTER_PATIENT, new PatientRegister());
        command.put(ADMIN_REGISTER_DOCTOR, new DoctorRegister());
        command.put(ADMIN_ASSIGN_DOCTOR, new AssignDoctorCommand());
        command.put(DOCTOR_COMPLETE_ASSIGNMENT, new CompleteAssignmentCommand());
        command.put(DOCTOR_CREATE_ASSIGNMENT, new CreateAssignmentCommand());
        command.put(DOCTOR_DEFINE_DIAGNOSIS, new DefineDiagnosisCommand());
    }

    @Override
    public HospitalCommand provideCommand(String uri) {
        HospitalCommand hospitalCommand = command.get(uri);
        if (hospitalCommand == null) {
            return command.get(HOME_HOSPITAL);
        }
        return hospitalCommand;
    }
}
