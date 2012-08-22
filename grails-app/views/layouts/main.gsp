<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <meta name="layout" content="main" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title><g:layoutTitle default="${message(code:'app.name')}"/></title>
    <g:layoutHead/>
    <g:pageProperty name="page.head" />
  </head>
  <body>
    <g:pageProperty name="page.top" />
    <h1>This is the top of application layout</h1>
    <g:layoutBody/>
    <h1>This is the bottom of application layout</h1>
    <g:pageProperty name="page.bottom" />
  </body>
</html>
