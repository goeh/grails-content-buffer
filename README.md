#Content Buffer Plugin

This Grails plugin provide a taglib method called 'content'. It is used to insert page fragments anywhere in a GSP before it is rendered.
The standard sitemesh content tag does not support appending content, this plugin does.
Templates included with the render tag can also append content to sections in the layout.

Use this plugin to append page fragments to pre-defined sections in your layout template.
Example:

Add this in the head section of your layout:

    <head>
      <g:pageProperty name="page.head" />
    </head>

Add this in a sidebar div in your layout:

    <div style="float:right;">
      <g:pageProperty name="page.sidebar" />
    </div>

Then all the GPSs that are included on the page can put content into the <head> section and the sidebar div.
index.gsp:

    <g:content tag="head">
      <script type="text/javascript">
        function myFunc() {
          alert("Hello World");
        }
      </script>
    </g:content>

    <g:content tag="sidebar">
      <p>This message will be displayed in the sidebar</p>
    </g:content>

    <g:render template="foo"/>

And the foo template contains:

    _foo.gsp:
    <g:content tag="sidebar">
      <p>This message will also be displayed in the sidebar</p>
    </g:content>

---------------------------------------

Sitemesh has a built-in feature like this using it's <content> tag.
But it will overwrite existing content in the specified page property.
The content-buffer plugin makes it possible to append as much content as you like to a page property.
Then you let the layout render it to the final page.

---------------------------------------

## Version history

*1.0.2* Compatible with Grails 2.4.4

*1.0.1* Compatible with Grails 2.2.4

*1.0.0* Initial revision