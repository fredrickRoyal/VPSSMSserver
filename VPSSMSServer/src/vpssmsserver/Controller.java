/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vpssmsserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Royal
 */
public class Controller extends UnicastRemoteObject implements ServerStub {

    static String dbPassword;
    static String dbUserName;

    public Controller() throws RemoteException {
        initializeSettings();
        if (initialise() == true) {
            System.out.println("All the tables created");
        } else {
            System.out.println("NOT all tables were created");
        }
    }

    @Override
    public ArrayList<SchoolAttended> getSchoolAttendedList() throws RemoteException {
        ArrayList<SchoolAttended> list = new ArrayList<SchoolAttended>();
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getList = connection.prepareStatement("Select * from AttendedSchool where Status=?");
            getList.setString(1, "Active");
            ResultSet listResult = getList.executeQuery();
            while (listResult.next()) {
                String studentId = listResult.getString("StudentId");
                String schoolId = listResult.getString("SchoolId");
                String name = listResult.getString("Name");
                int duration = listResult.getInt("Duration");
                String UOM = listResult.getString("UOM");
                String qualifaction = listResult.getString("Qualification");
                String reason = listResult.getString("ReasonForChange");
                String status = listResult.getString("Status");
                String student = this.getStudent(studentId);
                if (!student.isEmpty()) {
                    studentId = student;
                }
                list.add(new SchoolAttended(studentId,
                        schoolId,
                        name,
                        duration,
                        UOM,
                        qualifaction,
                        reason,
                        status));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<Guardian> getGuardianList() throws RemoteException {
        ArrayList<Guardian> list = new ArrayList<Guardian>();
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getList = connection.prepareStatement("Select * from Guardian where Status=?");
            getList.setString(1, "Active");
            ResultSet listResult = getList.executeQuery();
            while (listResult.next()) {
                String studentId = listResult.getString("StudentId");
                String guardianId = listResult.getString("GuardianId");
                String firstName = listResult.getString("FirstName");
                String lastName = listResult.getString("LastName");
                String otherName = listResult.getString("OtherName");
                String residence = listResult.getString("Residence");
                String occupation = listResult.getString("Occupation");
                String relationship = listResult.getString("Gender");
                String contact = listResult.getString("Contact");
                String status = listResult.getString("Status");
                String student = this.getStudent(studentId);
                if (!student.isEmpty()) {
                    studentId = student;
                }
                list.add(new Guardian(studentId,
                        guardianId,
                        firstName,
                        lastName,
                        otherName,
                        residence,
                        occupation,
                        relationship,
                        contact,
                        status));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<Parent> getParentList() throws RemoteException {
        ArrayList<Parent> list = new ArrayList<Parent>();
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getList = connection.prepareStatement("Select * from Parent where Status=?");
            getList.setString(1, "Active");
            ResultSet listResult = getList.executeQuery();
            while (listResult.next()) {
                String studentId = listResult.getString("StudentId");
                String parentId = listResult.getString("ParentId");
                String firstName = listResult.getString("FirstName");
                String lastName = listResult.getString("LastName");
                String otherName = listResult.getString("OtherName");
                String residence = listResult.getString("Residence");
                String occupation = listResult.getString("Occupation");
                String relationship = listResult.getString("Relationship");
                String contact = listResult.getString("Contact");
                String status = listResult.getString("Status");
                String student = this.getStudent(studentId);
                if (!student.isEmpty()) {
                    studentId = student;
                }
                list.add(new Parent(studentId,
                        parentId,
                        firstName,
                        lastName,
                        otherName,
                        residence,
                        occupation,
                        relationship,
                        contact,
                        status));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<Student> getStudentList() throws RemoteException {
        ArrayList<Student> list = new ArrayList<Student>();
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getList = connection.prepareStatement("Select * from Student where Status=?");
            getList.setString(1, "Active");
            ResultSet listResult = getList.executeQuery();
            while (listResult.next()) {
                String studentId = listResult.getString("StudentId");
                String firstName = listResult.getString("FirstName");
                String lastName = listResult.getString("LastName");
                String otherName = listResult.getString("OtherName");
                byte[] imageData = listResult.getBytes("Photo");
                String gender = listResult.getString("Gender");
                String birthPlace = listResult.getString("BirthPlace");
                String DOB = listResult.getString("DOB");
                String district = listResult.getString("District");
                String residence = listResult.getString("Residence");
                String nationality = listResult.getString("Nationality");
                String religion = listResult.getString("Religion");
                String disability = listResult.getString("Disability");
                String admissionDate = listResult.getString("AdmissionDate");
                String contact = listResult.getString("Contact");
                String status = listResult.getString("Status");
                list.add(new Student(
                        studentId,
                        firstName,
                        lastName,
                        otherName,
                        imageData,
                        gender,
                        birthPlace,
                        DOB,
                        district,
                        residence,
                        nationality,
                        religion,
                        disability,
                        admissionDate,
                        contact,
                        status));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<StudentRegister> studentClassList() throws RemoteException {
        ArrayList<StudentRegister> list = new ArrayList<StudentRegister>();
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getList = connection.prepareStatement("select * from StudentRegister where Status=?");
            getList.setString(1, "Active");
            ResultSet listResult = getList.executeQuery();
            while (listResult.next()) {
                String registrationId = listResult.getString("RegisterId");
                String student = listResult.getString("StudentId");
                String studentClass = listResult.getString("ClassId");
                String classStream = listResult.getString("StreamId");
                String term = listResult.getString("AcademicTerm");
                String year = listResult.getString("AcademicYear");
                String status = listResult.getString("Status");
                if (!(getStream(classStream) == null)) {
                    classStream = getStream(classStream);
                }
                if (!(getStudentClass(studentClass) == null)) {
                    studentClass = getStudentClass(studentClass);
                }
                if (!(getStudent(student) == null)) {
                    student = getStudent(student);
                }
                list.add(new StudentRegister(registrationId, student, studentClass, classStream, term, year, status));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    private String getStream(String id) {
        String stream = null;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getStream = connection.prepareStatement("select Name from ClassStream where StreamId=?");
            getStream.setString(1, id);
            ResultSet streamResult = getStream.executeQuery();
            if (streamResult.next()) {
                stream = streamResult.getString("Name");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return stream;
    }

    private String getStudentClass(String id) {
        String studentClass = null;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getStudentClass = connection.prepareStatement("select Name from StudentClass where ClassId=?");
            getStudentClass.setString(1, id);
            ResultSet studentClassResult = getStudentClass.executeQuery();
            if (studentClassResult.next()) {
                studentClass = studentClassResult.getString("Name");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return studentClass;
    }

    private String getStudent(String id) {
        String student = null;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getStudent = connection.prepareStatement("select FirstName,LastName,OtherName from Student where StudentId=?");
            getStudent.setString(1, id);
            ResultSet studentResult = getStudent.executeQuery();
            if (studentResult.next()) {
                String firstName = studentResult.getString("FirstName");
                String lastName = studentResult.getString("lastName");
                String otherName = studentResult.getString("OtherName");
                if (otherName.equalsIgnoreCase("none") || otherName.isEmpty()) {
                    otherName = "";
                }
                student = firstName + " " + lastName + " " + otherName;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return student;
    }

    @Override
    public String getStudentId(String Id, String tableName, String field) throws RemoteException {
        Connection connection = null;

        try {
            connection = connectToDB();
            PreparedStatement getId = connection.prepareStatement("select * from " + tableName + " where " + field + "=?");

            getId.setString(1, Id);
            ResultSet idResult = getId.executeQuery();
            if (idResult.next()) {
                System.out.println("Processing getStudentId");
                String id = idResult.getString("StudentId");
                return id;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "ERROR from getStudentId Method");
        }
        return null;
    }

    @Override
    public ArrayList<Paper> getPaperList() throws RemoteException {
        ArrayList<Paper> list = new ArrayList<Paper>();
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getList = connection.prepareStatement("select * from Paper where Status=?");
            getList.setString(1, "Active");
            ResultSet listResult = getList.executeQuery();
            while (listResult.next()) {
                String id = listResult.getString("Id");
                String name = listResult.getString("Name");
                String code = listResult.getString("Code");
                String status = listResult.getString("Status");
                String date = listResult.getString("CreationDate");
                list.add(new Paper(id, name, code, status, date));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<SubjectRegister> getSubjectRegisterList() throws RemoteException {
        ArrayList<SubjectRegister> list = new ArrayList<SubjectRegister>();
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getList = connection.prepareStatement("Select * from SubjectRegister where Status=?");
            getList.setString(1, "Active");
            ResultSet listResult = getList.executeQuery();
            while (listResult.next()) {
                String id = listResult.getString("RegisterId");
                String name = listResult.getString("Name");
                String status = listResult.getString("Status");
                String date = listResult.getString("CreationDate");
                list.add(new SubjectRegister(id, name, status, date));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<Subject> getSubjectList() throws RemoteException {
        ArrayList<Subject> list = new ArrayList<Subject>();
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getList = connection.prepareStatement("Select * from Subject where Status=?");
            getList.setString(1, "Active");
            ResultSet listResult = getList.executeQuery();
            while (listResult.next()) {
                String id = listResult.getString("SubjectId");
                String name = listResult.getString("Name");
                String status = listResult.getString("Status");
                String date = listResult.getString("CreationDate");
                list.add(new Subject(id, name, status, date));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<StudentClass> getStudentClassList() throws RemoteException {
        ArrayList<StudentClass> list = new ArrayList<StudentClass>();
        Connection connection = null;
        try {
            connection = this.connectToDB();
            PreparedStatement getClassList = connection.prepareStatement("select ClassId,Name from StudentClass");
            ResultSet listResult = getClassList.executeQuery();
            while (listResult.next()) {
                String id = listResult.getString("ClassId");
                String name = listResult.getString("Name");
                list.add(new StudentClass(id, name));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<StudentClass> getClassList() throws RemoteException {
        ArrayList<StudentClass> list = new ArrayList<StudentClass>();
        Connection connection = null;
        try {
            connection = this.connectToDB();
            PreparedStatement getClassList = connection.prepareStatement("select * from StudentClass where Status=?");
            getClassList.setString(1, "Active");
            ResultSet listResult = getClassList.executeQuery();
            while (listResult.next()) {
                String id = listResult.getString("ClassId");
                String name = listResult.getString("Name");
                String status = listResult.getString("Status");
                String date = listResult.getString("CreationDate");
                list.add(new StudentClass(id, name, status, date));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<ClassStream> getClassStreamList() throws RemoteException {
        ArrayList<ClassStream> list = new ArrayList<ClassStream>();
        Connection connection = null;
        try {
            connection = this.connectToDB();
            PreparedStatement getStreamList = connection.prepareStatement("select StreamId,Name from ClassStream");
            ResultSet listResult = getStreamList.executeQuery();
            while (listResult.next()) {
                String id = listResult.getString("StreamId");
                String name = listResult.getString("Name");
                list.add(new ClassStream(id, name));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<ClassStream> getStreamList() throws RemoteException {
        ArrayList<ClassStream> list = new ArrayList<ClassStream>();
        Connection connection = null;
        try {
            connection = this.connectToDB();
            PreparedStatement getStreamList = connection.prepareStatement("select * from ClassStream where Status=?");
            getStreamList.setString(1, "Active");
            ResultSet listResult = getStreamList.executeQuery();
            while (listResult.next()) {
                String id = listResult.getString("StreamId");
                String name = listResult.getString("Name");
                String status = listResult.getString("Status");
                String date = listResult.getString("CreationDate");
                list.add(new ClassStream(id, name, status, date));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<ClassStreamRegister> classStreamRegisteredList() throws RemoteException {
        ArrayList<ClassStreamRegister> list = new ArrayList<ClassStreamRegister>();
        Connection connection = null;
        try {
            connection = this.connectToDB();
            PreparedStatement getStreamList = connection.prepareStatement("select * from ClassStreamRegister where Status=?");
            getStreamList.setString(1, "Active");
            ResultSet listResult = getStreamList.executeQuery();
            while (listResult.next()) {
                String registerId = listResult.getString("RegisterId");
                String classId = listResult.getString("ClassId");
                String streamId = listResult.getString("StreamId");
                String term = listResult.getString("Term");
                String year = listResult.getString("AcademicYear");
                String status = listResult.getString("Status");
                String date = listResult.getString("CreationDate");
                String streamName = getStream(streamId);
                String studentClassName = getStudentClass(classId);
                if (streamName != null) {
                    streamId = streamName;
                }
                if (studentClassName != null) {
                    classId = studentClassName;
                }
                list.add(new ClassStreamRegister(registerId, classId, streamId, term, year, status, date));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<SubjectRegistered> getSubjectRegisteredList() throws RemoteException {
        ArrayList<SubjectRegistered> list = new ArrayList<SubjectRegistered>();
        Connection connection = null;
        try {
            connection = this.connectToDB();
            PreparedStatement getList = connection.prepareStatement("select * from SubjectRegistered where Status=?");
            getList.setString(1, "Active");
            ResultSet listResult = getList.executeQuery();
            while (listResult.next()) {
                String id = listResult.getString("Id");
                String registerId = listResult.getString("RegisterId");
                String subjectId = listResult.getString("SubjectId");
                String status = listResult.getString("OfferingStatus");
                String date = listResult.getString("CreationDate");
                String subjectName = getSubject(subjectId);
                String registerName = getSubjectRegister(registerId);
                if (subjectName != null) {
                    subjectId = subjectName;
                }
                if (registerName != null) {
                    registerId = registerName;
                }

                list.add(new SubjectRegistered(id, registerId, subjectId, status, date));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<ClassSubjectRegister> getClassSubjectRegisterList() throws RemoteException {
        ArrayList<ClassSubjectRegister> list = new ArrayList<ClassSubjectRegister>();
        Connection connection = null;
        try {
            connection = this.connectToDB();
            PreparedStatement getList = connection.prepareStatement("select * from ClassSubjectRegister where Status=?");
            getList.setString(1, "Active");
            ResultSet listResult = getList.executeQuery();
            while (listResult.next()) {
                String id = listResult.getString("Id");
                String classId = listResult.getString("ClassId");
                String registerId = listResult.getString("RegisterId");
                String term = listResult.getString("Term");
                String year = listResult.getString("AcademicYear");
                String registerName = getSubjectRegister(registerId);
                String className = getStudentClass(classId);

                if (className != null) {
                    classId = className;
                }
                if (registerName != null) {
                    registerId = registerName;
                }

                list.add(new ClassSubjectRegister(id, classId, registerId, term, year));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<SubjectPaperRegister> getSubjectPaperRegisterist() throws RemoteException {
        ArrayList<SubjectPaperRegister> list = new ArrayList<SubjectPaperRegister>();
        Connection connection = null;
        try {
            connection = this.connectToDB();
            PreparedStatement getList = connection.prepareStatement("select * from SubjectPaperRegister where Status=?");
            getList.setString(1, "Active");
            ResultSet listResult = getList.executeQuery();
            while (listResult.next()) {
                String id = listResult.getString("Id");
                String subjectId = listResult.getString("SubjectId");
                String paperId = listResult.getString("PaperId");
                String status = listResult.getString("OfferingStatus");
                String year = listResult.getString("AcademicYear");
                String paperCode = getPaperCode(paperId);
                String subjectName = getSubject(subjectId);
                String paperName = getPaperName(paperId);

                if (subjectName != null) {
                    subjectId = subjectName;
                }
                if (paperName != null) {
                    paperId = paperName;
                }

                list.add(new SubjectPaperRegister(id, subjectId, paperId, paperCode, status, year));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    @Override
    public ArrayList<StudentResult> getStudentResult() throws RemoteException {
        ArrayList<StudentResult> list = new ArrayList<StudentResult>();
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getList = connection.prepareStatement("select * from StudentResult where Status=?");
            getList.setString(1, "Active");
            ResultSet listResult = getList.executeQuery();
            while (listResult.next()) {
                String id = listResult.getString("Id");
                String studentId = listResult.getString("StudentId");
                String subjectId = listResult.getString("SubjectId");
                String paperId = listResult.getString("PaperId");
                String term = listResult.getString("Term");
                String academicYear = listResult.getString("AcademicYear");
                int holidayWork = listResult.getInt("HolidayWork");
                int BOT = listResult.getInt("BOT");
                int midTerm = listResult.getInt("MidTerm");
                int EOT = listResult.getInt("EOT");
                String status = listResult.getString("Status");

                String student = this.getStudent(studentId);
                String subject = this.getSubject(subjectId);
                String paperName = this.getPaperName(paperId);
                String paperCode = this.getPaperCode(paperId);
                if (student != null) {
                    studentId = student;
                }
                if (subject != null) {
                    subjectId = subject;
                }
                if (paperCode != null) {
                    paperId = paperCode;
                }
                list.add(new StudentResult(id, studentId, subjectId, paperName, paperId, term, academicYear, holidayWork, BOT, midTerm, EOT, status));
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return list;
    }

    private String getPaperCode(String id) {
        String code = null;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getCode = connection.prepareStatement("select Code from Paper where Id=?");
            getCode.setString(1, id);
            ResultSet codeResult = getCode.executeQuery();
            while (codeResult.next()) {
                code = codeResult.getString("Code");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return code;
    }

    private String getPaperName(String id) {
        String name = null;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getName = connection.prepareStatement("select Name from Paper where Id=?");
            getName.setString(1, id);
            ResultSet nameResult = getName.executeQuery();
            while (nameResult.next()) {
                name = nameResult.getString("Name");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return name;
    }

    private String getSubject(String id) {
        String subject = null;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getSubject = connection.prepareStatement("select Name from Subject where SubjectId=?");
            getSubject.setString(1, id);
            ResultSet subjectResult = getSubject.executeQuery();
            while (subjectResult.next()) {
                subject = subjectResult.getString("Name");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return subject;
    }

    private String getSubjectRegister(String id) {
        String subject = null;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement getName = connection.prepareStatement("select Name from SubjectRegister where RegisterId=?");
            getName.setString(1, id);
            ResultSet nameResult = getName.executeQuery();
            while (nameResult.next()) {
                subject = nameResult.getString("Name");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return subject;
    }

    @Override
    public ArrayList<Student> searchStudent() throws RemoteException {
        ArrayList<Student> list = new ArrayList<Student>();
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement getStudent = connection.createStatement();
            ResultSet studentResult = getStudent.executeQuery("Select StudentId,FirstName,LastName,OtherName,Photo from Student");
            while (studentResult.next()) {
                String studentId = studentResult.getString("StudentId");
                String firstName = studentResult.getString("FirstName");
                String lastName = studentResult.getString("LastName");
                String otherName = studentResult.getString("OtherName");
                byte[] imageData = studentResult.getBytes("Photo");
                list.add(new Student(studentId, firstName, lastName, otherName, imageData));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }

        return list;
    }

    @Override
    public ArrayList<Student> searchStudent(String criteria, String searchText) throws RemoteException {
        ArrayList<Student> list = new ArrayList<Student>();
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement getStudent = connection.createStatement();
            ResultSet studentResult = getStudent.executeQuery("Select StudentId,FirstName,LastName,OtherName,Photo from Student");
            while (studentResult.next()) {
                String studentId = studentResult.getString("StudentId");
                String firstName = studentResult.getString("FirstName");
                String lastName = studentResult.getString("LastName");
                String otherName = studentResult.getString("OtherName");
                byte[] imageData = studentResult.getBytes("Photo");


                if (searchText.equalsIgnoreCase("all")) {
                    list.add(new Student(studentId, firstName, lastName, otherName, imageData));
                } else {
                    if (criteria.equalsIgnoreCase("first name")) {
                        if ((firstName.toLowerCase().startsWith(searchText.toLowerCase()))) {
                            list.add(new Student(studentId, firstName, lastName, otherName, imageData));
                        } else {
                            /*Dont add anything*/
                        }

                    } else if (criteria.equalsIgnoreCase("last name")) {
                        if (lastName.toLowerCase().startsWith(searchText.toLowerCase())) {
                            list.add(new Student(studentId, firstName, lastName, otherName, imageData));
                        } else {
                            /*Dont add anything*/
                        }
                    } else if (criteria.equalsIgnoreCase("middle name")) {
                        if (otherName.toLowerCase().startsWith(searchText.toLowerCase())) {
                            list.add(new Student(studentId, firstName, lastName, otherName, imageData));
                        }
                    }


                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }

        return list;
    }

    @Override
    public boolean registerNewStudent(Student student) throws RemoteException {
        boolean registered = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement addStudent = connection.prepareStatement("insert into Student("
                    + "StudentId,"
                    + "FirstName,"
                    + "LastName,"
                    + "OtherName,"
                    + "Photo,"
                    + "Gender,"
                    + "BirthPlace,"
                    + "DOB,"
                    + "District,"
                    + "Residence,"
                    + "Nationality,"
                    + "Religion,"
                    + "Disability,"
                    + "AdmissionDate,"
                    + "Contact,"
                    + "Status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            addStudent.setString(1, student.getStudentId());
            addStudent.setString(2, student.getFirstName());
            addStudent.setString(3, student.getLastName());
            addStudent.setString(4, student.getOtherName());
            addStudent.setBinaryStream(5, new FileInputStream(student.getPhoto()), (int) new File(student.getPhoto()).length());
            addStudent.setString(6, student.getGender());
            addStudent.setString(7, student.getBirthPlace());
            addStudent.setString(8, student.getDOB());
            addStudent.setString(9, student.getDistrict());
            addStudent.setString(10, student.getResidence());
            addStudent.setString(11, student.getNationality());
            addStudent.setString(12, student.getReligion());
            addStudent.setString(13, student.getDisability());
            addStudent.setString(14, student.getAdmissionDate());
            addStudent.setString(15, student.getContact());
            addStudent.setString(16, student.getStatus());
            int addResult = addStudent.executeUpdate();
            if (addResult > 0) {
                registered = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return registered;
    }

    @Override
    public boolean updateStudent(Student student) throws RemoteException {
        Connection connection = null;
        boolean updated = false;
        try {
            connection = connectToDB();
            PreparedStatement updateStudent = null;

            if (student.getPhoto() == null) {
                System.out.println("Photo not changed");
                updateStudent = connection.prepareStatement("update Student set FirstName=?,LastName=?,OtherName=?,Gender=?,BirthPlace=?,DOB=?,District=?,Residence=?,Nationality=?,Religion=?,Disability=?,AdmissionDate=?,Contact=?,Status=? where StudentId=?");
                updateStudent.setString(15, student.getStudentId());
            } else {
                System.out.println("Photo changed");
                updateStudent = connection.prepareStatement("update Student set FirstName=?,LastName=?,OtherName=?,Gender=?,BirthPlace=?,DOB=?,District=?,Residence=?,Nationality=?,Religion=?,Disability=?,AdmissionDate=?,Contact=?,Status=?,Photo=? where StudentId=?");
                updateStudent.setBinaryStream(15, new FileInputStream(student.getPhoto()), (int) new File(student.getPhoto()).length());
                updateStudent.setString(16, student.getStudentId());
            }
            if (updateStudent != null) {
                updateStudent.setString(1, student.getFirstName());
                updateStudent.setString(2, student.getLastName());
                updateStudent.setString(3, student.getOtherName());
                updateStudent.setString(4, student.getGender());
                updateStudent.setString(5, student.getBirthPlace());
                updateStudent.setString(6, student.getDOB());
                updateStudent.setString(7, student.getDistrict());
                updateStudent.setString(8, student.getResidence());
                updateStudent.setString(9, student.getNationality());
                updateStudent.setString(10, student.getReligion());
                updateStudent.setString(11, student.getDisability());
                updateStudent.setString(12, student.getAdmissionDate());
                updateStudent.setString(13, student.getContact());
                updateStudent.setString(14, student.getStatus());
                System.out.println("Executing student Update");
                int addResult = updateStudent.executeUpdate();
                if (addResult > 0) {
                    updated = true;
                }
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n ERROR from updateStudent Mothod");
        } finally {
            this.closeConnection(connection);
        }

        return updated;
    }

    @Override
    public boolean registerParent(Parent parent) throws RemoteException {
        boolean registered = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement addParent = connection.prepareStatement("insert into Parent ("
                    + "StudentId,"
                    + "ParentId,"
                    + "FirstName,"
                    + "LastName,"
                    + "OtherName,"
                    + "Occupation,"
                    + "Residence,"
                    + "Relationship,"
                    + "Contact,"
                    + "Status) values(?,?,?,?,?,?,?,?,?,?)");
            addParent.setString(1, parent.getStudentId());
            addParent.setString(2, parent.getParentId());
            addParent.setString(3, parent.getFirstName());
            addParent.setString(4, parent.getLastName());
            addParent.setString(5, parent.getOtherName());
            addParent.setString(6, parent.getOccupation());
            addParent.setString(7, parent.getResidence());
            addParent.setString(8, parent.getRelationship());
            addParent.setString(9, parent.getContact());
            addParent.setString(10, parent.getStatus());
            int addResult = addParent.executeUpdate();
            if (addResult > 0) {
                registered = true;
            }



        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return registered;
    }

    @Override
    public boolean updateParent(Parent parent) throws RemoteException {
        boolean updated = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement updateParent = connection.prepareStatement("update Parent set StudentId=?,"
                    + "FirstName=?,"
                    + "LastName=?,"
                    + "OtherName=?,"
                    + "Occupation=?,"
                    + "Residence=?,"
                    + "Relationship=?,"
                    + "Contact=?,"
                    + "Status=? where ParentId=?");
            updateParent.setString(1, parent.getStudentId());
            updateParent.setString(2, parent.getFirstName());
            updateParent.setString(3, parent.getLastName());
            updateParent.setString(4, parent.getOtherName());
            updateParent.setString(5, parent.getOccupation());
            updateParent.setString(6, parent.getResidence());
            updateParent.setString(7, parent.getRelationship());
            updateParent.setString(8, parent.getContact());
            updateParent.setString(9, parent.getStatus());
            updateParent.setString(10, parent.getParentId());
            int updateResult = updateParent.executeUpdate();
            if (updateResult > 0) {
                updated = true;
            }



        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return updated;
    }

    @Override
    public boolean registerGuardian(Guardian guardian) throws RemoteException {
        boolean registered = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement addGuardian = connection.prepareStatement("insert into Guardian("
                    + "StudentId,"
                    + "GuardianId,"
                    + "FirstName,"
                    + "LastName,"
                    + "OtherName,"
                    + "Occupation,"
                    + "Residence,"
                    + "Gender,"
                    + "Contact,"
                    + "Status) values(?,?,?,?,?,?,?,?,?,?)");
            addGuardian.setString(1, guardian.getStudentId());
            addGuardian.setString(2, guardian.getGuardianId());
            addGuardian.setString(3, guardian.getFirstName());
            addGuardian.setString(4, guardian.getLastName());
            addGuardian.setString(5, guardian.getOtherName());
            addGuardian.setString(6, guardian.getOccupation());
            addGuardian.setString(7, guardian.getResidence());
            addGuardian.setString(8, guardian.getGender());
            addGuardian.setString(9, guardian.getContact());
            addGuardian.setString(10, guardian.getStatus());
            int addResult = addGuardian.executeUpdate();
            if (addResult > 0) {
                registered = true;
            }



        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return registered;
    }

    @Override
    public boolean updateGuardian(Guardian guardian) throws RemoteException {
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement updateGuardian = connection.prepareStatement("update Guardian set "
                    + "StudentId=?,"
                    + "FirstName=?,"
                    + "LastName=?,"
                    + "OtherName=?,"
                    + "Occupation=?,"
                    + "Residence=?,"
                    + "Gender=?,"
                    + "Contact=?,"
                    + "Status=? where GuardianId=?");
            updateGuardian.setString(1, guardian.getStudentId());
            updateGuardian.setString(2, guardian.getFirstName());
            updateGuardian.setString(3, guardian.getLastName());
            updateGuardian.setString(4, guardian.getOtherName());
            updateGuardian.setString(5, guardian.getOccupation());
            updateGuardian.setString(6, guardian.getResidence());
            updateGuardian.setString(7, guardian.getGender());
            updateGuardian.setString(8, guardian.getContact());
            updateGuardian.setString(9, guardian.getStatus());
            updateGuardian.setString(10, guardian.getGuardianId());
            int updateResult = updateGuardian.executeUpdate();
            if (updateResult > 0) {
                return true;
            }



        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean registerSchoolAttended(SchoolAttended school) throws RemoteException {
        boolean registered = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement addSchool = connection.prepareStatement("insert into AttendedSchool ("
                    + "StudentId,"
                    + "SchoolId,"
                    + "Name,"
                    + "Duration,"
                    + "UOM,"
                    + "Qualification,"
                    + "ReasonForChange,"
                    + "Status) values(?,?,?,?,?,?,?,?)");
            addSchool.setString(1, school.getStudentId());
            addSchool.setString(2, school.getSchoolId());
            addSchool.setString(3, school.getName());
            addSchool.setInt(4, school.getDuration());
            addSchool.setString(5, school.getUOM());
            addSchool.setString(6, school.getQualification());
            addSchool.setString(7, school.getReasonForChange());
            addSchool.setString(8, school.getStatus());
            int addResult = addSchool.executeUpdate();
            if (addResult > 0) {
                registered = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return registered;
    }

    @Override
    public boolean updateSchoolAttended(SchoolAttended school) throws RemoteException {
        boolean updated = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement updateSchool = connection.prepareStatement("update AttendedSchool set "
                    + " StudentId=?,"
                    + "Name=?,"
                    + "Duration=?,"
                    + "UOM=?,"
                    + "Qualification=?,"
                    + "ReasonForChange=?,"
                    + "Status=? where SchoolId=?");
            updateSchool.setString(1, school.getStudentId());
            updateSchool.setString(2, school.getName());
            updateSchool.setInt(3, school.getDuration());
            updateSchool.setString(4, school.getUOM());
            updateSchool.setString(5, school.getQualification());
            updateSchool.setString(6, school.getReasonForChange());
            updateSchool.setString(7, school.getStatus());
            updateSchool.setString(8, school.getSchoolId());
            int updateResult = updateSchool.executeUpdate();
            if (updateResult > 0) {
                updated = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n updateSchoolAttended");
        } finally {
            this.closeConnection(connection);
        }
        return updated;

    }

    @Override
    public boolean createStudentClass(StudentClass studentClass) throws RemoteException {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement createClass = connection.prepareStatement("insert into StudentClass("
                    + "ClassId,"
                    + "Name,"
                    + "Status,"
                    + "CreationDate) values(?,?,?,?)");
            createClass.setString(1, studentClass.getClassId());
            createClass.setString(2, studentClass.getName());
            createClass.setString(3, studentClass.getStatus());
            createClass.setString(4, studentClass.getDate());
            int creatResult = createClass.executeUpdate();
            if (creatResult > 0) {
                created = true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    @Override
    public boolean updateStudentClass(StudentClass studentClass) throws RemoteException {
        boolean updated = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement updateClass = connection.prepareStatement("update StudentClass set "
                    + "Name=?,"
                    + "Status=?,"
                    + "CreationDate=? where ClassId=? ");

            updateClass.setString(1, studentClass.getName());
            updateClass.setString(2, studentClass.getStatus());
            updateClass.setString(3, studentClass.getDate());
            updateClass.setString(4, studentClass.getClassId());
            int updateResult = updateClass.executeUpdate();
            if (updateResult > 0) {
                updated = true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return updated;
    }

    @Override
    public boolean createClassStream(ClassStream stream) throws RemoteException {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement createStream = connection.prepareStatement("insert into ClassStream("
                    + "StreamId,"
                    + "Name,"
                    + "Status,"
                    + "CreationDate) values(?,?,?,?)");
            createStream.setString(1, stream.getStreamId());
            createStream.setString(2, stream.getName());
            createStream.setString(3, stream.getStatus());
            createStream.setString(4, stream.getDate());
            int creatResult = createStream.executeUpdate();
            if (creatResult > 0) {
                created = true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    @Override
    public boolean updateClassStream(ClassStream stream) throws RemoteException {
        boolean updated = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement updateStream = connection.prepareStatement("update ClassStream set "
                    + "Name=?,"
                    + "Status=?,"
                    + "CreationDate=? where StreamId=?");
            updateStream.setString(1, stream.getName());
            updateStream.setString(2, stream.getStatus());
            updateStream.setString(3, stream.getDate());
            updateStream.setString(4, stream.getStreamId());
            int updateResult = updateStream.executeUpdate();
            if (updateResult > 0) {
                updated = true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return updated;
    }

    @Override
    public boolean registerClassStream(ClassStreamRegister register) throws RemoteException {
        boolean registered = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement addRegister = connection.prepareStatement("insert into ClassStreamRegister("
                    + "RegisterId,"
                    + "ClassId,"
                    + "StreamId,"
                    + "Term,"
                    + "AcademicYear,"
                    + "Status,"
                    + "CreationDate) values(?,?,?,?,?,?,?)");
            addRegister.setString(1, register.getRegisterId());
            addRegister.setString(2, register.getClassId());
            addRegister.setString(3, register.getStreamId());
            addRegister.setString(4, register.getTerm());
            addRegister.setString(5, register.getYear());
            addRegister.setString(6, register.getStatus());
            addRegister.setString(7, register.getDate());
            int addResult = addRegister.executeUpdate();
            if (addResult > 0) {
                registered = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return registered;
    }
    @Override
    public boolean updateClassStreamRegister(ClassStreamRegister register) throws RemoteException{
    boolean updated = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement updateRegister = connection.prepareStatement("update ClassStreamRegister set "
                    + "ClassId=?,"
                    + "StreamId=?,"
                    + "Term=?,"
                    + "AcademicYear=?,"
                    + "Status=?,"
                    + "CreationDate=? where RegisterId=?");
            
            updateRegister.setString(1, register.getClassId());
            updateRegister.setString(2, register.getStreamId());
            updateRegister.setString(3, register.getTerm());
            updateRegister.setString(4, register.getYear());
            updateRegister.setString(5, register.getStatus());
            updateRegister.setString(6, register.getDate());
            updateRegister.setString(7, register.getRegisterId());
            int updateResult = updateRegister.executeUpdate();
            if (updateResult > 0) {
                updated = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage()+"\n ERROR from updateClassStream Method");
        } finally {
            this.closeConnection(connection);
        }
        return updated;
    }

    @Override
    public boolean registerOldStudent(StudentRegister register) throws RemoteException {
        boolean registered = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement addRegister = connection.prepareStatement("insert into StudentRegister("
                    + "RegisterId,"
                    + "StudentId,"
                    + "ClassId,"
                    + "StreamId,"
                    + "AcademicTerm,"
                    + "AcademicYear,"
                    + "Status) values(?,?,?,?,?,?,?)");
            addRegister.setString(1, register.getRegisterId());
            addRegister.setString(2, register.getStudentId());
            addRegister.setString(3, register.getClassId());
            addRegister.setString(4, register.getStreamId());
            addRegister.setString(5, register.getAcademicTerm());
            addRegister.setString(6, register.getAcademicYear());
            addRegister.setString(7, register.getStatus());
            int addResult = addRegister.executeUpdate();
            if (addResult > 0) {
                registered = true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return registered;
    }

    @Override
    public boolean updateOldStudent(StudentRegister register) throws RemoteException {
        boolean updated = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement updateRegister = connection.prepareStatement("Update  StudentRegister set "
                    + " StudentId=?,"
                    + "ClassId=?,"
                    + "StreamId=?,"
                    + "AcademicTerm=?,"
                    + "AcademicYear=?,"
                    + "Status=? where RegisterId=?");

            updateRegister.setString(1, register.getStudentId());
            updateRegister.setString(2, register.getClassId());
            updateRegister.setString(3, register.getStreamId());
            updateRegister.setString(4, register.getAcademicTerm());
            updateRegister.setString(5, register.getAcademicYear());
            updateRegister.setString(6, register.getStatus());
            updateRegister.setString(7, register.getRegisterId());
            int updateResult = updateRegister.executeUpdate();
            if (updateResult > 0) {
                updated = true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n ERROR from updateOldStudent");
        } finally {
            this.closeConnection(connection);
        }
        return updated;
    }

    @Override
    public boolean createSubject(Subject subject) throws RemoteException {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement createSubject = connection.prepareStatement("insert into Subject("
                    + "SubjectId,"
                    + "Name,"
                    + "Status,"
                    + "CreationDate) values(?,?,?,?)");
            createSubject.setString(1, subject.getSubjectId());
            createSubject.setString(2, subject.getName());
            createSubject.setString(3, subject.getStatus());
            createSubject.setString(4, subject.getDate());
            int createResult = createSubject.executeUpdate();
            if (createResult > 0) {
                created = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    @Override
    public boolean createSubjectRegister(SubjectRegister register) throws RemoteException {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement createSubject = connection.prepareStatement("insert into SubjectRegister("
                    + "RegisterId,"
                    + "Name,"
                    + "Status,"
                    + "CreationDate) values(?,?,?,?)");
            createSubject.setString(1, register.getRegisterId());
            createSubject.setString(2, register.getName());
            createSubject.setString(3, register.getStatus());
            createSubject.setString(4, register.getDate());
            int createResult = createSubject.executeUpdate();
            if (createResult > 0) {
                created = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    @Override
    public boolean addSubjectToSubjectRegister(SubjectRegistered subjectRegistered) throws RemoteException {
        boolean added = false;
        Connection connection = null;
        try {
            connection = this.connectToDB();
            PreparedStatement addSubject = connection.prepareStatement("insert into SubjectRegistered("
                    + "Id,"
                    + "RegisterId,"
                    + "SubjectId,"
                    + "OfferingStatus,"
                    + "CreationDate,"
                    + "Status) values(?,?,?,?,?,?)");
            addSubject.setString(1, subjectRegistered.getId());
            addSubject.setString(2, subjectRegistered.getRegisterId());
            addSubject.setString(3, subjectRegistered.getSubjectId());
            addSubject.setString(4, subjectRegistered.getStatus());
            addSubject.setString(5, subjectRegistered.getDate());
            addSubject.setString(6, "Active");
            int addResult = addSubject.executeUpdate();
            if (addResult > 0) {
                added = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            this.closeConnection(connection);
        }
        return added;
    }

    @Override
    public boolean registerClassSubjects(ClassSubjectRegister register) throws RemoteException {
        boolean added = false;
        Connection connection = null;
        try {
            connection = this.connectToDB();
            PreparedStatement addSubject = connection.prepareStatement("insert into ClassSubjectRegister("
                    + "Id,"
                    + "ClassId,"
                    + "RegisterId,"
                    + "Term,"
                    + "AcademicYear,"
                    + "Status) values(?,?,?,?,?,?)");
            addSubject.setString(1, register.getId());
            addSubject.setString(2, register.getClassId());
            addSubject.setString(3, register.getRegisterId());
            addSubject.setString(4, register.getTerm());
            addSubject.setString(5, register.getAcademicYear());
            addSubject.setString(6, "Active");
            int addResult = addSubject.executeUpdate();
            if (addResult > 0) {
                added = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            this.closeConnection(connection);
        }
        return added;
    }

    @Override
    public boolean createPaper(Paper paper) throws RemoteException {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement createPaper = connection.prepareStatement("insert into Paper("
                    + "Id,"
                    + "Name,"
                    + "Code,"
                    + "Status,"
                    + "CreationDate) values(?,?,?,?,?)");
            createPaper.setString(1, paper.getId());
            createPaper.setString(2, paper.getName());
            createPaper.setString(3, paper.getCode());
            createPaper.setString(4, paper.getStatus());
            createPaper.setString(5, paper.getDate());
            int createResult = createPaper.executeUpdate();
            if (createResult > 0) {
                created = true;
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    @Override
    public boolean registerSubjectPaper(SubjectPaperRegister register) throws RemoteException {
        boolean added = false;
        Connection connection = null;
        try {
            connection = this.connectToDB();
            PreparedStatement addPaper = connection.prepareStatement("insert into SubjectPaperRegister("
                    + "Id,"
                    + "SubjectId,"
                    + "PaperId,"
                    + "OfferingStatus,"
                    + "AcademicYear,"
                    + "Status) values(?,?,?,?,?,?)");
            addPaper.setString(1, register.getId());
            addPaper.setString(2, register.getSubjectId());
            addPaper.setString(3, register.getPaperId());
            addPaper.setString(4, register.getStatus());
            addPaper.setString(5, register.getAcademicYear());
            addPaper.setString(6, "Active");
            int addResult = addPaper.executeUpdate();
            if (addResult > 0) {
                added = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            this.closeConnection(connection);
        }
        return added;
    }

    @Override
    public boolean recordStudentResults(StudentResult result) throws RemoteException {
        boolean recorded = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement recordResult = connection.prepareStatement("insert into StudentResult("
                    + "Id,"
                    + "StudentId,"
                    + "SubjectId,"
                    + "PaperId,"
                    + "Term,"
                    + "AcademicYear,"
                    + "HolidayWork,"
                    + "BOT,"
                    + "MidTerm,"
                    + "EOT,"
                    + "Status) values(?,?,?,?,?,?,?,?,?,?,?)");
            recordResult.setString(1, result.getId());
            recordResult.setString(2, result.getStudentId());
            recordResult.setString(3, result.getSubjectId());
            recordResult.setString(4, result.getPaperId());
            recordResult.setString(5, result.getTerm());
            recordResult.setString(6, result.getAcademicYear());
            recordResult.setInt(7, result.getHolidayWork());
            recordResult.setInt(8, result.getBOT());
            recordResult.setInt(9, result.getMidTerm());
            recordResult.setInt(10, result.getEOT());
            recordResult.setString(11, result.getStatus());
            int recording = recordResult.executeUpdate();
            if (recording > 0) {
                recorded = true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return recorded;
    }

    @Override
    public final boolean initialise() throws RemoteException {
        boolean initialised = false;
        try {
            /* createDataBase();
            createTableStudent();
            createTableParent() ;
            createTableGuardian();
            createTableAttendedSchool();
            createTableStudentRegister();
            createTableStudentClass();
            createTableClassStream();
            createTableClassStreamRegister();
            createTableSubject();
            createTableSubjectRegister();
            createTableSubjectRegistered();
            createTableClassSubjectRegister();
            createTablePaper();
            createTableSubjectPaperRegister();
            createTableStudentResult(); */
            createTableSubjectPaperRegister();
            if (createDataBase() == true
                    && createTableIdStore() == true
                    && createTableStudent() == true
                    && createTableParent() == true
                    && createTableGuardian() == true
                    && createTableAttendedSchool() == true
                    && createTableStudentRegister() == true
                    && createTableStudentClass() == true
                    && createTableClassStream() == true
                    && createTableClassStreamRegister() == true
                    && createTableSubject() == true
                    && createTableSubjectRegister() == true
                    && createTableSubjectRegistered() == true
                    && createTableClassSubjectRegister() == true
                    && createTablePaper() == true
                    && createTableSubjectPaperRegister() == true
                    && createTableStudentResult() == true) {

                initialised = true;

            } else {
                //System.out.println("NOT All tables Created");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return initialised;
    }

    public boolean createDataBase() {
        boolean created = false;
        Connection connect = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String host = "localhost";
            String db = "VPSSMS";
            String user = Controller.dbUserName;
            String passWord = null;
            if (dbPassword.equalsIgnoreCase("no")) {
                passWord = "";
            } else {
                passWord = dbPassword;
            }
            connect = DriverManager.getConnection("jdbc:mysql://" + host + "/?user=" + user + "&password=" + passWord + "");
            Statement createDataBase = connect.createStatement();
            int createResult = createDataBase.executeUpdate("create database if not exists " + db + "");
            if (createResult > 0) {
                created = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "Error 1 from create Database Method");
        }

        /*try {
        String databaseCreated = new DerbyConnection().createDB();
        if (databaseCreated.equalsIgnoreCase("true")) {
        updated = true;
        }
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }*/
        return created;
    }

    public Connection connectToDB() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String host = "localhost";
            String port = "3306";
            String db = "VPSSMS";
            String user = dbUserName;
            String passWord = "";
            if (dbPassword.equalsIgnoreCase("no")) {
            } else {
                passWord = dbPassword;
            }
            String mysqlURL = "jdbc:mysql://" + host + ":" + port + "/" + db;
            connection = DriverManager.getConnection(mysqlURL, user, passWord);
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " ERROR 2 from the ConnetToDB method");
        }
        return connection;
    }

    public boolean createTableStudent() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table Student("
                    + "StudentId varchar(25) not null,"
                    + "FirstName varchar(30) not null,"
                    + "LastName varchar(30) not null,"
                    + "OtherName varchar(30) not null,"
                    + "Photo LONGBLOB not null,"
                    + "Gender varchar(25) not null,"
                    + "BirthPlace varchar(100) not null,"
                    + "DOB varchar(25) not null,"
                    + "District varchar(25) not null,"
                    + "Residence varchar(25) not null,"
                    + "Nationality varchar(25) not null,"
                    + "Religion varchar(25) not null,"
                    + "Disability varchar(100) not null,"
                    + "AdmissionDate varchar(25) not null,"
                    + "Contact varchar(25) not null,"
                    + "Status varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table Student created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableParent() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table Parent("
                    + "StudentId varchar(25) not null,"
                    + "ParentId varchar(25) not null,"
                    + "FirstName varchar(30) not null,"
                    + "LastName varchar(30) not null,"
                    + "OtherName varchar(30) not null,"
                    + "Occupation varchar(200) not null,"
                    + "Residence varchar(25) not null,"
                    + "Relationship varchar(25) not null,"
                    + "Contact varchar(25) not null,"
                    + "Status varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table Parent Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableGuardian() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table Guardian("
                    + "StudentId varchar(25) not null,"
                    + "GuardianId varchar(25) not null,"
                    + "FirstName varchar(30) not null,"
                    + "LastName varchar(30) not null,"
                    + "OtherName varchar(30) not null,"
                    + "Occupation varchar(200) not null,"
                    + "Residence varchar(25) not null,"
                    + "Gender varchar(25) not null,"
                    + "Contact varchar(25) not null,"
                    + "Status varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table Guardian Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableAttendedSchool() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table AttendedSchool("
                    + "StudentId varchar(25) not null,"
                    + "SchoolId varchar(25) not null,"
                    + "Name varchar(400) not null,"
                    + "Duration int not null,"
                    + "UOM varchar(25) not null,"
                    + "Qualification varchar(200) not null,"
                    + "ReasonForChange varchar(400) not null,"
                    + "Status varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table Schools Attended Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableStudentRegister() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table StudentRegister("
                    + "RegisterId varchar(25) not null,"
                    + "StudentId varchar(25) not null,"
                    + "ClassId varchar(25) not null,"
                    + "StreamId varchar(25) not null,"
                    + "AcademicTerm varchar(25) not null,"
                    + "AcademicYear varchar(25) not null,"
                    + "Status varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table Student Register Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableStudentClass() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table StudentClass("
                    + "ClassId varchar(25) not null,"
                    + "Name varchar(25) not null,"
                    + "Status varchar(25) not null,"
                    + "CreationDate varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table Student Class Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableClassStream() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table ClassStream("
                    + "StreamId varchar(25) not null,"
                    + "Name varchar(25) not null,"
                    + "Status varchar(25) not null,"
                    + "CreationDate varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table Class Stream Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableClassStreamRegister() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table ClassStreamRegister("
                    + "RegisterId varchar(25) not null,"
                    + "ClassId varchar(25) not null,"
                    + "StreamId varchar(25) not null,"
                    + "Term varchar(25) not null,"
                    + "AcademicYear varchar(25) not null,"
                    + "Status varchar(25) not null,"
                    + "CreationDate varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table Class Stream Register Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableSubject() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table Subject("
                    + "SubjectId varchar(25) not null,"
                    + "Name varchar(50) not null,"
                    + "Status varchar(25) not null,"
                    + "CreationDate varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table Subject Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableSubjectRegister() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table SubjectRegister("
                    + "RegisterId varchar(25) not null,"
                    + "Name varchar(50) not null,"
                    + "Status varchar(25) not null,"
                    + "CreationDate varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table SubjectRegister Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableSubjectRegistered() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table SubjectRegistered("
                    + "Id varchar(25) not null,"
                    + "RegisterId varchar(25) not null,"
                    + "SubjectId varchar(50) not null,"
                    + "OfferingStatus varchar(25) not null,"
                    + "CreationDate varchar(25) not null,"
                    + "Status varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table SubjectRegistered Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableClassSubjectRegister() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table ClassSubjectRegister("
                    + "Id varchar(25) not null,"
                    + "ClassId varchar(25) not null,"
                    + "RegisterId varchar(25) not null,"
                    + "Term varchar(25) not null,"
                    + "AcademicYear varchar(25) not null,"
                    + "Status varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table SubjectRegistered Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTablePaper() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table Paper("
                    + "Id varchar(25) not null,"
                    + "Name varchar(25) not null,"
                    + "Code varchar(25) not null,"
                    + "Status varchar(25) not null,"
                    + "CreationDate varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table Paper Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableSubjectPaperRegister() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table SubjectPaperRegister("
                    + "Id varchar(25) not null,"
                    + "SubjectId varchar(25) not null,"
                    + "PaperId varchar(25) not null,"
                    + "OfferingStatus varchar(25) not null,"
                    + "AcademicYear varchar(25) not null,"
                    + "Status varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table Paper Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableStudentResult() {
        boolean created = false;
        Connection connection = null;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create Table StudentResult("
                    + "Id varchar(25) not null,"
                    + "StudentId varchar(25) not null,"
                    + "SubjectId varchar(25) not null,"
                    + "PaperId varchar(25) not null,"
                    + "Term varchar(25) not null,"
                    + "AcademicYear varchar(25) not null,"
                    + "HolidayWork int not null,"
                    + "BOT int not null,"
                    + "MidTerm int not null,"
                    + "EOT int not null,"
                    + "Status varchar(25) not null)");
            if (createResult == 0) {
                created = true;
                System.out.println("Table Paper Created");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    public boolean createTableIdStore() {
        Connection connection = null;
        boolean created = false;
        try {
            connection = connectToDB();
            Statement createTable = connection.createStatement();
            int createResult = createTable.executeUpdate("create table IdStore(ID int not null auto_increment, primary key(ID))");
            if (createResult == 0) {
                created = true;
                System.out.println("Table IdStore created");

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return created;
    }

    @Override
    public String generateId() throws RemoteException {
        Connection connection = null;
        int idCount = 0;
        String id = null;
        try {
            connection = connectToDB();
            Statement insertData = connection.createStatement();
            int inserResult = insertData.executeUpdate("insert into IdStore(ID) values (null)");
            if (inserResult > 0) {
                ResultSet getId = insertData.executeQuery("select * from IdStore");
                while (getId.next()) {
                    idCount++;
                }
                long n = idCount;
                int digits = 8;
                char[] zeros = new char[digits];
                Arrays.fill(zeros, '0');
                DecimalFormat df = new DecimalFormat(String.valueOf(zeros));
                id = df.format(n);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return id;
    }

    @Override
    public boolean updateRecordStatus(String id, String tableName, String primaryKey) throws RemoteException {
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement update = connection.prepareStatement("update " + tableName + " set Status=? where " + primaryKey + "=?");
            update.setString(1, "inactive");
            update.setString(2, id);
            int updateResult = update.executeUpdate();
            if (updateResult > 0) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean deleteRecord(String id, String tableName) throws RemoteException {
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement delete = connection.prepareStatement("delete from " + tableName + " where Id=?");
            delete.setString(1, id);
            int deleteResult = delete.executeUpdate();
            if (deleteResult > 0) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean hasReference(String columnId, String columnName, String tableName) throws RemoteException {
        Connection connection = null;
        try {
            connection = connectToDB();
            PreparedStatement checkForReference = connection.prepareStatement("select " + columnName + " from " + tableName + " where " + columnName + "=?");
            checkForReference.setString(1, columnId);
            ResultSet checkForReferenceResult = checkForReference.executeQuery();
            if (checkForReferenceResult.next()) {
                return true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.closeConnection(connection);
        }
        return false;
    }

    public void setInitialDBSettings(File file) throws Exception {
        if (!file.exists()) {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("root");
            printWriter.append("no");
            printWriter.close();
        }
    }

    public void getInitialDBSettings(String file, ArrayList<String> list) throws Exception {
        FileReader fileReader = new FileReader(file);
        BufferedReader read = new BufferedReader(fileReader);
        while (true) {
            String line = read.readLine();
            if (line == null) {
                break;
            } else {
                list.add(line);
            }

        }
        dbUserName = list.get(0);
        dbPassword = list.get(1);
    }

    public String getfileDirectory() {
        String fileDirectory = null;
        try {
            fileDirectory = System.getProperty("user.home") + "\\.vpssmsServerConfig";
            File makeDirectory = new File(fileDirectory);
            if (makeDirectory.mkdir()) {
                System.out.println("Folder .vpssmsConfig Created");

            } else {
                System.out.println("Folder .vpssmsConfig already Exists");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return fileDirectory;
    }

    public final void initializeSettings() {
        try {
            ArrayList<String> list = new ArrayList<String>();
            File file = null;
            String fileDirectory = this.getfileDirectory();
            file = new File(fileDirectory + "\\db.txt");
            setInitialDBSettings(file);
            getInitialDBSettings(fileDirectory + "\\db.txt", list);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n ERROR from closeConnection method");
        }
    }

    @Override
    public byte[] getImageData(String id) throws RemoteException {
        Connection connection = null;
        try {
            connection = this.connectToDB();
            PreparedStatement getImage = connection.prepareStatement("select Photo from Student where StudentId=?");
            getImage.setString(1, id);
            ResultSet imageResult = getImage.executeQuery();
            if (imageResult.next()) {
                byte[] imageData = imageResult.getBytes("Photo");
                return imageData;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n ERROR from getImageData");
        } finally {
            this.closeConnection(connection);
        }
        return null;
    }
}
