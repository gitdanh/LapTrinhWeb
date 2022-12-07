package vn.book.Config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/decorators/web.jsp")
				.addDecoratorPath("/admin/*", "/decorators/admin.jsp")
				.addExcludedPath("/login").addExcludedPath("/login/*")
				.addExcludedPath("/adminlogin").addExcludedPath("/adminlogin/*");
	}
	
}
