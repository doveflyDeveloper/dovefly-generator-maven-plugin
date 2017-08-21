package ${table.pojos.controller.packageName};

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ${table.pojos.service.fullClassName};
import ${table.pojos.repo.fullClassName};
import ${table.pojos.entity.fullClassName};

/**
 * ${table.comment}
 *
 * @author ${table.author}
 * @date ${table.date}
 */
@Controller
@RequestMapping("/${table.pojos.controller.className?uncap_first}")
public class ${table.pojos.controller.className} {
	
	@Autowired
	protected ${table.pojos.service.className} service;
	
}
