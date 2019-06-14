<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>

<script type="text/javascript">

	$( document ).ready(function() {
		$("#feedback").fadeTo(2000, 500).slideUp(500, function(){
		    $("#feedback").slideUp(500);
		});
	});
	
</script>
	
<div id="feedback">
	<c:if test="${feedback != null}">
		<div class="alert alert-success" role="alert">
		  ${feedback}
		</div>
	</c:if>
</div>
	
<c:remove var="feedback"/>
