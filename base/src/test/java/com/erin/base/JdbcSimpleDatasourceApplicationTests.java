package com.erin.base;

import com.erin.base.domain.SysUser;
import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariProxyResultSet;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author ljx
 * @Date 2020/12/25 16:51
 **/

@SpringBootTest
@RunWith(SpringRunner.class)
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
@Slf4j
public class JdbcSimpleDatasourceApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Before
    public void before() {
        log.info("===开始测试");
    }

    @After
    public void after() {
        log.info("===结束测试");
    }

    @Test
    public void springDataSourceTest() throws SQLException {
        //输出为true
        System.out.println(dataSource instanceof HikariDataSource);
        System.out.println("获取的数据库连接为:"+dataSource.getConnection());
        try{
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from sys_user");
            SysUser sysUser = null;
            if(resultSet.next()){

                sysUser = new SysUser();
//                sysUser.setId(resultSet.getLong(1));
//                sysUser.setName(resultSet.getString("LiangJiaxin"));
//                sysUser.setPhone(resultSet.getString("18338221784"));
//                sysUser.setHeadImg(resultSet.getString("https://cdn4.buysellads.net/uu/1/3386/1525189943-38523.png"));
//                sysUser.setAccount(resultSet.getString("244080186"));
//                sysUser.setPsword(resultSet.getString("LIKEYOU099"));
//                sysUser.setCreateOperator(resultSet.getLong(1));
//                sysUser.setUpdateOperator(resultSet.getLong(1));
            }
            System.out.println(sysUser);
            statement.close();
            connection.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
