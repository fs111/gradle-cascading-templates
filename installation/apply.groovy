buildscript {
	repositories {
		ivy {
			name = 'gradle_templates'
			artifactPattern 'http://tellurianring.com/projects/gradle-plugins/[module]/[revision]/[artifact]-[revision].[ext]'
			ivyPattern 'http://tellurianring.com/projects/gradle-plugins/[module]/[revision]/[artifact]-[revision].[ext]'
		}
        mavenRepo name: 'conjars', url: 'http://conjars.org/repo/'
        mavenLocal()

	}
	dependencies {
		classpath "cascading:gradle-cascading-templates:1.0-wip-dev"
		classpath 'gradle-templates:gradle-templates:1.3'
	}
}

if (!project.plugins.findPlugin(templates.CascadingTemplatesPlugin)) {
	project.apply(plugin: templates.CascadingTemplatesPlugin)
}
