define([
	"dojo/_base/declare",
	"dojo/_base/lang",
	"dojo/json",
	"dojo/io/script",
	"dojo/request/xhr",
	"dijit/layout/ContentPane",
	"dijit/form/Button",
	"icm/base/BasePageWidget",
	"icm/base/_BaseWidget",
	"ecm/model/Request",
	"ecm/widget/HoverHelp",
	"dojo/text!./templates/ICMTweetWidget.html"
], function(declare, lang, json, jsonp, xhr, ContentPane, Button, 
			BasePageWidget, _BaseWidget, Request, HoverHelp, template){
	return declare("icmtweet.pgwidget.ICMTweetWidget", [_BaseWidget, BasePageWidget], {
		templateString: template,
		widgetsInTemplate: true,
		description: "BlueMix Twitter Insights",
		tweetResults: "", //this is what broke the html page
		
		postCreate: function(){
			
		},
		
		_onClickTweet: function() {
			var searchHashtag = this.hashtagSearch.value;
			Request.invokePluginService("ICMTweetPlugin", "TwitterService", {
				requestParams: {
					searchTerm: this.hashtagSearch.value
				},
				requestCompleteCallback: lang.hitch(this, function(response) {
					this.tweetWidgetResults.innerText = "These are the tweet results: " + response.results;
				}),
				requestFailedCallback: function(response){
					
				}
			});
			
		}
	});
});
