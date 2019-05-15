package com.patccy.hibernate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateTest {
    public static void main(String[] args) {

        try {
            EntityManager entityManager = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();
            //Test Insert
            Instructor i1 = new Instructor();
            i1.setEmail("test@mail.com");
            i1.setId(100);
            i1.setName("patcyy");


            Course c1 = new Course();
            c1.setCourseName("Java");
            c1.setCourseId(1);

            Course c2 = new Course();
            c2.setCourseName("C");
            c2.setCourseId(2);

            i1.addCourse(c1);
            i1.addCourse(c2);

            //insert in DB
            inserIntoDb(entityManager, i1);

        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

    }

    /**
     *
     * @param factory
     * @param st
     */
    private static void inserIntoDb(EntityManager entityManager, Instructor st) {

        System.out.println("Inserting into DB");


        entityManager.getTransaction().begin();

        entityManager.persist(st);
        entityManager.getTransaction().commit();


    }
}
