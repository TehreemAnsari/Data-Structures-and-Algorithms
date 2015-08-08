/*Backbonejs is not a hard core MVC Framework.
In other words you could reside your logic into the View 
that plays role of Controller in true MVC frameworks.
*/
(function($){
/*Backbone.sync is the function that Backbone calls every 
time it attempts to read or save a model to the server.*/
Backbone.sync = function(method, model, success, error){
    success();
}

var Item = Backbone.Model.extend({});
var List = Backbone.Collection.extend({
    model: Item
});

var ItemView = Backbone.View.extend({
    events: {
        'click .js-delete': 'remove'
    },
 
    template: _.template($('#itemViewTemplate').html()),
  
  	// initialize() is triggered whenever you create a new instance
    initialize: function(){
        this.listenTo(this.model, 'change', this.render);
        this.listenTo(this.model, 'remove', this.unrender);
    },
    
    render: function() {
    	this.$el.html(this.template(this.model.toJSON()));
        return this;
    },
    
    unrender: function(){
        this.$el.remove();
    }
});


var ListView = Backbone.View.extend({  
    events: {
       'click .js-addItem': 'addItem'
    },
            
    initialize: function(){
        this.listenTo(this.collection, 'add', this.appendItem);
    },
    
    render: function(){
        this.collection.each(this.appendItem, this);
        return this;
    },
    
    addItem: function(){
        var $input = this.$('input#taskBox')
        var val = $input.val();
      
        this.collection.add({part: val});
        
        // clear input                        
        $input.val('');            
    },

    appendItem: function(item){
        var itemView = new ItemView({
            model: item,
            template: this.template
        });
        
        this.$('#appendToSpan').append(itemView.render().el);
    }
});
	
// Initialize widget and empty collection
var listView = new ListView({
    el: 'body',
    collection: new List()
});

// Render collection
listView.render();

})(jQuery);
