define([
	"dojo/_base/declare",
	"dojo/json",
	"dojo/request/xhr",
	"icm/base/BasePageWidget",
	"icm/base/_BaseWidget",
	"ecm/model/Request",
	"dojo/text!./templates/ICMTweetWidget.html",
	"dijit/form/Button"
], function(declare, json, xhr, BasePageWidget, _BaseWidget, Request, template){
	return declare("icmtweet.pgwidget.ICMTweetWidget", [_BaseWidget, BasePageWidget], {
		templateString: template,
		description: "some OTHER random widget",
		message: "Please input the hashtag you'd like to search for",
		tweetResults: "",
		
		postCreate: function(){
			
		},
		
		_onClickTweet: function() {
			this.tweetButton.style.background = "red";
			this.tweetResults = "These are the tweet results";
			this.tweetWidgetResults.innerText = this.tweetResults;
			//dojo.byId("tweetResults").innerText = "These are the tweet results";
			
			//using dojo xhr
			xhr("https://9703b749-0d64-4fc6-a0c2-57af929c69e9:zHZ54TpZym@cdeservice.mybluemix.net:443/api/v1/messages/search?q=IBMECM&size=1", {
				handleAs: "json"
			}).then(function(data){
				
			});
			
			//using a call to ICN plugin service
			Request.invokePluginService("ICMTweetPlugin", "TwitterService", {
				requestParams: {
					configAction: ""
				},
				requestCompleteCallback: lang.hitch(this, function(response) {
					//do something after the results have been retrieved.. the results are contained in the response param
				})
			});
		}
	});
});
