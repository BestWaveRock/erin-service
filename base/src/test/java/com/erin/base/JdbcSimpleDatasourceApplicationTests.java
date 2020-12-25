package com.erin.base;

import com.erin.base.domain.SysUser;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author ljx
 * @Date 2020/12/25 16:51
 **/

@SpringBootTest
@RunWith(SpringRunner.class)
public class JdbcSimpleDatasourceApplicationTests {

    @DubboReference
    private DataSource dataSource;

    @Test
    public void springDataSourceTest(){
        //输出为true
        System.out.println(dataSource instanceof HikariDataSource);
//        System.out.println(dataSource instanceof MyDataSource);
        try{
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            SysUser sysUser = null;
            if(resultSet.next()){
                sysUser = new SysUser();
                sysUser.setId(resultSet.getLong(1));
                sysUser.setName(resultSet.getString("娃娃哈哈"));
                sysUser.setPhone(resultSet.getString("18338221784"));
                sysUser.setHeadImg(resultSet.getString("https://cdn4.buysellads.net/uu/1/3386/1525189943-38523.png"));
                sysUser.setAccount(resultSet.getString("244080186"));
                sysUser.setPsword(resultSet.getString("LIKEYOU099"));
                sysUser.setCreateOperator(resultSet.getLong(1));
                sysUser.setUpdateOperator(resultSet.getLong(1));
            }
            System.out.println(sysUser);
            statement.close();
            connection.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
