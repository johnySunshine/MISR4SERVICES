# visr

**后端管理平台**

- 本后端是基于java语言编写 使用SSM框架：`SpringMVC + Spring + MyBatis`

- 环境需求:jdk 1.7;mvn 3.3.9

- 编辑工具:intellij idea

---------
选择原因：

> 我们在实际应用中发现，SpringMVC可以完全替代Struts，配合注解的方式，编程非常快捷，而且通过restful风格定义url，让地址看起来非常优雅。
> MyBatis也可以替换Hibernate，正因为MyBatis的半自动特点，我们程序猿可以完全掌控SQL，这会让有数据库经验的程序猿能开发出高效率的SQL语句，而且XML配置管理起来也非常方便。

 1. SpringMVC：它用于web层，相当于controller（等价于传统的servlet和struts的action），用来处理用户请求。举个例子，用户在地址栏输入http://网站域名/login，那么springmvc就会拦截到这个请求，并且调用controller层中相应的方法，（中间可能包含验证用户名和密码的业务逻辑，以及查询数据库操作，但这些都不是springmvc的职责），最终把结果返回给用户，并且返回相应的页面（当然也可以只反馈josn/xml等格式数据）。springmvc就是做前面和后面过程的活，与用户打交道！！

 2. Spring：我们平时开发接触最多的估计就是IOC容器，它可以装载bean（也就是我们java中的类，当然也包括service dao里面的），有了这个机制，我们就不用在每次使用这个类的时候为它初始化，很少看到关键字new。另外spring的aop，事务管理等等都是我们经常用到的。

 3. MyBatis： 第一，它能自由控制sql。第二，它可以使用xml的方式来组织管理我们的sql

--------------
目录结构遵循maven的目录规范

项目原型博客地址：[http://blog.csdn.net/qq598535550/article/details/51703190](http://blog.csdn.net/qq598535550/article/details/51703190)
