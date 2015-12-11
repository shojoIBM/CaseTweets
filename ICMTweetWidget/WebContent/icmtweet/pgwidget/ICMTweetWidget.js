define([
	"dojo/_base/declare",
	"dojo/json",
	"icm/base/BasePageWidget",
	"icm/base/_BaseWidget",
	"dojo/text!./templates/ICMTweetWidget.html",
	"dijit/form/Button"
], function(declare, json, BasePageWidget, _BaseWidget, template){
	return declare("icmtweet.pgwidget.ICMTweetWidget", [_BaseWidget, BasePageWidget], {
		templateString: template,

		postCreate: function(){
			var test = "this is a test for git";
		}
	});
});
