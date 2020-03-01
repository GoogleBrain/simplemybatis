package cn.yufu.main;

import cn.yufu.main.domain.Student;
import cn.yufu.main.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession();

        StudentMapper mapper = openSession.getMapper(StudentMapper.class);
        Student stt = mapper.selectById(100,"王五");
        System.out.println(stt);
        openSession.commit();
        openSession.flushStatements();
        openSession.close();
    }
}
