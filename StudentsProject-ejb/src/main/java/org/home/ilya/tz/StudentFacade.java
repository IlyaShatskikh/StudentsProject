package org.home.ilya.tz;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.home.ilya.tz.entity.Student;

@Stateless
public class StudentFacade extends AbstractFacade<Student> {
    @PersistenceContext(unitName = "StudentsProject")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    @Override
    public void remove(Student entity) {
        super.remove(entity);
    }

    @Override
    public void create(Student entity) {
        super.create(entity);
    }
     
}
