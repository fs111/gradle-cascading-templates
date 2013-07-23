buildscript {
	repositories {
        mavenLocal()
        ivy {
            artifactPattern 'http://tellurianring.com/projects/gradle-plugins/[module]/[revision]/[artifact]-[revision].[ext]'
                ivyPattern 'http://tellurianring.com/projects/gradle-plugins/[module]/[revision]/[artifact]-[revision].[ext]'
        }
 
	}
	dependencies {
		classpath "cascading:gradle-cascading-templates:1.0-wip-dev"
        classpath 'gradle-templates:gradle-templates:1.3'
	}
}
// Check to make sure templates.TemplatesPlugin isn't already added.
if (!project.plugins.findPlugin(templates.CascadingTemplatesPlugin)) {
	project.apply(plugin: templates.CascadingTemplatesPlugin)
}
