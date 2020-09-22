package utils.factory;

import model.dao.*;

public interface DaoFactory {
    AssignmentDAO createAssignmentDao();
    TreatmentDAO createTreatmentDao();
    RoleDAO createRoleDao();
    UserDAO createUserDao();
    DiagnosisDAO createDiagnoseDao();
}
