/*
 * $Id$
 *
 * Copyright (c) 2011 Qunar.com. All Rights Reserved.
 */
package me.peterae86.demo.support;

import java.sql.Statement;
import java.util.Properties;

import me.peterae86.demo.util.ReflectUtil;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

/**
 * 物理分页支持类
 * <p/>
 * 
 * 在mybatis主配置文件进行如下配置
 * 
 * <pre>
 * &lt;plugins&gt;
 *      &lt;plugin interceptor="com.qunar.college.ResultSetHandlerHandleResultSetsPlugin"&gt;&lt;/plugin&gt;
 * &lt;/plugins&gt;
 * </pre>
 * 
 * @see StatementHandlerInterceptor
 * @author zhongyuan.zhang
 */
@Intercepts({
    @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })
public class ResultSetHandlerInterceptor implements Interceptor {

    private static final RowBounds ROW_BOUNDS = new RowBounds();

    public Object intercept(Invocation invocation) throws Throwable {

        ResultSetHandler target = (ResultSetHandler) invocation.getTarget();
        RowBounds rowBounds = (RowBounds) ReflectUtil.getFieldValue(target, "rowBounds");

        if (rowBounds.getLimit() > 0 && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
            // 清除翻页参数，禁止FastResultSetHandler#skipRows跳过结果集
            ReflectUtil.setFieldValue(target, "rowBounds", ROW_BOUNDS);
        }
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
    }
}
