package com.sangomar.student.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class StudentTest {
    /**
     * Method under test: {@link Student#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Student()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Student#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Student student = new Student();

        Student student1 = new Student();
        student1.setId(1);
        student1.setMobileNo("Mobile No");
        student1.setName("Name");
        assertTrue(student.canEqual(student1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#Student()}
     *   <li>{@link Student#setId(int)}
     *   <li>{@link Student#setMobileNo(String)}
     *   <li>{@link Student#setName(String)}
     *   <li>{@link Student#toString()}
     *   <li>{@link Student#getId()}
     *   <li>{@link Student#getMobileNo()}
     *   <li>{@link Student#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Student actualStudent = new Student();
        actualStudent.setId(1);
        actualStudent.setMobileNo("Mobile No");
        actualStudent.setName("Name");
        String actualToStringResult = actualStudent.toString();
        assertEquals(1, actualStudent.getId());
        assertEquals("Mobile No", actualStudent.getMobileNo());
        assertEquals("Name", actualStudent.getName());
        assertEquals("Student(id=1, name=Name, mobileNo=Mobile No)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#Student(int, String, String)}
     *   <li>{@link Student#setId(int)}
     *   <li>{@link Student#setMobileNo(String)}
     *   <li>{@link Student#setName(String)}
     *   <li>{@link Student#toString()}
     *   <li>{@link Student#getId()}
     *   <li>{@link Student#getMobileNo()}
     *   <li>{@link Student#getName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Student actualStudent = new Student(1, "Name", "Mobile No");
        actualStudent.setId(1);
        actualStudent.setMobileNo("Mobile No");
        actualStudent.setName("Name");
        String actualToStringResult = actualStudent.toString();
        assertEquals(1, actualStudent.getId());
        assertEquals("Mobile No", actualStudent.getMobileNo());
        assertEquals("Name", actualStudent.getName());
        assertEquals("Student(id=1, name=Name, mobileNo=Mobile No)", actualToStringResult);
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals() {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName("Name");
        assertNotEquals(student, null);
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals2() {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName("Name");
        assertNotEquals(student, "Different type to Student");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#equals(Object)}
     *   <li>{@link Student#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName("Name");
        assertEquals(student, student);
        int expectedHashCodeResult = student.hashCode();
        assertEquals(expectedHashCodeResult, student.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#equals(Object)}
     *   <li>{@link Student#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName("Name");

        Student student1 = new Student();
        student1.setId(1);
        student1.setMobileNo("Mobile No");
        student1.setName("Name");
        assertEquals(student, student1);
        int expectedHashCodeResult = student.hashCode();
        assertEquals(expectedHashCodeResult, student1.hashCode());
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals5() {
        Student student = new Student();
        student.setId(123);
        student.setMobileNo("Mobile No");
        student.setName("Name");

        Student student1 = new Student();
        student1.setId(1);
        student1.setMobileNo("Mobile No");
        student1.setName("Name");
        assertNotEquals(student, student1);
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals6() {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Name");
        student.setName("Name");

        Student student1 = new Student();
        student1.setId(1);
        student1.setMobileNo("Mobile No");
        student1.setName("Name");
        assertNotEquals(student, student1);
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals7() {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo(null);
        student.setName("Name");

        Student student1 = new Student();
        student1.setId(1);
        student1.setMobileNo("Mobile No");
        student1.setName("Name");
        assertNotEquals(student, student1);
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals8() {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName("Mobile No");

        Student student1 = new Student();
        student1.setId(1);
        student1.setMobileNo("Mobile No");
        student1.setName("Name");
        assertNotEquals(student, student1);
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals9() {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName(null);

        Student student1 = new Student();
        student1.setId(1);
        student1.setMobileNo("Mobile No");
        student1.setName("Name");
        assertNotEquals(student, student1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#equals(Object)}
     *   <li>{@link Student#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo(null);
        student.setName("Name");

        Student student1 = new Student();
        student1.setId(1);
        student1.setMobileNo(null);
        student1.setName("Name");
        assertEquals(student, student1);
        int expectedHashCodeResult = student.hashCode();
        assertEquals(expectedHashCodeResult, student1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#equals(Object)}
     *   <li>{@link Student#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        Student student = new Student();
        student.setId(1);
        student.setMobileNo("Mobile No");
        student.setName(null);

        Student student1 = new Student();
        student1.setId(1);
        student1.setMobileNo("Mobile No");
        student1.setName(null);
        assertEquals(student, student1);
        int expectedHashCodeResult = student.hashCode();
        assertEquals(expectedHashCodeResult, student1.hashCode());
    }
}

