package org.home.ilya.tz;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.home.ilya.tz.entity.StudentGroup;

@Stateless
public class StudentGroupFacade extends AbstractFacade<StudentGroup> {
    @PersistenceContext(unitName = "StudentsProject")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentGroupFacade() {
        super(StudentGroup.class);
    }
    
}
