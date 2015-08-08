var Controller = function (view, model) {
        var _view = view;
        var _model = model;

        // event binding
        //we can use either .bind or .on, bcoz internally bind resolves to on
        $('body').on('addItem', function(e) {   //when on, addItem, call the addTodo of the model
           _model.addTodo( e.todo );
        });
         $('body').on('deleteItem', function(e) {
           _model.deleteTodo( e.index );
        });
        $('body').on('updateView', function(e) {
            _view.updateView( _model.getData() );
        });
};
