package com.flymvc.render;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flymvc.Fly;
import com.flymvc.config.Config;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * FreeMarker 渲染实现
 * 
 * @author jameszhou
 *
 */
public class FreeMarkerRender implements Render {

	private static Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
	
	@Override
	public void render(HttpServletRequest request, HttpServletResponse response, String view) {

		Configuration configuration = getConfiguration(request.getSession().getServletContext());
		try {
			Template template = configuration.getTemplate(view + ".html");
			Writer out = response.getWriter();
			Map<String, Object> map = new HashMap<String, Object>();
			Enumeration<String> names = request.getAttributeNames();
			while (names.hasMoreElements()) {
				String name = names.nextElement();
				map.put(name, request.getAttribute(name));
			}
			template.process(map, out);
			out.flush();
		} catch (IOException | TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取配置
	 * @param servletContext
	 * @param path
	 * @return
	 */
	public static Configuration getConfiguration(Object servletContext) {

		Config config = Fly.me().getConfig();
		configuration.setServletContextForTemplateLoading(servletContext, config.getViewPath());
		configuration.setDefaultEncoding(config.getCharset().getValue());
		configuration.setOutputEncoding(config.getCharset().getValue());
		
		return configuration;

	}
}
