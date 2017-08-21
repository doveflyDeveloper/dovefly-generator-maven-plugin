package cn.dovefly.maven.plugin.vo;

import java.util.Properties;

/**
 * Created by fengchunming on 2017/8/11.
 */
public class GlobalConfig {
    
    //jdbc连接
    String driver;
    String url;
    String userId;
    String password;

    //table
    String tableName;
    BeanConfig mapper;
    BeanConfig entity;
    BeanConfig repo;
    BeanConfig service;
    BeanConfig serviceImpl;
    BeanConfig controller;
    BeanConfig html;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public BeanConfig getMapper() {
        return mapper;
    }

    public void setMapper(BeanConfig mapper) {
        this.mapper = mapper;
    }

    public BeanConfig getEntity() {
        return entity;
    }

    public void setEntity(BeanConfig entity) {
        this.entity = entity;
    }

    public BeanConfig getRepo() {
        return repo;
    }

    public void setRepo(BeanConfig repo) {
        this.repo = repo;
    }

    public BeanConfig getService() {
        return service;
    }

    public void setService(BeanConfig service) {
        this.service = service;
    }

    public BeanConfig getServiceImpl() {
        return serviceImpl;
    }

    public void setServiceImpl(BeanConfig serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    public BeanConfig getController() {
        return controller;
    }

    public void setController(BeanConfig controller) {
        this.controller = controller;
    }

    public BeanConfig getHtml() {
        return html;
    }

    public void setHtml(BeanConfig html) {
        this.html = html;
    }

    public GlobalConfig(Properties pro) {
        driver = pro.getProperty("db.driver");
        url = pro.getProperty("db.url");
        userId = pro.getProperty("db.userId");
        password = pro.getProperty("db.password");

        tableName = pro.getProperty("table.tableName");

        mapper = new BeanConfig(pro.getProperty("table.mapper.targetProject"),
                pro.getProperty("table.mapper.targetPackage"),
                pro.getProperty("table.mapper.domainObjectName"),
                pro.getProperty("table.mapper.templateFile"),
                pro.getProperty("table.mapper.fileType"));

        entity = new BeanConfig(pro.getProperty("table.entity.targetProject"),
                pro.getProperty("table.entity.targetPackage"),
                pro.getProperty("table.entity.domainObjectName"),
                pro.getProperty("table.entity.templateFile"),
                pro.getProperty("table.entity.fileType"));

        repo = new BeanConfig(pro.getProperty("table.repo.targetProject"),
                pro.getProperty("table.repo.targetPackage"),
                pro.getProperty("table.repo.domainObjectName"),
                pro.getProperty("table.repo.templateFile"),
                pro.getProperty("table.repo.fileType"));

        service = new BeanConfig(pro.getProperty("table.service.targetProject"),
                pro.getProperty("table.service.targetPackage"),
                pro.getProperty("table.service.domainObjectName"),
                pro.getProperty("table.service.templateFile"),
                pro.getProperty("table.service.fileType"));

        serviceImpl = new BeanConfig(pro.getProperty("table.serviceImpl.targetProject"),
                pro.getProperty("table.serviceImpl.targetPackage"),
                pro.getProperty("table.serviceImpl.domainObjectName"),
                pro.getProperty("table.serviceImpl.templateFile"),
                pro.getProperty("table.serviceImpl.fileType"));

        controller = new BeanConfig(pro.getProperty("table.controller.targetProject"),
                pro.getProperty("table.controller.targetPackage"),
                pro.getProperty("table.controller.domainObjectName"),
                pro.getProperty("table.controller.templateFile"),
                pro.getProperty("table.controller.fileType"));

        html = new BeanConfig(pro.getProperty("table.html.targetProject"),
                pro.getProperty("table.html.targetPackage"),
                pro.getProperty("table.html.domainObjectName"),
                pro.getProperty("table.html.templateFile"),
                pro.getProperty("table.html.fileType"));

    }

}
