/*
 * Copyright (C) 2012-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pf4j;

import java.nio.file.Path;

/**
 * Load all information (classes) needed by a plugin.
 *
 * PluginLoader 是 pf4j 实现的核心方法，主要的思路是通过 classloader 来对插件进行隔离。需要处理的几个难点
 *     * 默认 classloader 的双亲委派机制的处理
 *     * 插件之间相互依赖和调用的处理
 *
 * @author Decebal Suiu
 */
public interface PluginLoader {

    /**
     * Returns true if this loader is applicable to the given {@link Path}.
     *
     * @param pluginPath
     * @return
     */
    boolean isApplicable(Path pluginPath);

    ClassLoader loadPlugin(Path pluginPath, PluginDescriptor pluginDescriptor);

}
