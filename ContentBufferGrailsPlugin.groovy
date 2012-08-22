/*
 * Copyright 2012 Goran Ehrsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class ContentBufferGrailsPlugin {
    // the plugin version
    def version = "1.0.1"
    def license = "APACHE"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.2.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/controllers/**/*",
        "grails-app/views/**/*"
    ]

    def author = "Goran Ehrsson"
    def authorEmail = "goran@technipelago.se"
    def title = "GSP Content Buffer"
    def description = '''
This plugin provide a taglib method called 'content'.
It is used to insert page fragments anywhere in a GSP before it is rendered.
The standard sitemesh content tag does not support appending content, this plugin does.
Templates included with the render tag can also append content to sections in the layout.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/content-buffer"

    def organization = [name: "Technipelago AB", url: "http://www.technipelago.se/"]
    def issueManagement = [system: "github", url: "https://github.com/goeh/grails-content-buffer/issues"]
    def scm = [url: "https://github.com/goeh/grails-content-buffer"]
}
