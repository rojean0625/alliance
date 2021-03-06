/**
 *
 */
package com.alliance.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @Description: 这里用一句话描述这个类的作用
 * @see: FreeMakerUtil 此处填写需要参考的类
 * @version 2017年12月12日 下午2:10:38
 * @author chao.luo
 */
@Component
public class FreeMakerUtil {
	public Template getTemplate(String ftlName, String fileWebDir) {
		try {

			Configuration cfg = new Configuration();
			TemplateLoader templateLoader = null;
			templateLoader = new FileTemplateLoader(new File(fileWebDir));
			cfg.setTemplateLoader(templateLoader);
			Template template = cfg.getTemplate(ftlName, "UTF-8");
			return template;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void generateFile(String ftlName, Map<String, Object> root, String outFilePath, String fileWebDir) {

		FileWriter out = null;
		try {
			out = new FileWriter(new File(outFilePath));
			Template temp = this.getTemplate(ftlName, fileWebDir);
			temp.process(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
