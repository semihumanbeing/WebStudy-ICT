<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="//cdn.ckeditor.com/4.19.0/basic/ckeditor.js"></script>
<meta charset="UTF-8">
<style type="text/css">
#box {
	width: 500px;
	margin: auto;
	margin-top: 50px;
}
textarea{
	width: 100%;
	resize: none;
}
</style>

<script type="text/javascript">
var toolbar = {toolbarGroups : [
    { name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
    { name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
    { name: 'links', groups: [ 'links' ] },
    { name: 'insert', groups: [ 'insert' ] },
    '/',
    { name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
    { name: 'styles', groups: [ 'styles' ] },
    { name: 'colors', groups: [ 'colors' ] },
    { name: 'tools', groups: [ 'tools' ] },
    { name: 'others', groups: [ 'others' ] },
    { name: 'about', groups: [ 'about' ] },
    { name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
    { name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
    { name: 'forms', groups: [ 'forms' ] },
],
removeButtons : 'Cut,Copy,Paste,PasteText,PasteFromWord,Find,SelectAll,Scayt,Replace,Save,NewPage,ExportPdf,Print,Templates,Form,Checkbox,Radio,TextField,Textarea,Select,Button,ImageButton,HiddenField,CreateDiv,Blockquote,BidiLtr,BidiRtl,Language,RemoveFormat,CopyFormatting,Anchor,Flash,PageBreak,About',
}
function send(f){
	var name = f.name.value.trim();
	var content = CKEDITOR.instances.content.getData();
	var pwd = f.pwd.value.trim();
	
	if(name==''){
		alert('이름을 입력하세요');
		f.name.value='';
		f.name.focus();
		return;
	}
	if(content==''){
		alert('내용을 입력하세요');
		f.content.value='';
		f.content.focus();
		return;
	}
	if(pwd==''){
		alert('비밀번호를 입력하세요');
		f.pwd.value='';
		f.pwd.focus();
		return;
	}
	
	f.action="insert.do";
	f.submit();
	
}

</script>
<title>Insert title here</title>

</head>
<body>
	<form>
		<div id="box">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>방명록 쓰기</h4>
				</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>이름</th>
							<td><input name="name"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td>
							<textarea name="content" rows="5" cols="50"></textarea>
								<script>
	                       			 CKEDITOR.replace( 'content' , toolbar);
	               				</script>
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input name="pwd" type="password"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<input class="btn btn-primary" type="button" value="등록하기" 
							onclick="send(this.form);"> 
								<input class="btn btn-success" type="button" value="목록보기" 
								onclick="location.href='list.do'"></td>
						</tr>
					</table>

				</div>
			</div>
		</div>

	</form>
</body>
</html>