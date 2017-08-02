# visr

**后端管理平台**

- 本后端是基于java语言编写 使用SSM框架：`SpringMVC + Spring + MyBatis`

- 环境需求:jdk 1.7;mvn 3.3.9

- 编辑工具:intellij idea

---------
## WHY :question: 

> 我们在实际应用中发现，SpringMVC可以完全替代Struts，配合注解的方式，编程非常快捷，而且通过restful风格定义url，让地址看起来非常优雅。
> MyBatis也可以替换Hibernate，正因为MyBatis的半自动特点，我们程序猿可以完全掌控SQL，这会让有数据库经验的程序猿能开发出高效率的SQL语句，而且XML配置管理起来也非常方便。

 1. SpringMVC：它用于web层，相当于controller（等价于传统的servlet和struts的action），用来处理用户请求。举个例子，用户在地址栏输入`http://网站域名/login`，那么springmvc就会拦截到这个请求，并且调用controller层中相应的方法，（中间可能包含验证用户名和密码的业务逻辑，以及查询数据库操作，但这些都不是springmvc的职责），最终把结果返回给用户，并且返回相应的页面（当然也可以只反馈josn/xml等格式数据）。springmvc就是做前面和后面过程的活，与用户打交道！！

 2. Spring：我们平时开发接触最多的估计就是IOC容器，它可以装载bean（也就是我们java中的类，当然也包括service dao里面的），有了这个机制，我们就不用在每次使用这个类的时候为它初始化，很少看到关键字new。另外spring的aop，事务管理等等都是我们经常用到的。

 3. MyBatis： 第一，它能自由控制sql。第二，它可以使用xml的方式来组织管理我们的sql

--------------
## 项目的主体结构
```
OSC/
 ├──.idea/                                      * 编辑的器配置文件
 ├──src/                                        * 项目所有源代码
 │   ├──main/                                   * 代码主体文件
 │   │    ├──java/
 │   │    │    ├──com.msir/                     * 代码主体文件
 │   │    │    │    ├──dao                      * dao层与数据库交互
 │   │    │    │    ├──dto                      * 数据封装的对象
 │   │    │    │    ├──enums                    * 枚举类，主要用于错误码处理
 │   │    │    │    ├──filter                   * 过滤器
 │   │    │    │    ├──pojo                     * pojo对象
 │   │    │    │    ├──service                  * service层级
 │   │    │    │    ├──shiro                    * shiro权限管理文件
 │   │    │    │    ├──utils                    * 工具方法，封装全局静态方法
 │   │    │    │    └──web                      * 处理与前端的交互
 │   │    ├──resource/                          * 资源文件，包含配置等
 │   │    │    ├──mapper/                       * sql语句的xml，主要用户mybatis的读取
 │   │    │    ├──spring/                       * spring主体配置文件
 │   │    │    │    ├──spring-dao.xml           * spring数据池配置
 │   │    │    │    ├──spring-service.xml       * spring事务管理配置
 │   │    │    │    ├──spring-shiro.xml         * spring与shiro整合的文件
 │   │    │    │    └──spring-web.xml           * springMVC与spring的整合配置
 │   │    │    ├──jdbc.properties               * 与数据库参数文件
 │   │    │    ├──log4j.properties              * log4j参数文件
 │   │    │    ├──logback.xml                   * 日志格式文件
 │   │    │    └──mybatis-config.xml            * mybatis配置文件，主要用户读取数据库配置
 │   │    ├──sql/                               * sql语句
 │   │    └──webapp/
 │   └──test/                                   * java测试文件，结构同`src/java`
 ├──target/                                     * 编译完成的class文件
 ├──LICESE                                      * 开源声明
 ├──pom.xml                                     * maven项目中pom文件
 └──README.md                                   * 项目介绍
 
```