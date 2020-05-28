package com.zjx.happy.plugin


import com.zjx.happy.plugin.configuration.PluginConfigDetalOne
import com.zjx.happy.plugin.extension.MyDemoExtension
import com.zjx.happy.plugin.factory.EncryptTypeFacotory
import com.zjx.happy.plugin.utils.AndroidUtils
import javassist.ClassPool
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator
import org.gradle.invocation.DefaultGradle

class AndroidTypeDemoPlugin implements Plugin<Project> {
    private Project mProject
    private static ClassPool mPool
    private Instantiator instantiator
    MyDemoExtension extension

    @Override
    void apply(Project project) {
        mProject = project
        mPool = ClassPool.getDefault()
        if (AndroidUtils.isAndroidPlugin(mProject)) {
            println 'Show  dependOn/input/output  info  @ Android DemoPlugin  '
            instantiator = ((DefaultGradle) project.gradle).services.get(Instantiator.class)
            NamedDomainObjectContainer<PluginConfigDetalOne> types = project.container(PluginConfigDetalOne.class, new EncryptTypeFacotory(instantiator))
            extension = project.extensions.create(MyDemoExtension.PLUGIN_NAME, MyDemoExtension.class, project, types)
            project.task("show_property_detail message") {
                doLast {
                    def MyDemo = project.MyDemoOptional
                    println " info : -> ${MyDemo.plugin_config_string}"
                    def proxyC = MyDemo.proxycore
                    println "PluginConfigDetalTwo info   : -> ${proxyC.plugin_config_detail_string}"
                    def etypes = MyDemo.plugin_config_detal_one
                    etypes.each {
                       println "type info JNI ?  -> ${it.isUseJNI}"
                    }
                }
            }
        }
    }
}