package cn.dovefly.maven.plugin.vo;

public class Pojo {

	private String targetProject = "dovefly-orm/src/main/java";
	private String packageName = "cn.dovefly.orm.employee.entity";
	private String className = "EmployeeEntity";
	private String templateFile = "TableEntity.java.ftl";
	private String fileType = "java";

//	public Pojo() {
//		super();
//	}

	public Pojo(String targetProject, String packageName, String className, String templateFile, String fileType) {
		this.targetProject = targetProject;
		this.packageName = packageName;
		this.className = className;
		this.templateFile = templateFile;
		this.fileType = fileType;

	}

	public Pojo(BeanConfig beanConfig) {
		this.targetProject = beanConfig.getTargetProject();
		this.packageName = beanConfig.getTargetPackage();
		this.className = beanConfig.getDomainObjectName();
		this.templateFile = beanConfig.getTemplateFile();
		this.fileType = beanConfig.getFileType();
	}

	public String getTargetProject() {
		return targetProject;
	}

	public void setTargetProject(String targetProject) {
		this.targetProject = targetProject;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public String getFullClassName() {
		return this.getPackageName() + "." + this.getClassName();
	}

}
