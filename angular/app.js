
Storage.prototype.setObject = function(key, value) {
    this.setItem(key, JSON.stringify(value));
}

Storage.prototype.getObject = function(key) {
    var value = this.getItem(key);
    return value && JSON.parse(value);
}

var app = angular.module('tasks_list',[]);

app.controller('TasksController',['$scope', function($scope){

	$scope.list = localStorage.getObject('memoList');

		$scope.addTask = function(newTask) {
    	var newMemo = { text:newTask, done:false };
    	$scope.newTask="";
    	
    	if ($scope.list === null ) {
    		$scope.list = [newMemo];
    	} else {
			$scope.list.push(newMemo);
    	}

        localStorage.setObject('memoList',$scope.list);
    };

    $scope.deleteTask = function()
    {		
        if ($scope.list === null ) 
        {
    		alert("No task to delete..");
    	} 

    	else
    	{
        	var taskList=$scope.list;
        	$scope.list=[];
    		
	    	angular.forEach(taskList, function(todo) {
		      	if (!todo.done) 
		      	{
		      		$scope.list.push(todo);
		        }
	        });
    	}
    	localStorage.setObject('memoList',$scope.list);
    };

}]);
