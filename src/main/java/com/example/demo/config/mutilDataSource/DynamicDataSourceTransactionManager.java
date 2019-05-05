package com.example.demo.config.mutilDataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;

import javax.sql.DataSource;


public class DynamicDataSourceTransactionManager extends DataSourceTransactionManager {

/*
*
     * 只读事务到读库，读写事务到写库
     * @param transaction
     * @param definition
*/


    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) {

        //设置数据源
        boolean readOnly = definition.isReadOnly();
        if(readOnly) {
            DynamicDataSourceHolder.putDataSource(DynamicDataSourceGlobal.READ);
        } else {
            DynamicDataSourceHolder.putDataSource(DynamicDataSourceGlobal.WRITE);
        }
        super.doBegin(transaction, definition);
    }

/*
     * 清理本地线程的数据源
     * @param transaction
     */

    @Override
    protected void doCleanupAfterCompletion(Object transaction) {
        super.doCleanupAfterCompletion(transaction);
        DynamicDataSourceHolder.clearDataSource();
    }

    public DynamicDataSourceTransactionManager(DataSource dataSource) {
        super(dataSource);
    }
}
