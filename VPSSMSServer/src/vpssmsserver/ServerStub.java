/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vpssmsserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Royal
 */
public interface ServerStub extends Remote {

    public boolean initialise() throws RemoteException;

    public String generateId() throws RemoteException;

    public boolean registerNewStudent(Student student) throws RemoteException;

    public boolean updateStudent(Student student) throws RemoteException;

    public boolean registerParent(Parent parent) throws RemoteException;

    public boolean updateParent(Parent parent) throws RemoteException;

    public boolean registerGuardian(Guardian guardian) throws RemoteException;
    public boolean updateGuardian(Guardian guardian) throws RemoteException;

    public boolean registerSchoolAttended(SchoolAttended school) throws RemoteException;

    public boolean registerClassStream(ClassStreamRegister register) throws RemoteException;

    public boolean registerOldStudent(StudentRegister register) throws RemoteException;

    public boolean createStudentClass(StudentClass studentClass) throws RemoteException;

    public boolean createClassStream(ClassStream stream) throws RemoteException;

    public boolean createSubject(Subject subject) throws RemoteException;

    public boolean createSubjectRegister(SubjectRegister register) throws RemoteException;

    public boolean addSubjectToSubjectRegister(SubjectRegistered subjectRegistered) throws RemoteException;

    public boolean registerClassSubjects(ClassSubjectRegister register) throws RemoteException;

    public boolean createPaper(Paper paper) throws RemoteException;

    public boolean registerSubjectPaper(SubjectPaperRegister register) throws RemoteException;

    public boolean recordStudentResults(StudentResult result) throws RemoteException;

    public ArrayList<Student> searchStudent(String criteria, String searchText) throws RemoteException;

    public ArrayList<Student> searchStudent() throws RemoteException;

    public ArrayList<StudentClass> getStudentClassList() throws RemoteException;

    public ArrayList<StudentClass> getClassList() throws RemoteException;

    public ArrayList<ClassStream> getClassStreamList() throws RemoteException;

    public ArrayList<ClassStream> getStreamList() throws RemoteException;

    public ArrayList<ClassStreamRegister> classStreamRegisteredList() throws RemoteException;

    public ArrayList<SubjectRegister> getSubjectRegisterList() throws RemoteException;

    public ArrayList<Subject> getSubjectList() throws RemoteException;

    public ArrayList<Paper> getPaperList() throws RemoteException;

    public ArrayList<StudentRegister> studentClassList() throws RemoteException;

    public ArrayList<Student> getStudentList() throws RemoteException;

    public ArrayList<Parent> getParentList() throws RemoteException;

    public ArrayList<Guardian> getGuardianList() throws RemoteException;

    public ArrayList<SchoolAttended> getSchoolAttendedList() throws RemoteException;

    public ArrayList<SubjectRegistered> getSubjectRegisteredList() throws RemoteException;

    public ArrayList<ClassSubjectRegister> getClassSubjectRegisterList() throws RemoteException;

    public ArrayList<SubjectPaperRegister> getSubjectPaperRegisterist() throws RemoteException;

    public ArrayList<StudentResult> getStudentResult() throws RemoteException;
    public String getStudentId(String Id,String table,String field)throws RemoteException;

    public boolean updateRecordStatus(String id, String tableName, String primaryKey) throws RemoteException;

    public boolean deleteRecord(String id, String tableName) throws RemoteException;

    public boolean hasReference(String columnId, String columnName, String tableName) throws RemoteException;

    public byte[] getImageData(String id) throws RemoteException;
}
