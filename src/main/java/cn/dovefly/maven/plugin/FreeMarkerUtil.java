package cn.dovefly.maven.plugin;

import cn.dovefly.maven.plugin.util.DBHelper;
import cn.dovefly.maven.plugin.vo.DbTable;
import cn.dovefly.maven.plugin.vo.GlobalConfig;
import cn.dovefly.maven.plugin.vo.Pojo;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * freemarker 模板工具
 * 
 * @author Ying-er
 * @time 2010-2-6下午04:07:27
 * @version 1.0
 */
public class FreeMarkerUtil {

	public static String ENCODING = "UTF-8";

	/**
	 * 创建Configuration对象
	 *
	 * @param templateContent
	 *			模板文件基目录
	 * @return
	 * @throws IOException
	 */
	public static Configuration getConfiguration(String templateName, String templateContent) {
//		// 创建Configuration对象
		Configuration config = new Configuration();
//
//		// 指定模板路径目录，并加载模板文件
//		try {
//			config.setDirectoryForTemplateLoading(new File(templatePath));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// 设置包装器，并将对象包装为数据模型
		config.setObjectWrapper(new DefaultObjectWrapper());

		StringTemplateLoader stringLoader = new StringTemplateLoader();
		stringLoader.putTemplate(templateName, templateContent);
		config.setTemplateLoader(stringLoader);
		return config;
	}

/*按字节读取字符串*/

/* 个人感觉最好的方式，（一次读完）读字节就读字节吧，读完转码一次不就好了*/

	public static String readStrean2String(InputStream ins) {
		String str = "";
		try {
			// size  为字串的长度 ，这里一次性读完
			int size = ins.available();
			byte[] buffer = new byte[size];
			ins.read(buffer);
			ins.close();
			str = new String(buffer, ENCODING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static void generateFiles(String configFile) {
		try {
			Properties pro = new Properties();
			pro.load(FreeMarkerUtil.class.getResourceAsStream(configFile));

			GlobalConfig config = new GlobalConfig(pro);
			DBHelper dbHelper = new DBHelper(config);

			String tableName = config.getTableName();
			DbTable table = dbHelper.getTable(tableName);

			table.initConfig(config);

			if (table == null) {
				return;
			}
			if (table.getPojos() == null || table.getPojos().size() == 0) {
				return;
			}

			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("table", table);

			for (Pojo pojo : table.getPojos().values()) {

				InputStream is = FreeMarkerUtil.class.getResourceAsStream("/templates/" + pojo.getTemplateFile());
				String templateContent = readStrean2String(is);
				Configuration configuration = getConfiguration(pojo.getTemplateFile(), templateContent);
				configuration.setDefaultEncoding(ENCODING);

				Template template = configuration.getTemplate(pojo.getTemplateFile(), ENCODING);
				// 输出文档路径及名称
				String destFilePath = pojo.getTargetProject() + "/" + pojo.getClassName() + "." + pojo.getFileType();
				File outFile = new File(destFilePath);
				if (!outFile.getParentFile().exists()) {
					outFile.getParentFile().mkdirs();
				}

				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), ENCODING));
				template.process(dataMap, out);
				out.flush();
				out.close();
				System.out.println("模板文件：" + pojo.getTemplateFile() + ",生成文件：" + destFilePath);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException, SQLException, TemplateException {
		generateFiles("/generatorConfig.properties");
	}
}
