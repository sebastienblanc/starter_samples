<#import "/spring.ftl" as spring />
<#assign xhtmlCompliant = true in spring>
<!DOCTYPE html>
<html>
<body>

<h1>Other Page</h1>


<h2>Products</h2>
<ul>
<#list products as product>
    <li>${product}</li>
</#list>
</ul>

<a href="/logout">logout</a>
</body>

</html>