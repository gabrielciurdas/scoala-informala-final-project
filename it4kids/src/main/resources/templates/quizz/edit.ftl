  
  [#ftl]
<p><b>Question List
</p>

<fieldset>
  	<legend>Add Question</legend>
  <form action="edit/add" method="POST">
 	Question: <input type="text" name="text" value="${(quizEntry.text)!''}" />	<br/>
  	<input type="submit" value="   Save   " />
  	<input type="hidden" name="id" value="${(quiz.id)!''}" />
  	<a href="/index">Back to quiz</a>
  </form>
  </fieldset>
  <br/>
  <table class="datatable">

  	<tr>
  		<th>Questions</th>
  		<th></th>
  	</tr>
    [#list quiz.questions as quizEntry]

  	<tr>
  		<td>${(quizEntry.text)!''}</td>
  		<td><a href=""/delete?id=${quizEntry.id?c}"">Delete</a>&nbsp;<a href="edit?id=${quizEntry.id?c}">Edit</a>
  	</tr>
    [/#list]
  </table>
  
 