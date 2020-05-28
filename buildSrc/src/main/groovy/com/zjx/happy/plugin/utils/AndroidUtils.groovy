package com.zjx.happy.plugin.utils

import com.android.build.gradle.*
import org.gradle.api.GradleException
import org.gradle.api.Project

class AndroidUtils {
    static boolean isAndroidPlugin(Project project) {
        def isAndroidApp = project.plugins.withType(AppPlugin)
        def isAndroidLib = project.plugins.withType(LibraryPlugin)
        //FIXME Note : AppExtension --> applicationVariants  & LibraryExtension --> libraryVariants
        if (isAndroidApp) {
            project.task("ApplicationType") {
                doFirst() {
                    println 'This is custom plugin ApplicationType start '
                }
                println('/***************************/')
                println('/*** --- ApplicationType --- ***/')
                println('/***************************/')
                println('**********  at sub-project : ' + project.name + ' **********')
                doLast() {
                    println 'This is custom plugin ApplicationType end '
                }
            }
            return isAndroidApp
        } else if (isAndroidLib) {
            project.task("LibraryType") {
                doFirst() {
                    println 'This is custom plugin LibraryType start '
                }
                println('/***************************/')
                println('/*** --- LibraryType --- ***/')
                println('/***************************/')
                println('**********  at sub-project : ' + project.name + ' **********')
                doLast() {
                    println 'This is custom plugin LibraryType end '
                }
            }
            return isAndroidLib
        } else {
            throw new GradleException("the android plugin 'com.android.application' or 'com.android.library' plugin required.")
//            throw new ProjectConfigurationException("the android plugin 'com.android.application' or 'com.android.library'", null)
        }
    }
}

