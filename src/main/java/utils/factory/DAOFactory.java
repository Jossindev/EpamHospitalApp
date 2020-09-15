package utils.factory;

import implementation.*;

public class DAOFactory {
    public UserDAOImpl createUserDao() {
        return new UserDAOImpl();
    }

    public PatientDataImpl createPatientDataDao() {
        return new PatientDataImpl();
    }

    public PrescriptionDAOImpl createPrescriptionDao() {
        return  new PrescriptionDAOImpl();
    }

    public DiagnosisDAOImpl createDiagnosisDao() {
        return new DiagnosisDAOImpl();
    }

    public RoleDAOImpl createRoleDao() {
        return new RoleDAOImpl();
    }
}
