package schemacrawler.spring.boot.ext;

import schemacrawler.inclusionrule.IncludeAll;
import schemacrawler.schemacrawler.SchemaCrawlerException;
import schemacrawler.schemacrawler.SchemaCrawlerOptions;
import schemacrawler.spring.boot.utils.SchemaCrawlerOptionBuilder;
import schemacrawler.tools.databaseconnector.DatabaseConnectionOptions;
import schemacrawler.tools.databaseconnector.DatabaseUrlConnectionOptions;

public class DatabaseSchemaCrawlerOptions {

	/** 数据库类型 */
	private DatabaseType type;
	/**
	 * JDBC URL of the database.
	 */
	private String url;
	/**
	 * Login username of the database.
	 */
	private String username;
	/**
	 * Login password of the database.
	 */
	private String password;
	/** 数据库Schema获取操作配置 */
	private SchemaCrawlerOptions options = SchemaCrawlerOptionBuilder.tablecolumns(new IncludeAll());
	/** 数据库Schema获取操作配置，扩展InclusionRule不方便设置问题 */
	private SchemaCrawlerInclusionRules rules = new SchemaCrawlerInclusionRules();

	public DatabaseType getType() {
		return type;
	}

	public void setType(DatabaseType type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SchemaCrawlerOptions getOptions() {
		return options;
	}

	public void setOptions(SchemaCrawlerOptions options) {
		this.options = options;
	}

	public SchemaCrawlerInclusionRules getRules() {
		return rules;
	}

	public void setRules(SchemaCrawlerInclusionRules rules) {
		this.rules = rules;
	}

	public DatabaseConnectionOptions toConnectionOptions() throws SchemaCrawlerException {
		final DatabaseConnectionOptions connectionOptions = new DatabaseUrlConnectionOptions(getUrl());
		return connectionOptions;
	}
}
