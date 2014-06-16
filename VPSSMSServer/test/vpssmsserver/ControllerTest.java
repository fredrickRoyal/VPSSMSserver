/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vpssmsserver;

import java.sql.DriverManager;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Royal
 */
public class ControllerTest {
    public static Connection connection;
    
    public ControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String host = "localhost";
            String port = "3306";
            String db = "VPSSMS";
            String user = "root";
            String passWord = "";
            String mysqlURL = "jdbc:mysql://" + host + ":" + port + "/" + db;
            connection = DriverManager.getConnection(mysqlURL, user, passWord);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        try{
            connection.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSchoolAttendedList method, of class Controller.
     */
    @Test
    public void testNullGetSchoolAttendedList() throws Exception {
        System.out.println("getSchoolAttendedList");
        //Controller instance = new Controller();
        ArrayList<SchoolAttended> list=null;
       // ArrayList expResult = null;
        //ArrayList result = instance.getSchoolAttendedList();
        assertNull(list);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testNotNullGetSchoolAttendedList() throws Exception {
        System.out.println("getSchoolAttendedList");
        //Controller instance = new Controller();
        ArrayList<SchoolAttended> list=null;
       // ArrayList expResult = null;
        //ArrayList result = instance.getSchoolAttendedList();
        assertNull(list);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getGuardianList method, of class Controller.
     */
    @Test
    public void testGetGuardianList() throws Exception {
        System.out.println("getGuardianList");
         ArrayList<SchoolAttended> list = new ArrayList<SchoolAttended>();
         list.add(new SchoolAttended("00023","0926","School",2,"years","UCE certificate","completed","active"));
        assertNotNull(list);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParentList method, of class Controller.
     */
    @Test
    public void testGetParentList() throws Exception {
        System.out.println("getParentList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getParentList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentList method, of class Controller.
     */
    @Test
    public void testGetStudentList() throws Exception {
        System.out.println("getStudentList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getStudentList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of studentClassList method, of class Controller.
     */
    @Test
    public void testStudentClassList() throws Exception {
        System.out.println("studentClassList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.studentClassList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaperList method, of class Controller.
     */
    @Test
    public void testGetPaperList() throws Exception {
        System.out.println("getPaperList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getPaperList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubjectRegisterList method, of class Controller.
     */
    @Test
    public void testGetSubjectRegisterList() throws Exception {
        System.out.println("getSubjectRegisterList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getSubjectRegisterList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubjectList method, of class Controller.
     */
    @Test
    public void testGetSubjectList() throws Exception {
        System.out.println("getSubjectList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getSubjectList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentClassList method, of class Controller.
     */
    @Test
    public void testGetStudentClassList() throws Exception {
        System.out.println("getStudentClassList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getStudentClassList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClassList method, of class Controller.
     */
    @Test
    public void testGetClassList() throws Exception {
        System.out.println("getClassList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getClassList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClassStreamList method, of class Controller.
     */
    @Test
    public void testGetClassStreamList() throws Exception {
        System.out.println("getClassStreamList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getClassStreamList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStreamList method, of class Controller.
     */
    @Test
    public void testGetStreamList() throws Exception {
        System.out.println("getStreamList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getStreamList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of classStreamRegisteredList method, of class Controller.
     */
    @Test
    public void testClassStreamRegisteredList() throws Exception {
        System.out.println("classStreamRegisteredList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.classStreamRegisteredList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubjectRegisteredList method, of class Controller.
     */
    @Test
    public void testGetSubjectRegisteredList() throws Exception {
        System.out.println("getSubjectRegisteredList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getSubjectRegisteredList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClassSubjectRegisterList method, of class Controller.
     */
    @Test
    public void testGetClassSubjectRegisterList() throws Exception {
        System.out.println("getClassSubjectRegisterList");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getClassSubjectRegisterList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubjectPaperRegisterist method, of class Controller.
     */
    @Test
    public void testGetSubjectPaperRegisterist() throws Exception {
        System.out.println("getSubjectPaperRegisterist");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getSubjectPaperRegisterist();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentResult method, of class Controller.
     */
    @Test
    public void testGetStudentResult() throws Exception {
        System.out.println("getStudentResult");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.getStudentResult();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchStudent method, of class Controller.
     */
    @Test
    public void testSearchStudent_0args() throws Exception {
        System.out.println("searchStudent");
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.searchStudent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchStudent method, of class Controller.
     */
    @Test
    public void testSearchStudent_String_String() throws Exception {
        System.out.println("searchStudent");
        String criteria = "";
        String searchText = "";
        Controller instance = new Controller();
        ArrayList expResult = null;
        ArrayList result = instance.searchStudent(criteria, searchText);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerNewStudent method, of class Controller.
     */
    @Test
    public void testRegisterNewStudent() throws Exception {
        System.out.println("registerNewStudent");
        Student student = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.registerNewStudent(student);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerParent method, of class Controller.
     */
    @Test
    public void testRegisterParent() throws Exception {
        System.out.println("registerParent");
        Parent parent = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.registerParent(parent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerGuardian method, of class Controller.
     */
    @Test
    public void testRegisterGuardian() throws Exception {
        System.out.println("registerGuardian");
        Guardian guardian = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.registerGuardian(guardian);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerSchoolAttended method, of class Controller.
     */
    @Test
    public void testRegisterSchoolAttended() throws Exception {
        System.out.println("registerSchoolAttended");
        SchoolAttended school = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.registerSchoolAttended(school);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createStudentClass method, of class Controller.
     */
    @Test
    public void testCreateStudentClass() throws Exception {
        System.out.println("createStudentClass");
        StudentClass studentClass = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createStudentClass(studentClass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createClassStream method, of class Controller.
     */
    @Test
    public void testCreateClassStream() throws Exception {
        System.out.println("createClassStream");
        ClassStream stream = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createClassStream(stream);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerClassStream method, of class Controller.
     */
    @Test
    public void testRegisterClassStream() throws Exception {
        System.out.println("registerClassStream");
        ClassStreamRegister register = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.registerClassStream(register);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerOldStudent method, of class Controller.
     */
    @Test
    public void testRegisterOldStudent() throws Exception {
        System.out.println("registerOldStudent");
        StudentRegister register = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.registerOldStudent(register);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSubject method, of class Controller.
     */
    @Test
    public void testCreateSubject() throws Exception {
        System.out.println("createSubject");
        Subject subject = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createSubject(subject);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSubjectRegister method, of class Controller.
     */
    @Test
    public void testCreateSubjectRegister() throws Exception {
        System.out.println("createSubjectRegister");
        SubjectRegister register = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createSubjectRegister(register);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSubjectToSubjectRegister method, of class Controller.
     */
    @Test
    public void testAddSubjectToSubjectRegister() throws Exception {
        System.out.println("addSubjectToSubjectRegister");
        SubjectRegistered subjectRegistered = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.addSubjectToSubjectRegister(subjectRegistered);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerClassSubjects method, of class Controller.
     */
    @Test
    public void testRegisterClassSubjects() throws Exception {
        System.out.println("registerClassSubjects");
        ClassSubjectRegister register = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.registerClassSubjects(register);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPaper method, of class Controller.
     */
    @Test
    public void testCreatePaper() throws Exception {
        System.out.println("createPaper");
        Paper paper = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createPaper(paper);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerSubjectPaper method, of class Controller.
     */
    @Test
    public void testRegisterSubjectPaper() throws Exception {
        System.out.println("registerSubjectPaper");
        SubjectPaperRegister register = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.registerSubjectPaper(register);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recordStudentResults method, of class Controller.
     */
    @Test
    public void testRecordStudentResults() throws Exception {
        System.out.println("recordStudentResults");
        StudentResult result_2 = null;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.recordStudentResults(result_2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialise method, of class Controller.
     */
    /*@Test
    public void testInitialise() throws Exception {
        System.out.println("initialise");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.initialise();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createDataBase method, of class Controller.
     */
    /*@Test
    public void testCreateDataBase() {
        System.out.println("createDataBase");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createDataBase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connectToDB method, of class Controller.
     */
   /* @Test
    public void testConnectToDB() {
        System.out.println("connectToDB");
        Controller instance = new Controller();
        Connection expResult = null;
        Connection result = instance.connectToDB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableStudent method, of class Controller.
     */
    /*@Test
    public void testCreateTableStudent() {
        System.out.println("createTableStudent");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableStudent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableParent method, of class Controller.
     */
    /*@Test
    public void testCreateTableParent() {
        System.out.println("createTableParent");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableGuardian method, of class Controller.
     */
   /* @Test
    public void testCreateTableGuardian() {
        System.out.println("createTableGuardian");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableGuardian();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableAttendedSchool method, of class Controller.
     */
   /* @Test
    public void testCreateTableAttendedSchool() {
        System.out.println("createTableAttendedSchool");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableAttendedSchool();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableStudentRegister method, of class Controller.
     */
   /* @Test
    public void testCreateTableStudentRegister() {
        System.out.println("createTableStudentRegister");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableStudentRegister();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableStudentClass method, of class Controller.
     */
   /* @Test
    public void testCreateTableStudentClass() {
        System.out.println("createTableStudentClass");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableStudentClass();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableClassStream method, of class Controller.
     */
   /* @Test
    public void testCreateTableClassStream() {
        System.out.println("createTableClassStream");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableClassStream();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableClassStreamRegister method, of class Controller.
     */
    /*@Test
    public void testCreateTableClassStreamRegister() {
        System.out.println("createTableClassStreamRegister");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableClassStreamRegister();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableSubject method, of class Controller.
     */
    /*@Test
    public void testCreateTableSubject() {
        System.out.println("createTableSubject");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableSubject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableSubjectRegister method, of class Controller.
     */
    /*@Test
    public void testCreateTableSubjectRegister() {
        System.out.println("createTableSubjectRegister");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableSubjectRegister();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableSubjectRegistered method, of class Controller.
     */
   /* @Test
    public void testCreateTableSubjectRegistered() {
        System.out.println("createTableSubjectRegistered");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableSubjectRegistered();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableClassSubjectRegister method, of class Controller.
     */
   /* @Test
    public void testCreateTableClassSubjectRegister() {
        System.out.println("createTableClassSubjectRegister");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableClassSubjectRegister();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTablePaper method, of class Controller.
     */
    /*@Test
    public void testCreateTablePaper() {
        System.out.println("createTablePaper");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTablePaper();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableSubjectPaperRegister method, of class Controller.
     */
    /*@Test
    public void testCreateTableSubjectPaperRegister() {
        System.out.println("createTableSubjectPaperRegister");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableSubjectPaperRegister();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableStudentResult method, of class Controller.
     */
   /* @Test
    public void testCreateTableStudentResult() {
        System.out.println("createTableStudentResult");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableStudentResult();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableIdStore method, of class Controller.
     */
    /*@Test
    public void testCreateTableIdStore() {
        System.out.println("createTableIdStore");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.createTableIdStore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateId method, of class Controller.
     */
    @Test
    public void testGenerateId() throws Exception {
        System.out.println("generateId");
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.generateId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecordStatus method, of class Controller.
     */
    @Test
    public void testUpdateRecordStatus() throws Exception {
        System.out.println("updateRecordStatus");
        String id = "";
        String tableName = "";
        String primaryKey = "";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.updateRecordStatus(id, tableName, primaryKey);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class Controller.
     */
    @Test
    public void testDeleteRecord() throws Exception {
        System.out.println("deleteRecord");
        String id = "";
        String tableName = "";
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.deleteRecord(id, tableName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
