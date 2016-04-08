<%@ attribute name="value" required="true" %>

<input type="text" id="${value}" name="${value}" />
<script>
	$("#${value}").datepicker({dateFormat:"dd/mm/yy"});
</script> 