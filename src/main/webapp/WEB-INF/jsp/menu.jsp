<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

	<link rel="stylesheet" href="resources/css/custom.css">

	<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<title>
		Информация о событиях
	</title>
</head>
<body>
	<header>
		<hgroup>
			<h1>
				Информация о событиях
			</h1>
		</hgroup>
	</header>

	<a name="downlist" href="javascript:void(0);">Загрузить данные в БД</a>

	<div id="fountainG" style="display:none">
		<div id="fountainG_1" class="fountainG"></div>
		<div id="fountainG_2" class="fountainG"></div>
		<div id="fountainG_3" class="fountainG"></div>
		<div id="fountainG_4" class="fountainG"></div>
		<div id="fountainG_5" class="fountainG"></div>
		<div id="fountainG_6" class="fountainG"></div>
		<div id="fountainG_7" class="fountainG"></div>
		<div id="fountainG_8" class="fountainG"></div>
	</div>

	<div id="downlist" style="display:none">
		<ul>
			<li>
				<a href="/start/report1">
					Список пользователей и используемых ими форм за последний час
				</a>
			</li>
			<li>
				<a href="/start/report2">
					Список пользователей, которые начали активность на форме и не дошли до конца
				</a>
			</li>
			<li>
				<a href="/start/report3">
					Список из 5 самых используемых форм
				</a>
			</li>
		</ul>
	</div>

	<script type="text/javascript">
        $('a[name=downlist]').click(function(){
            $fG = $('#fountainG');
            $fG.show();
            $.ajax({
                url:"/start/prepare",
                success:function(data) {
                    $('#downlist').show(200);
                    alert('В БД загружено '+ data + ' Записей');
                    $fG.hide();
                },
                error : function(error) {
                    $('#downlist').hide(200);
                    alert('Данные не были загружены');
                }

            });

        });
	</script>


</body>
</html>