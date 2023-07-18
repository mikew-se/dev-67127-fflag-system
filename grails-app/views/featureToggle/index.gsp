<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <td>Name</td>
                    <td>Systems</td>
                </tr>
            </thead>
            <tbody>
                <g:each in="${featureToggles}" var="atoggle">
                    <tr>
                        <td>${atoggle.toggleKey}</td>
                        <td>
                            <ul>
                                <g:each in="${atoggle.systemEnums}" var="asystem">
                                    <li>${asystem}</li>
                                </g:each>
                            </ul>
                        </td>
                    </tr>
                </g:each>
            </tbody>
        </table>

</body>
</html>