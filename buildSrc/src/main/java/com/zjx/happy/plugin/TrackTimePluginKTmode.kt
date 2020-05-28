package com.zjx.happy.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionContainer
//Ref : https://github.com/JLLeitschuh/ktlint-gradle/issues/239
//Ref : http://geek5nan.github.io/2019/09/07/Developing-Gradle-Plugin-1/
//Ref : https://www.thedroidsonroids.com/blog/how-to-create-gradle-plugin-in-kotlin
//Ref : package com.android.build.gradle.BasePlugin.kt
//Ref : package com.android.build.gradle.AppPlugin.kt

class TrackTimePluginKTmode : Plugin<Project> {
    private lateinit var project: Project

    override fun apply(project: Project) {
        this.project = project

    }


}

