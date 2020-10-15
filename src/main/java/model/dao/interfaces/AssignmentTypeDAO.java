package model.dao.interfaces;

import model.entity.AssignmentType;

import java.util.List;

/**
 * The interface Assignment type dao.
 */
public interface AssignmentTypeDAO {
    /**
     * Find by id assignment type.
     *
     * @param id the id
     * @return the assignment type
     */
    AssignmentType findById(int id);

    /**
     * Find all type list.
     *
     * @return the list
     */
    List<AssignmentType> findAllType();
}
