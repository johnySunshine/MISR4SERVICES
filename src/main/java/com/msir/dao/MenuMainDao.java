package com.msir.dao;

import com.msir.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/5.
 *  菜单接口
 */
public interface MenuMainDao extends SuperBasicDao<Menu>{
    List<Menu> queryDao();

    int insertDao(Menu menu);

    int deleteDao(@Param("menuId") int menuId);

    int updateDao(Menu menu);
}
/**
 *  Service / DAO 层方法命名规约
 1 ） 获取单个对象的方法用 get 做前缀。
 2 ） 获取多个对象的方法用 list 做前缀。
 3 ） 获取统计值的方法用 count 做前缀。
 4 ） 插入的方法用 save（ 推荐 ） 或 insert 做前缀。
 5 ） 删除的方法用 remove（ 推荐 ） 或 delete 做前缀。
 6 ） 修改的方法用 update 做前缀。
 B) 领域模型命名规约
 1 ） 数据对象： xxxDO ， xxx 即为数据表名。
 2 ） 数据传输对象： xxxDTO ， xxx 为业务领域相关的名称。
 3 ） 展示对象： xxxVO ， xxx 一般为网页名称。
 4 ） POJO 是 DO / DTO / BO / VO 的统称，禁止命名成 xxxPOJO 。


 9. 【强制】表必备三字段： id ,  gmt _ create ,  gmt _ modified 。
 说明：其中 id 必为主键，类型为 unsigned bigint 、单表时自增、步长为 1。 gmt _ create ,
 gmt _ modified 的类型均为 date _ time 类型。
 表的命名最好是加上“业务名称_表的作用”。


 tiger _ task /  tiger _ reader /  mpp _ config

 */
