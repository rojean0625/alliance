package com.alliance.bean;

public class NaaruBean {

	/** 父项目名称 **/
	private String rootName;
	/** 子项目artifactId**/
	private String artifactId;

	/** mybatis mapper xml 文件路径**/
	private String mybatisXmlPath;
	/** mybatis mapper class 文件路径**/
	private String mybatisClassPath;
	/** mybatis mapper class 包名**/
	private String mybatisClassPackageName;

	/** dao文件路径 **/
	private String daoPath;
	/** daoImpl 文件路径**/
	private String daoImplPath;

	/** service 文件路径 **/
	private String servicePath;
	/** serviceImpl 文件路径 **/
	private String serviceImplPath;
	/** controller 路径 **/
	private String controllerPath;

	/** model 生成文件路径**/
	private String modelPath;
	/** model 包名**/
	private String modelPackageName;

	/** 模板名称 **/
	private String templateName;
	/** 模版路径 **/
	private String templatePath;

	/** 项目workspance根目录 **/
	private String workspanceDir;



	public NaaruBean(){}
	public String getRootName() {
		return rootName;
	}
	public void setRootName(String rootName) {
		this.rootName = rootName;
	}
	public String getArtifactId() {
		return artifactId;
	}
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}
	public String getMybatisXmlPath() {
		return mybatisXmlPath;
	}
	public void setMybatisXmlPath(String mybatisXmlPath) {
		this.mybatisXmlPath = mybatisXmlPath;
	}
	public String getMybatisClassPath() {
		return mybatisClassPath;
	}
	public void setMybatisClassPath(String mybatisClassPath) {
		this.mybatisClassPath = mybatisClassPath;
	}
	public String getMybatisClassPackageName() {
		return mybatisClassPackageName;
	}
	public void setMybatisClassPackageName(String mybatisClassPackageName) {
		this.mybatisClassPackageName = mybatisClassPackageName;
	}
	public String getDaoPath() {
		return daoPath;
	}
	public void setDaoPath(String daoPath) {
		this.daoPath = daoPath;
	}
	public String getDaoImplPath() {
		return daoImplPath;
	}
	public void setDaoImplPath(String daoImplPath) {
		this.daoImplPath = daoImplPath;
	}
	public String getServicePath() {
		return servicePath;
	}
	public void setServicePath(String servicePath) {
		this.servicePath = servicePath;
	}
	public String getServiceImplPath() {
		return serviceImplPath;
	}
	public void setServiceImplPath(String serviceImplPath) {
		this.serviceImplPath = serviceImplPath;
	}
	public String getModelPath() {
		return modelPath;
	}
	public void setModelPath(String modelPath) {
		this.modelPath = modelPath;
	}
	public String getModelPackageName() {
		return modelPackageName;
	}
	public void setModelPackageName(String modelPackageName) {
		this.modelPackageName = modelPackageName;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getTemplatePath() {
		return templatePath;
	}
	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}
	public String getControllerPath() {
		return controllerPath;
	}
	public void setControllerPath(String controllerPath) {
		this.controllerPath = controllerPath;
	}
	public String getWorkspanceDir() {
		return workspanceDir;
	}
	public void setWorkspanceDir(String workspanceDir) {
		this.workspanceDir = workspanceDir;
	}

}
