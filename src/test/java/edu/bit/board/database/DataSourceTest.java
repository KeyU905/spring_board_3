package edu.bit.board.database;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j;


@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;
    
    
    @Test
    public void testDataSource() {
       System.out.println("DS=" + dataSource);

       try (Connection conn = dataSource.getConnection()) {
          System.out.println("Cooooooooonn=" + conn);
          //assertThat(conn).isInstanceOf(Connection.class);

          assertEquals(100, getLong(conn, "select 100 from dual"));
          //assertTrue(0 < getLong(conn, "select count(*) from User"));

       } catch (Exception e) {
          e.printStackTrace();
       }
    }

    private long getLong(Connection conn, String sql) {
       long result = 0;
       try (Statement stmt = conn.createStatement()) {
          ResultSet rs = stmt.executeQuery(sql);
          if (rs.next()) {
             result = rs.getLong(1);
          }
          rs.close();
       } catch (Exception e) {
          e.printStackTrace();
       }
       
       return result;
    }
    
    

}
