package com.zjx.happy.plugin.factory

import com.zjx.happy.plugin.configuration.PluginConfigDetalOne
import org.gradle.api.NamedDomainObjectFactory
import org.gradle.internal.reflect.Instantiator

//Ref : https://android.googlesource.com/platform/tools/build/+/c4f572d8dd9664c63a04f48a99b79acfb9513de9/gradle/src/main/groovy/com/android/build/gradle/internal/dsl/SigningConfigFactory.groovy
//Ref : https://www.shuzhiduo.com/A/kvJ3Y4Nwdg/
//Ref : https://zhuanlan.zhihu.com/p/68933775
class EncryptTypeFacotory implements NamedDomainObjectFactory<PluginConfigDetalOne> {
    private Instantiator instantiator

    EncryptTypeFacotory(Instantiator instantiator) {
        this.instantiator = instantiator
    }

    @Override
    PluginConfigDetalOne create(String name) {
        return instantiator.newInstance(PluginConfigDetalOne.class, name)
    }
}
