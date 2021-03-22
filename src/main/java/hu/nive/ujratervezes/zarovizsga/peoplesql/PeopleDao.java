package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public String findIpByName(String firstName,String lastName){
            String result;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement prepareStatement = conn.prepareStatement("SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?;")
        ) {
            prepareStatement.setString(1,firstName);
            prepareStatement.setString(2,lastName);
            result= getIpAddress(prepareStatement);
        }catch (SQLException sqlException){
            throw new IllegalStateException("error",sqlException);
        }
        return result;
    }

    private String getIpAddress(PreparedStatement  prepareStatement) {
        String result = null;
        try(ResultSet resultSet = prepareStatement.executeQuery()){
            if(resultSet.next()){
                result=resultSet.getString("ip_address");
            }
        }catch(SQLException sqlException){
            throw new IllegalStateException("error", sqlException);
        }
        return result;
    }


}
