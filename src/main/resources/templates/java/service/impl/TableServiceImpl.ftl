package ${table.pojos.serviceImpl.packageName};

import ${table.pojos.service.fullClassName};
import ${table.pojos.repo.fullClassName};
import ${table.pojos.entity.fullClassName};
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * ${table.comment}
 *
 * @author ${table.author}
 * @date ${table.date}
 */
@Service
public class ${table.pojos.serviceImpl.className} implements ${table.pojos.service.className} {

	private static Logger LOGGER = LoggerFactory.getLogger(${table.pojos.serviceImpl.className}.class);

	@Resource
	private ${table.pojos.repo.className} repo;

	@Override
	@Transactional
	public int save(${table.pojos.entity.className} entity) {
		if (entity == null) {
			return 0;
		}
		if (entity.get${table.keyColumn.propertyName?cap_first}() != null && entity.get${table.keyColumn.propertyName?cap_first}() > 0) {
			return repo.updateByPrimaryKey(entity);
		} else {
			return repo.insert(entity);
		}
	}

	@Override
	@Transactional
	public int delete(${table.keyColumn.javaTypeShort} ${table.keyColumn.propertyName}) {
		return repo.deleteByPrimaryKey(id);
	}

	@Override
	public ${table.pojos.entity.className} get(${table.keyColumn.javaTypeShort} ${table.keyColumn.propertyName}) {
		return repo.selectByPrimaryKey(${table.keyColumn.propertyName});
	}

	@Override
	public List<${table.pojos.entity.className}> queryAllList() {
    	return repo.selectList();
    }

}

