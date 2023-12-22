package com.solvd.essay;


import com.solvd.essay.domain.EssayModule;
import com.solvd.essay.persistence.impl.AbstracDao;
import com.solvd.essay.persistence.impl.EssayModuleRepositoryImpl;
import com.solvd.essay.service.EssayModuleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");

    }
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/solvd_essay","root","Edgar1269!");

        conn.setAutoCommit(false);
        //insert practice example
        /*
        try {
            PreparedStatement ps =conn.prepareStatement("insert into essay_module (module_description) value (?) ", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,"Greater module");
            ps.executeUpdate();


        } catch (Exception e) {
            conn.rollback();
        }
        finally {
            conn.setAutoCommit(true);
        }

         */
        //Delete practice example
        /*
        try {
            PreparedStatement ps =conn.prepareStatement("delete from essay_module  where id= ? ;");
            ps.setLong(1,10);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        finally {
            conn.setAutoCommit(true);
        }
        */
        //Find All practice example
        /*
         PreparedStatement pr = conn.prepareStatement("select * from essay_module");
         ResultSet result = pr.executeQuery();
         while (result.next()){
             System.out.println(result.getString("module_description"));
         }

         */
        /*
        try {
            PreparedStatement ps =conn.prepareStatement("update essay_module set module_description=?" +
                    " where id= ? ;");
            ps.setString(1,"probando 345");
            ps.setLong(2,24);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        finally {
            conn.setAutoCommit(true);
        }

         */



            AbstracDao<EssayModule> newEssayModuleImplementation = new EssayModuleRepositoryImpl(conn);
            EssayModuleService newEssayModuleService= new EssayModuleService(newEssayModuleImplementation);


        //Create implementation
        /*
            EssayModule newEssayModule1= new EssayModule();
            newEssayModule1.setModuleDescription("Probando abc");

            newEssayModuleService.create(newEssayModule1);
         */



        /*

         //Find all implementation
        List<EssayModule> moduleList =newEssayModuleService.findAll();
        for (EssayModule module:moduleList) {
            System.out.println(module.getId()+" "+module.getModuleDescription());
        }
        */


        //Find one by id
        /*
        EssayModule module1 = newEssayModuleService.findOne(5L);
        System.out.println(module1.getId()+" "+module1.getModuleDescription());
         */

        //Delete one by id
        /*
        newEssayModuleService.deleteOne(11L);
         */
        //Delete one by the object

        /*
        EssayModule newEssayModule2= new EssayModule();
        newEssayModule2.setId(21L);
        newEssayModuleService.deleteEntity(newEssayModule2);
         */
        EssayModule newEssayModule3= new EssayModule();
        newEssayModule3.setId(5L);
        newEssayModule3.setModuleDescription("Probando 6969");
        newEssayModuleService.updateEntity(newEssayModule3);
        conn.close();

    }
}