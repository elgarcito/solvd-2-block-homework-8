package com.solvd.essay.persistence.jdbcImpl;

import com.solvd.essay.persistence.ConnectionPool;
import com.solvd.essay.persistence.InterfaceGenerericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstracDao<T> implements InterfaceGenerericDao<T> {

    private static final Logger LOGGER = LogManager.getLogger(AbstracDao.class);

    private T newClass;


    @Override
    public void create(T thingToCreate) throws SQLException {
        Connection conn1;
        try {
            conn1 = ConnectionPool.getConnection();
            conn1.setAutoCommit(false);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        try {
            if (thingToCreate == null) {
                throw new RuntimeException("No null entity can be added");
            }
            //String query="insert into "+getTableName()+"("+getTableFields()+")" +" values ("+getThingFields(thingToCreate)+")";
            String createQuery= getCreateQuery(); // only has the queries with ??? return string
            PreparedStatement ps =conn1.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            setQueryStatements(ps,thingToCreate);// do the setString,date, etc for each value return void
            //ps.setString(1, getThingFields(thingToCreate));
            int number= ps.executeUpdate();
            LOGGER.info("Object was added to database successfully the row affected was: "+number);

        } catch (Exception e) {
            LOGGER.error(e.getMessage()) ;
            conn1.rollback();
        }
        finally {
            conn1.setAutoCommit(true);
            ConnectionPool.releaseConnection(conn1);
        }
    }

    @Override
    public List<T> getAll() throws SQLException {
        Connection conn1;
        try {
            conn1 = ConnectionPool.getConnection();
            conn1.setAutoCommit(false);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        try {
            String query=String.format("select * from %s",getTableName());
            PreparedStatement ps = conn1.prepareStatement(query);
            ResultSet result =ps.executeQuery();
            List<T> listOfThings=new ArrayList<>();
            while (result.next()){
                newClass = mapResultToObject(result,conn1);
                listOfThings.add(newClass);
            }
            LOGGER.info("All the elements were added to the list successfully");
            return listOfThings;
        } catch (SQLException e) {
            conn1.rollback();
            throw new RuntimeException(e);

        }
        finally {
            conn1.setAutoCommit(true);
            ConnectionPool.releaseConnection(conn1);
        }
    }

    @Override
    public T findById(long id) throws SQLException {
        Connection conn1;
        try {
            conn1 = ConnectionPool.getConnection();
            conn1.setAutoCommit(false);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        try {
            if (id==0l){
                LOGGER.info("The id must be greater than 0L, returning a null value");
                return returnVoidInstance();
            }
            String query= String.format("select * from %s where id=?",getTableName());
            PreparedStatement ps = conn1.prepareStatement(query);
            ps.setLong(1,id);

            ResultSet result =ps.executeQuery();
            if (!result.next()){
                return returnVoidInstance();
            }

            T newClass = mapResultToObject(result ,conn1);
            //LOGGER.info("The object was found successfully");
        return newClass;

        } catch (SQLException e) {
            conn1.rollback();
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            conn1.setAutoCommit(true);
            ConnectionPool.releaseConnection(conn1);
        }
    }

    @Override
    public void deleteById(Long thingId) throws SQLException {
        Connection conn1;
        try {
            conn1 = ConnectionPool.getConnection();
            conn1.setAutoCommit(false);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        try {
            T thingToDelete=findById(thingId);
            if (thingToDelete==null) {
                LOGGER.info("The object does not exist, delete operation failed");
                return ;
            }
            String query=String.format("delete from %s where id=?",getTableName()) ;
            PreparedStatement ps = conn1.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1,thingId);
            int rowNumber= ps.executeUpdate();
            LOGGER.info("The selected object was deleted successfully row affected: "+rowNumber);
        } catch (SQLException e) {
            conn1.rollback();
            throw new RuntimeException(e);
        }
        finally {
            conn1.setAutoCommit(true);
            ConnectionPool.releaseConnection(conn1);
        }
    }


    @Override
    public void updateById(T thingToUpdate, Long id) throws SQLException {
        Connection conn1;
        try {
            conn1 = ConnectionPool.getConnection();
            conn1.setAutoCommit(false);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        try {
            T checkIfExist=findById(id);
            if (checkIfExist==null) {
                LOGGER.info("The object does not exist, update operation failed");
                return;
            }
            if (getUpdateQuery(thingToUpdate,id).equals("invalid update")){
                LOGGER.info("The object is incomplete to update, insert a valid one");
                return;
            }
            PreparedStatement ps = conn1.prepareStatement(getUpdateQuery(thingToUpdate,id),Statement.RETURN_GENERATED_KEYS);
            int number= ps.executeUpdate();
            LOGGER.info("The object was updated successfully the row affected was: "+number);
        } catch (SQLException e) {
            conn1.rollback();
            throw new RuntimeException(e);
        }
        finally {
            conn1.setAutoCommit(true);
            ConnectionPool.releaseConnection(conn1);
        }
    }

    protected abstract String getUpdateQuery(T newThingToUpdate,Long id);


    /*Return the table name */
    protected abstract String getTableName();

    /*Return the table fields in the order that we want to show it or use it it must be separated by
    * commas and lower case
    * */
    protected abstract String getTableFields();

    /*Return the field values of the object that we want to add to the attributes in the new row of the table.
    they must be separated by comma in one string*/
    //protected abstract String getThingFields(T thing);

    protected abstract Long getThingId(T thing);

    protected abstract T mapResultToObject(ResultSet resultSet,Connection conn) throws SQLException;

    protected abstract String getCreateQuery();

    protected abstract void setQueryStatements(PreparedStatement ps,T thingToCreate);

    protected abstract T returnVoidInstance();

}
