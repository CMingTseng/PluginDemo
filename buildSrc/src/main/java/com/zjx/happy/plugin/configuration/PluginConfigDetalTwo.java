package com.zjx.happy.plugin.configuration;

import com.google.common.collect.Sets;

import com.android.annotations.NonNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class PluginConfigDetalTwo {
    private static final String DEFAULT_PROXY_CORE_NAME = "proxy_core";
    private static final Set<String> DEFAULT_PROXY_CORE_DEPENDENCIES = new HashSet<>(Arrays.asList("utils_yyy", "utils_xxxx", "utils_aaa", "utils_qqq"));
    String name;
    String plugin_config_detail_string;
    //Ref : http://grails.asia/groovy-set-examples
    //FIXME No such property: Sets for class:
    @NonNull
    private Set<String> plugin_config_detail_string_dependencies;

    private boolean enable = false;

    protected PluginConfigDetalTwo() {
        this.plugin_config_detail_string_dependencies = getDefaultValues();
    }

    public Set<String> getDefaultValues() {
        Set<String> values = Sets.newHashSet();
        for (String abi : DEFAULT_PROXY_CORE_DEPENDENCIES) {
            values.add(abi);

        }
        return values;
    }
}
