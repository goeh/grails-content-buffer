<h1>This is rendered by ${message}</h1>
<g:content tag="head">
  <script type="text/javascript">
    function part1func() {
      return "${message}";
    }
    </script>
</g:content>
<g:content tag="top">
  <h1>This is rendered by part1 and should be located at the top of the page</h1>
</g:content>