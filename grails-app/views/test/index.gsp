<html>
  <head>
    <meta name="layout" content="main" />
    <title>Test page</title>
  </head>
  <body>
    <h1>This is the main page</h1>
    <g:render template="part1" model="${[message:'Part 1']}"/>
    <g:render template="part2" model="${[message:'Part 2']}"/>
    <g:render template="part3" model="${[message:'Part 3']}"/>
  </body>
</html>
