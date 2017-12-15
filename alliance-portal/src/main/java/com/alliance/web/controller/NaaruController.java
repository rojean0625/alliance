package com.alliance.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alliance.bean.NaaruBean;
import com.alliance.utils.CodeMachine;
import com.alliance.utils.MysqlToBean;
import com.google.gson.Gson;

@Controller
@RequestMapping("naaru")
public class NaaruController {

	@Resource
	private CodeMachine codeMachine;

	@Resource
	private MysqlToBean mysqlToBean;

	@RequestMapping("doA")
	public void doA() throws Exception {
		System.out.println("## 1");
		//codeMeachine.generateMapperXmlFile("invoice");
		//codeMeachine.generateMapperClassFile("invoice");
		//mysqlToBean.createJavaBeanByTable("F:/workspace-new/alliance/alliance-model/src/main/java/com/alliance/model", "com.alliance.model", "invoice");
		System.out.println("## 2");
	}

	@RequestMapping("activate")
	public ModelAndView activate(HttpServletRequest request,NaaruBean naaru) throws Exception{
		String tableName = "invoice";
		String mapperPackage = naaru.getMybatisClassPackageName();
		String beanPackage = naaru.getModelPackageName();
		String controllerClassPath = naaru.getControllerPath();
		codeMachine.generateControllerFile(tableName, mapperPackage, beanPackage, controllerClassPath);
		return toNaaru(request);
	}

	@RequestMapping("toNaaru")
	public ModelAndView toNaaru(HttpServletRequest request){
		String path = request.getScheme() + "://" + request.getServerName() + (80 == request.getServerPort() || 443 == request.getServerPort() ? "" : (":" + request.getServerPort()));
		String context = request.getContextPath();
		path = path + context;
		ModelAndView mv = new ModelAndView("/naaru");
		mv.addObject("path", path);
		return mv;
	}

	@RequestMapping(value="naaruLight")
	@ResponseBody
	public String toNaaru(NaaruBean naaru){
		String rootName = naaru.getRootName();
		String artifactId = naaru.getArtifactId();
		String workspace= "F:/workspace-new/";

		String mybatisXmlPath = workspace+rootName+"/"+artifactId+"/src/main/resources/com/"+rootName+"/mapper/";
		naaru.setMybatisXmlPath(mybatisXmlPath);

		String mybatisClassPath = workspace+rootName+"/"+artifactId+"/src/main/java/com/"+rootName+"/mapper/";
		naaru.setMybatisClassPath(mybatisClassPath);

		String mybatisClassPackageName="com."+rootName+".mapper";
		naaru.setMybatisClassPackageName(mybatisClassPackageName);

		String modelPath = workspace+rootName+"/"+artifactId+"/src/main/java/com/"+rootName+"/model/";
		naaru.setModelPath(modelPath);

		String modelPackageName = "com."+rootName+".model";
		naaru.setModelPackageName(modelPackageName);

		String daoPath = workspace+rootName+"/"+artifactId+"/src/main/java/com/"+rootName+"/dao/";
		naaru.setDaoPath(daoPath);

		String daoImplPath = workspace+rootName+"/"+artifactId+"/src/main/java/com/"+rootName+"/dao/impl/";
		naaru.setDaoImplPath(daoImplPath);

		String servicePath =workspace+rootName+"/"+artifactId+"/src/main/java/com/"+rootName+"/service/";
		naaru.setServicePath(servicePath);

		String serviceImplPath = workspace+rootName+"/"+artifactId+"/src/main/java/com/"+rootName+"/service/impl/";
		naaru.setServiceImplPath(serviceImplPath);

		String controllerPath = workspace+rootName+"/"+artifactId+"/src/main/java/com/"+rootName+"/web/controller/";
		naaru.setControllerPath(controllerPath);
		return new Gson().toJson(naaru);
	}



}
