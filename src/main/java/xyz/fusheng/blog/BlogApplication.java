package xyz.fusheng.blog;

        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 * @author code_fusheng
 * @Date: 2020/3/10 22:04  --  2020/3/11 15:42 完成了前期工作
 * @Date: 2020/3/12 10:34  --  2020/3/13 0:20  完成了帖子分类
 * @Date: 2020/3/13 7:34   --  2020/3/13 15:44 完成了友情链接
 * @Date: 2020/3/13 16:04  --  2020/3/13 17:13 完成了管理功能
 * @Data: 2020/3/13 19:01  --  2020/3/13 23:49 完成了博客功能
 * @
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("xyz.fusheng.blog.mapper")
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
