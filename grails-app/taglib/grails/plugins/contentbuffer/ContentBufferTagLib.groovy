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
package grails.plugins.contentbuffer

import org.codehaus.groovy.grails.web.pages.FastStringWriter
import org.codehaus.groovy.grails.web.sitemesh.GSPSitemeshPage
import org.codehaus.groovy.grails.web.util.GrailsPrintWriter
import org.codehaus.groovy.grails.web.util.StreamCharBuffer

class ContentBufferTagLib {

    def content = {attrs, body->
        if(! attrs.tag) {
            out << "Tag [content] missing required attribute [tag]"
            return
        }
        if(attrs.id && request[attrs.id]) {
            return null
        }
        def htmlPage = getPage()
        def propertyName = attrs.tag.toString()
        def contentBuffer = null
        if(htmlPage instanceof GSPSitemeshPage) {
            // check if there is an component content buffer
            contentBuffer = htmlPage.getContentBuffer('page.' + propertyName)
        } else {
            throwTagError("Tag [content] requires 'grails.views.gsp.sitemesh.preprocess = true' -mode")
        }
        if(contentBuffer == null) {
            contentBuffer = wrapContentInBuffer(body)
            htmlPage.setContentBuffer(propertyName, contentBuffer)
        } else {
            new GrailsPrintWriter(contentBuffer.writer) << body()
        }
        if(attrs.id) {
            request[attrs.id] = true
        }
        return null
    }

    protected getPage() {
        return request[org.codehaus.groovy.grails.web.sitemesh.GrailsPageFilter.GSP_SITEMESH_PAGE]
    }

    protected wrapContentInBuffer(content) {
        if(content instanceof Closure) {
            content = content()
        }
        if(!(content instanceof StreamCharBuffer)) {
            // the body closure might be a string constant, so wrap it in a StreamCharBuffer in that case
            def newbuffer = new FastStringWriter()
            newbuffer.print(content)
            content = newbuffer.buffer
        }
        return content
    }
}
