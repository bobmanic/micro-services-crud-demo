package com.satyendra.demo.db;

import com.satyendra.demo.api.Student;
import com.satyendra.demo.config.MySQLConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtilImpl implements DatabaseUtil {

    private static final String ROLLNO = "rollno";
    private static final String NAME = "name";

    Connection con;

    public DatabaseUtilImpl(MySQLConfiguration dbConfig) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection(dbConfig.getAddress(), dbConfig.getUsername(), dbConfig.getPassword());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver class not found");
        } catch (SQLException e) {
            System.out.println("Failed to make connection with the Database");
        }
    }

    @Override
    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        try {
            ResultSet r = con.createStatement().executeQuery("select * from student");
            while (r.next()) {
                list.add(new Student(r.getInt(ROLLNO), r.getString(NAME)));
            }
        } catch (SQLException e) {
            System.out.println("Failed to make connection with the Database");
        }
        return list;
    }

    @Override
    public Student getOne(int rollno) {
        try {
            PreparedStatement p = con.prepareStatement("select * from student where rollno = ?");
            p.setInt(1, rollno);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return new Student(r.getInt(ROLLNO), r.getString(NAME));
            }
        } catch (SQLException e) {
            System.out.println("Failed to make connection with the Database");
        }
        return null;
    }

    @Override
    public Boolean create(Student student) {
        try {
            PreparedStatement p = con.prepareStatement("insert into student(rollno, name) value (?,?)");
            p.setInt(1, student.getRollno());
            p.setString(2, student.getName());
            int r = p.executeUpdate();
            if (r > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Failed to make connection with the Database");
        }
        return false;
    }

    @Override
    public Boolean update(Student student) {
        try {
            PreparedStatement p = con.prepareStatement("update student set name = ? where rollno = ?");
            p.setString(1, student.getName());
            p.setInt(2, student.getRollno());
            int r = p.executeUpdate();
            if (r > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Failed to make connection with the Database");
        }
        return false;
    }

    @Override
    public Boolean delete(int rollno) {
        try {
            PreparedStatement p = con.prepareStatement("delete from student where rollno = ?");
            p.setInt(1, rollno);
            int r = p.executeUpdate();
            if (r > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Failed to make connection with the Database");
        }
        return false;
    }

}
