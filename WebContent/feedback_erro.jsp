<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>

<script type="text/javascript">

	$( document ).ready(function() {
		$("#feedback_erro").fadeTo(2000, 500).slideUp(500, function(){
		    $("#feedback_erro").slideUp(500);
		});
	});
	
</script>
	
<div id="feedback_erro">
	<c:if test="${feedback_erro != null}">
		<div class="alert alert-danger" role="alert">
		  ${feedback_erro}
		</div>
	</c:if>
</div>
	
<c:remove var="feedback_erro"/>
