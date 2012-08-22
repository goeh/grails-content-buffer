<h1>This is rendered by ${message}</h1>
<g:content tag="head">
  <script type="text/javascript">
    function part3func() {
      return "${message}";
    }
    </script>
</g:content>
<g:content tag="bottom">
  <h1>This is rendered by part3 and should be located at the bottom of the page</h1>
  <p>View this HTML source and look at the &lt;head&gt; section, you should see three javascript functions named part1func, part2func and part3func.</p>
</g:content>