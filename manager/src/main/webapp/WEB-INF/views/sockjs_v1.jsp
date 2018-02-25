<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Websocket Sockjs v1</title>

    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
</head>
<body>
<div>
    <button id="websocket_start">开始对话</button>
</div>

<script type="text/javascript">

    $(document).ready(
        $("#websocket_start").click(function() {
            var url = 'ws://127.0.0.1:8080/websocket/marco/v1';
            var sock = new WebSocket(url);

            sock.onopen = function () {
                console.log('Opening');
                sayMarco();
            };

            sock.onmessage = function (e) {
                console.log('Received message: ', e.data);
                setTimeout(function () {
                    sayMarco()
                }, 2000);
            };

            sock.onclose = function () {
                console.log('Closing');
            };

            function sayMarco() {
                console.log('Sending Marco!');
                sock.send("Marco!");
            }
        })
    )
</script>

</body>
</html>
