package com.xp.note1.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;

/*******
 *  反向生成类
 */
public class MybatisPlusUtil {

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String  projectPath = System.getProperty("user.dir");  // 获取项目路径
        gc.setOutputDir(projectPath+"/src/main/java"); // 生成文件路径
        gc.setAuthor("xp"); // 作者
        gc.setOpen(true); // 生成完以后是否打开资源管理器
        gc.setSwagger2(false);// 是否开启 实体类 swagger 注解
        gc.setDateType(DateType.TIME_PACK); // 设置时间类型
        gc.setServiceName("%sService");//去Service的I前缀

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/notebase?useSSL=false&characterEncoding=utf-8");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");

        mpg.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.xp.note1");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");

        mpg.setPackageInfo(packageConfig);

        // 模板
/*        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);

        mpg.setTemplate(templateConfig);*/


        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);// 驼峰
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setSuperEntityClass("com.xp.note1.entity.BaseEntity");
        strategyConfig.setSuperEntityColumns("id");
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setEntityLombokModel(true);

        // 公共父类
//        strategyConfig.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段

        strategyConfig.setInclude("t_node_files,t_note"); // 需要包含的表名，允许正则表达式（与exclude二选一配置）
        strategyConfig.setControllerMappingHyphenStyle(true); // 驼峰连转字符
//        strategyConfig.setTablePrefix(packageConfig.getModuleName()+"_");  //表前缀



        mpg.setStrategy(strategyConfig);

//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.execute(); // 执行

    }
}
