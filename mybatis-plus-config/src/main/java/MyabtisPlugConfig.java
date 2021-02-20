import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/******
 *  代码生成器配置
 */
public class MyabtisPlugConfig {


    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        // 得到当前项目路径
        String projectPath = System.getProperty("user.dir");

        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setOpen(true);// 程序生成完以后是否打开资源管理器
        gc.setFileOverride(true);// 文件覆盖
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("xwd");// 作者


        // 自定义文件命名，注意 %s 会自动填充表实体属性！        文件名  后缀
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        autoGenerator.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);   //设置数据库类型，我是postgresql
        dsc.setUrl("jdbc:mysql://localhost:3306/notebase");  //指定数据库
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        autoGenerator.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //设置字段名大小写转换
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //设置生成的表名，这里使用exClude来进行排除，写入null，表示生成所有表。
//            strategyConfig.setExclude(null);
        //设置表    可变个数的形参    String数组
        strategyConfig.setInclude("consider_cjinfo");
        //设置自定义的service层继承代码，这里使用我定义的service和impl来进行继承---Sopp
//            strategyConfig.setSuperServiceClass("com.sopp.sp.util.MyService");
//            strategyConfig.setSuperServiceImplClass("com.sopp.sp.util.MyServiceImpl");
        //生成序列化id
        strategyConfig.setEntitySerialVersionUID(true);
//            strategyConfig.setEntityColumnConstant(true);
//            strategyConfig.setControllerMappingHyphenStyle(true);//路径加分隔符
        //实体类是否带有lombok风格
        strategyConfig.setEntityLombokModel(true);
        //rest风格controller
        strategyConfig.setRestControllerStyle(true);
        //允许字段自动注解
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        strategyConfig.setTablePrefix("dd");
        strategyConfig.isEntityTableFieldAnnotationEnable();
        //设置逻辑删除的字段名
        strategyConfig.setLogicDeleteFieldName("status");
        //填充字段配置
        List<TableFill> list = new ArrayList<TableFill>();
        list.add(new TableFill("createTime", FieldFill.INSERT));
        list.add(new TableFill("updateTime", FieldFill.INSERT_UPDATE));
        strategyConfig.setTableFillList(list);
        autoGenerator.setStrategy(strategyConfig);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.wdw.wd.goods");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
//            pc.setEntity("entity");
        pc.setEntity("pojo");
        pc.setXml("xml");
        pc.setModuleName("util");
        autoGenerator.setPackageInfo(pc);

        //不加这个会报空指针异常
        InjectionConfig injectionConfig = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        //自定义配置
        autoGenerator.setCfg(injectionConfig);

        // 执行生成
        autoGenerator.execute();


    }


}
