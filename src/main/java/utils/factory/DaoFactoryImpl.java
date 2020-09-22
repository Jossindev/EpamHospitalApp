package utils.factory;

import model.dao.*;

public class DaoFactoryImpl implements DaoFactory {

    private static DaoFactoryImpl instance;

    public static DaoFactoryImpl getInstance() {
        if (instance == null) {
            synchronized (DaoFactoryImpl.class) {
                if (instance == null)
                    instance = new DaoFactoryImpl();
            }
        }
        return instance;
    }

    private DaoFactoryImpl() { }

    @Override
    public AssignmentDAO createAssignmentDao() {
        return new AssignmentDAO();
    }

    @Override
    public TreatmentDAO createTreatmentDao() {
        return new TreatmentDAO();
    }

    @Override
    public RoleDAO createRoleDao() {
        return new RoleDAO();
    }

    @Override
    public UserDAO createUserDao() {
        return new UserDAO();
    }

    @Override
    public DiagnosisDAO createDiagnoseDao() {
        return new DiagnosisDAO();
    }
}
