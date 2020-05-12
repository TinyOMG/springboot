package cn.china.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//扫描controller包中所有类的注解,加入spring容器中
@ComponentScan({"controller","serviceimpl","util"})
@MapperScan("mapper")
public class SpringbootApplication {
public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);


}

}
