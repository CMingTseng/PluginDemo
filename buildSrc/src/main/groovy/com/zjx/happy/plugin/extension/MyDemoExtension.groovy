package com.zjx.happy.plugin.extension


import com.zjx.happy.plugin.configuration.PluginConfigDetalOne
import com.zjx.happy.plugin.configuration.PluginConfigDetalTwo
import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project

class MyDemoExtension {
    static final String PLUGIN_NAME = "MyDemoOptional"
    Project project
    boolean enabled = false
    String plugin_config_string
    static final String DEFAULT_KEY = '1234567800000000'
    NamedDomainObjectContainer<PluginConfigDetalOne> plugin_config_detal_one
    //FIXME  the value is  proxycore
    PluginConfigDetalTwo proxycore = new PluginConfigDetalTwo()
    File archiveOutput
    File tempOutput

    MyDemoExtension(Project project, NamedDomainObjectContainer<PluginConfigDetalOne> types) {
        this.project = project
        plugin_config_string = DEFAULT_KEY
        this.plugin_config_detal_one = types
        archiveOutput = new File(project.rootProject.buildDir, "archives")
        tempOutput = new File(project.rootProject.buildDir, "temp")
    }

    void plugin_config_detal_one(Action<NamedDomainObjectContainer<PluginConfigDetalOne>> action) {
        action.execute(plugin_config_detal_one)
    }

    void plugin_config_detal_two (Action<? super PluginConfigDetalTwo> action) {
        action.execute(proxycore)
    }
}
