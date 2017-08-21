package ${table.pojos.service.packageName};

import ${table.pojos.entity.fullClassName};
import java.util.List;

/**
 * ${table.comment}
 *
 * @author ${table.author}
 * @date ${table.date}
 */
public interface ${table.pojos.service.className} {

    int save(${table.pojos.entity.className} entity);

    int delete(${table.keyColumn.javaTypeShort} ${table.keyColumn.propertyName});

    ${table.pojos.entity.className} get(${table.keyColumn.javaTypeShort} ${table.keyColumn.propertyName});

    List<${table.pojos.entity.className}> queryAllList();
}
