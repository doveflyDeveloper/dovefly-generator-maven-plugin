package ${table.pojos.repo.packageName};

import com.xiaoka.freework.container.dao.CommonDao;
import com.xiaoka.freework.data.datasource.RoutingDataSourceDecision;
import ${table.pojos.entity.fullClassName};
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * ${table.comment}
 *
 * @author ${table.author}
 * @date ${table.date}
 */
@Repository
public class ${table.pojos.repo.className} {

    @Resource
    private CommonDao ndsmDao;

    /**
    * 插入记录(包含所有字段)
    */
    public int insert(${table.pojos.entity.className} entity) {
        return ndsmDao.mapper(${table.pojos.entity.className}.class).source(RoutingDataSourceDecision.Source.MASTER)
            .sql("insert").session().insert(entity);
    }

    /**
    * 插入记录(不包含NULL字段)
    */
    public int insertSelective(${table.pojos.entity.className} entity) {
        return ndsmDao.mapper(${table.pojos.entity.className}.class).source(RoutingDataSourceDecision.Source.MASTER)
            .sql("insertSelective").session().insert(entity);
    }

    /**
    * 更新记录(包含所有字段)
    */
    public int updateByPrimaryKey(${table.pojos.entity.className} entity) {
        return ndsmDao.mapper(${table.pojos.entity.className}.class).source(RoutingDataSourceDecision.Source.MASTER)
            .sql("updateByPrimaryKey").session().update(entity);
    }

    /**
    * 更新记录(不包含NULL字段)
    */
    public int updateByPrimaryKeySelective(${table.pojos.entity.className} entity) {
        return ndsmDao.mapper(${table.pojos.entity.className}.class).source(RoutingDataSourceDecision.Source.MASTER)
            .sql("updateByPrimaryKeySelective").session().update(entity);
    }

    /**
    * 删除记录
    */
    public int deleteByPrimaryKey(${table.keyColumn.javaTypeShort} ${table.keyColumn.propertyName}) {
        return ndsmDao.mapper(${table.pojos.entity.className}.class).source(RoutingDataSourceDecision.Source.MASTER)
            .sql("deleteByPrimaryKey").session().delete(${table.keyColumn.propertyName});
    }

    /**
    * 查询记录
    */
    public ${table.pojos.entity.className} selectByPrimaryKey(${table.keyColumn.javaTypeShort} ${table.keyColumn.propertyName}) {
        return ndsmDao.mapper(${table.pojos.entity.className}.class).source(RoutingDataSourceDecision.Source.SLAVE)
            .sql("selectByPrimaryKey").session().selectOne(${table.keyColumn.propertyName});
    }

    /**
    * 查询记录列表
    */
    public List<${table.pojos.entity.className}> selectList() {
        return ndsmDao.mapper(${table.pojos.entity.className}.class).source(RoutingDataSourceDecision.Source.SLAVE)
            .sql("selectList").session().selectList();
    }
}
