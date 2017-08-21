package cn.dovefly.maven.plugin.vo;

/**
 * Created by fengchunming on 2017/8/11.
 */
public class BeanConfig {
    String targetProject;
    String targetPackage;
    String domainObjectName;
    String templateFile;
    String fileType;

    public BeanConfig(String targetProject, String targetPackage, String domainObjectName, String templateFile, String fileType) {
        this.targetProject = targetProject;
        this.targetPackage = targetPackage;
        this.domainObjectName = domainObjectName;
        this.templateFile = domainObjectName;
        this.fileType = domainObjectName;
    }

    public String getTargetProject() {
        return targetProject;
    }

    public void setTargetProject(String targetProject) {
        this.targetProject = targetProject;
    }

    public String getTargetPackage() {
        return targetPackage;
    }

    public void setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage;
    }

    public String getDomainObjectName() {
        return domainObjectName;
    }

    public void setDomainObjectName(String domainObjectName) {
        this.domainObjectName = domainObjectName;
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
