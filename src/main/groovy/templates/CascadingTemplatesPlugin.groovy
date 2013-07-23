package templates

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Adds basic tasks for bootstrapping Cascading projects. Adds 
 * createCascadingProject tasks.
 */
class CascadingTemplatesPlugin implements Plugin<Project> {

	/**
	 * Creates the basic Cascading project directory structure.
	 * @param path the root of the project. Optional,defaults to user.dir.
	 */
	void createBase(String path = System.getProperty('user.dir')) {
		ProjectTemplate.fromRoot(path) {
			'src' {
				'main' {
					'java' {}
					'resources' {}
				}
				'test' {
					'java' {}
					'resources' {}
				}
			}
			'LICENSE.txt' '// Your License Goes here'
		}
	}


	void apply(Project project) {

        //project.apply(plugin: templates.TemplatesPlugin)

		def props = project.properties


		project.task('createCascadingProject', group: TemplatesPlugin.group, description: 'Creates a new Gradle Cascading project in a new directory named after your project.') << {
			def projectName = props['newProjectName'] ?: TemplatesPlugin.prompt('Project Name:')
			if (projectName) {
				String projectGroup = props['projectGroup'] ?: TemplatesPlugin.prompt('Group:', projectName.toLowerCase())
				String projectVersion = props['projectVersion'] ?: TemplatesPlugin.prompt('Version:', '1.0')
				createBase(projectName)
				ProjectTemplate.fromRoot(projectName) {
					'build.gradle' template: '/templates/cascading/build.gradle.tmpl', projectGroup: projectGroup
					'gradle.properties' content: "version=$projectVersion", append: true
					'src/main/java/Main.java' template: '/templates/cascading/Main.java.tmpl', projectGroup: projectGroup
				}
			} else {
				println 'No project name provided.'
			}
		}
	}
}
