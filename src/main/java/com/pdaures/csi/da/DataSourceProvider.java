package com.pdaures.csi.da;

import javax.sql.DataSource;

/**
 * Provides a DataSource
 * @author patrick
 *
 */
public interface DataSourceProvider {
	public DataSource getDataSource();
}