<%@ page pageEncoding="utf-8"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<title>board</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/ui.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resource/framework/CLEditor1_3_0/jquery.cleditor.css'/>"/>

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
jQuery.browser = {};
(function () {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        jQuery.browser.version = RegExp.$1;
    }
})();
</script>
	
<script src="/resource/framework/CLEditor1_3_0/jquery.cleditor.js"></script>
<script src="/resource/framework/CLEditor1_3_0/jquery.cleditor.min.js"></script>
<script src="/resource/framework/CLEditor1_3_0/jquery.cleditor.table.min.js"></script>

