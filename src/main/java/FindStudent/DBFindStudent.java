package FindStudent;

import AbstractClasses.GetConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DBFindStudent extends GetConnection {

    protected ArrayList<FindStudent> SelectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<FindStudent> FindStudentListAll = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Students_Email, Students_name, Students_surname, Students_Major, Students_Group_number, Academic_Year, Students_Status from Student");

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                FindStudent findStudentByAll = new FindStudent();
                findStudentByAll.setStudent_Email(resultSet.getString("Students_Email"));
                findStudentByAll.setStudent_Name(resultSet.getString("Students_name"));
                findStudentByAll.setStudent_Surname(resultSet.getString("Students_surname"));
                findStudentByAll.setStudent_Major(resultSet.getString("Students_Major"));
                findStudentByAll.setStudent_Group(resultSet.getString("Students_Group_number"));
                findStudentByAll.setAcademicYear(resultSet.getInt("Academic_Year"));
                findStudentByAll.setStudent_Status(resultSet.getString("Students_Status"));

                FindStudentListAll.add(findStudentByAll);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return FindStudentListAll;

    }

    protected ArrayList<FindStudent> FindStudentByNameAndSurname(String Name, String Surname){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<FindStudent> FindStudentListByNameAndSurname = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Students_Email, Students_name, Students_surname, Students_Major, Students_Group_number, Academic_Year, Students_Status from Student where Students_name = ? and Students_surname = ?;");
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, Surname);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                FindStudent findStudentByNameAndSurname = new FindStudent();
                findStudentByNameAndSurname.setStudent_Email(resultSet.getString("Students_Email"));
                findStudentByNameAndSurname.setStudent_Name(resultSet.getString("Students_name"));
                findStudentByNameAndSurname.setStudent_Surname(resultSet.getString("Students_surname"));
                findStudentByNameAndSurname.setStudent_Major(resultSet.getString("Students_Major"));
                findStudentByNameAndSurname.setStudent_Group(resultSet.getString("Students_Group_number"));
                findStudentByNameAndSurname.setAcademicYear(resultSet.getInt("Academic_Year"));
                findStudentByNameAndSurname.setStudent_Status(resultSet.getString("Students_Status"));

                FindStudentListByNameAndSurname.add(findStudentByNameAndSurname);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return FindStudentListByNameAndSurname;

    }
    protected ArrayList<FindStudent> FindStudentBySurnameAndName(String Surname, String Name){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<FindStudent> FindStudentListBySurnameAndName = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Students_Email, Students_name, Students_surname, Students_Major, Students_Group_number, Academic_Year, Students_Status from Student where Students_surname = ? and Students_name = ?;");
            preparedStatement.setString(1, Surname);
            preparedStatement.setString(2, Name);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                FindStudent findStudentBySurnameAndName = new FindStudent();
                findStudentBySurnameAndName.setStudent_Email(resultSet.getString("Students_Email"));
                findStudentBySurnameAndName.setStudent_Name(resultSet.getString("Students_name"));
                findStudentBySurnameAndName.setStudent_Surname(resultSet.getString("Students_surname"));
                findStudentBySurnameAndName.setStudent_Major(resultSet.getString("Students_Major"));
                findStudentBySurnameAndName.setStudent_Group(resultSet.getString("Students_Group_number"));
                findStudentBySurnameAndName.setAcademicYear(resultSet.getInt("Academic_Year"));
                findStudentBySurnameAndName.setStudent_Status(resultSet.getString("Students_Status"));

                FindStudentListBySurnameAndName.add(findStudentBySurnameAndName);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return FindStudentListBySurnameAndName;

    }
    protected ArrayList<FindStudent> FindStudentByNameOrSurname(String NameOrSurname){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<FindStudent> FindStudentListByNameOrSurname = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Students_Email, Students_name, Students_surname, Students_Major, Students_Group_number, Academic_Year, Students_Status from Student where Students_surname =? or Students_name =?;");
            preparedStatement.setString(1, NameOrSurname);
            preparedStatement.setString(2, NameOrSurname);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                FindStudent findStudentByNameOrSurname = new FindStudent();
                findStudentByNameOrSurname.setStudent_Email(resultSet.getString("Students_Email"));
                findStudentByNameOrSurname.setStudent_Name(resultSet.getString("Students_name"));
                findStudentByNameOrSurname.setStudent_Surname(resultSet.getString("Students_surname"));
                findStudentByNameOrSurname.setStudent_Major(resultSet.getString("Students_Major"));
                findStudentByNameOrSurname.setStudent_Group(resultSet.getString("Students_Group_number"));
                findStudentByNameOrSurname.setAcademicYear(resultSet.getInt("Academic_Year"));
                findStudentByNameOrSurname.setStudent_Status(resultSet.getString("Students_Status"));

                FindStudentListByNameOrSurname.add(findStudentByNameOrSurname);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return FindStudentListByNameOrSurname;

    }

    protected ArrayList<FindStudent> FindStudentByEmail(String Email){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<FindStudent> FindStudentListByEmail = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Students_Email, Students_name, Students_surname, Students_Major, Students_Group_number, Academic_Year, Students_Status from Student where Students_Email = ?");
            preparedStatement.setString(1, Email);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                FindStudent findStudentByEmail = new FindStudent();
                findStudentByEmail.setStudent_Email(resultSet.getString("Students_Email"));
                findStudentByEmail.setStudent_Name(resultSet.getString("Students_name"));
                findStudentByEmail.setStudent_Surname(resultSet.getString("Students_surname"));
                findStudentByEmail.setStudent_Major(resultSet.getString("Students_Major"));
                findStudentByEmail.setStudent_Group(resultSet.getString("Students_Group_number"));
                findStudentByEmail.setAcademicYear(resultSet.getInt("Academic_Year"));
                findStudentByEmail.setStudent_Status(resultSet.getString("Students_Status"));

                FindStudentListByEmail.add(findStudentByEmail);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return FindStudentListByEmail;

    }

    protected ArrayList<FindStudent> SelectAllMajors(){

        Connection connection = null;
        ArrayList<FindStudent> AllMajorsList = new ArrayList<>();

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select DISTINCT Students_Major from Student");



            while (resultSet.next()){
                FindStudent SelectAllMajorList = new FindStudent();
                SelectAllMajorList.setStudent_Major(resultSet.getString("Students_Major"));

                AllMajorsList.add(SelectAllMajorList);

            }
            statement.close();
            resultSet.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return AllMajorsList;

    }

    protected Set<FindStudent> SelectAllGroups(){

        Connection connection = null;
        Set<FindStudent> allGroupsList = new HashSet<>();

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT distinct Students_Group_number from student");


            while (resultSet.next()){
                FindStudent selectAllGroups = new FindStudent();
                selectAllGroups.setStudent_Group(resultSet.getString("Students_Group_number"));
                allGroupsList.add(selectAllGroups);

            }
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return allGroupsList;

    }

    protected Set<FindStudent> SelectAllAcademicYears(){

        Connection connection = null;
        Set<FindStudent> allAcademicYearList = new HashSet<>();

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT distinct Academic_Year from student");


            while (resultSet.next()){
                FindStudent selectAllAcademicYears = new FindStudent();
                selectAllAcademicYears.setAcademicYear(resultSet.getInt("Academic_Year"));
                allAcademicYearList.add(selectAllAcademicYears);

            }
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return allAcademicYearList;

    }
    protected ArrayList<FindStudent> FindStudentByMajor(String Major){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<FindStudent> FindStudentListByMajor = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Students_Email, Students_name, Students_surname, Students_Major, Students_Group_number, Academic_Year, Students_Status from Student where Students_Major = ? ;");
            preparedStatement.setString(1, Major);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                FindStudent findStudentByMajor = new FindStudent();
                findStudentByMajor.setStudent_Email(resultSet.getString("Students_Email"));
                findStudentByMajor.setStudent_Name(resultSet.getString("Students_name"));
                findStudentByMajor.setStudent_Surname(resultSet.getString("Students_surname"));
                findStudentByMajor.setStudent_Major(resultSet.getString("Students_Major"));
                findStudentByMajor.setStudent_Group(resultSet.getString("Students_Group_number"));
                findStudentByMajor.setAcademicYear(resultSet.getInt("Academic_Year"));
                findStudentByMajor.setStudent_Status(resultSet.getString("Students_Status"));

                FindStudentListByMajor.add(findStudentByMajor);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return FindStudentListByMajor;

    }

    protected ArrayList<FindStudent> FindStudentByMajorAndYear(String Major, String Year){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<FindStudent> FindStudentListByMajorAndYear = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Students_Email, Students_name, Students_surname, Students_Major, Students_Group_number, Academic_Year, Students_Status from Student where Students_Major = ? and Academic_Year =?;");
            preparedStatement.setString(1, Major);
            preparedStatement.setInt(2, Integer.parseInt(Year));

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                FindStudent findStudentByMajorAndYear = new FindStudent();
                findStudentByMajorAndYear.setStudent_Email(resultSet.getString("Students_Email"));
                findStudentByMajorAndYear.setStudent_Name(resultSet.getString("Students_name"));
                findStudentByMajorAndYear.setStudent_Surname(resultSet.getString("Students_surname"));
                findStudentByMajorAndYear.setStudent_Major(resultSet.getString("Students_Major"));
                findStudentByMajorAndYear.setStudent_Group(resultSet.getString("Students_Group_number"));
                findStudentByMajorAndYear.setAcademicYear(resultSet.getInt("Academic_Year"));
                findStudentByMajorAndYear.setStudent_Status(resultSet.getString("Students_Status"));

                FindStudentListByMajorAndYear.add(findStudentByMajorAndYear);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return FindStudentListByMajorAndYear;

    }

    protected ArrayList<FindStudent> FindStudentByYear(String Year){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<FindStudent> FindStudentListByYear = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Students_Email, Students_name, Students_surname, Students_Major, Students_Group_number, Academic_Year, Students_Status from Student where  Academic_Year =?;");
            preparedStatement.setInt(1, Integer.parseInt(Year));

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                FindStudent findStudentByYear = new FindStudent();
                findStudentByYear.setStudent_Email(resultSet.getString("Students_Email"));
                findStudentByYear.setStudent_Name(resultSet.getString("Students_name"));
                findStudentByYear.setStudent_Surname(resultSet.getString("Students_surname"));
                findStudentByYear.setStudent_Major(resultSet.getString("Students_Major"));
                findStudentByYear.setStudent_Group(resultSet.getString("Students_Group_number"));
                findStudentByYear.setAcademicYear(resultSet.getInt("Academic_Year"));
                findStudentByYear.setStudent_Status(resultSet.getString("Students_Status"));

                FindStudentListByYear.add(findStudentByYear);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return FindStudentListByYear;

    }

    protected ArrayList<FindStudent> FindStudentByGroup(String Group){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<FindStudent> FindStudentListByGroup = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Students_Email, Students_name, Students_surname, Students_Major, Students_Group_number, Academic_Year, Students_Status from Student where Students_Group_number =?;");
            preparedStatement.setString(1, Group);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                FindStudent findStudentByGroup = new FindStudent();
                findStudentByGroup.setStudent_Email(resultSet.getString("Students_Email"));
                findStudentByGroup.setStudent_Name(resultSet.getString("Students_name"));
                findStudentByGroup.setStudent_Surname(resultSet.getString("Students_surname"));
                findStudentByGroup.setStudent_Major(resultSet.getString("Students_Major"));
                findStudentByGroup.setStudent_Group(resultSet.getString("Students_Group_number"));
                findStudentByGroup.setAcademicYear(resultSet.getInt("Academic_Year"));
                findStudentByGroup.setStudent_Status(resultSet.getString("Students_Status"));

                FindStudentListByGroup .add(findStudentByGroup);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return FindStudentListByGroup ;

    }

}
