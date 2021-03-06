package cn.dovefly.maven.plugin.startup;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import cn.dovefly.maven.plugin.FreeMarkerUtil;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * 代码生成
 *
 * @goal generate
 * @phase none
 */
public class MyCodeGeneratorMojo extends AbstractMojo {

    /**
     * Location of the config file.
     * @required
     * @parameter defaultValue = "/generatorConfig.properties"
     */
    private String configFile;

    public void execute() throws MojoExecutionException {
        getLog().info( "代码开始生成。。。" );
        FreeMarkerUtil.generateFiles(configFile);
        getLog().info( "代码生成完成。。。" );
    }

    /**
     * <configuration>
     <port>8090</port>
     </configuration>
     */
}
