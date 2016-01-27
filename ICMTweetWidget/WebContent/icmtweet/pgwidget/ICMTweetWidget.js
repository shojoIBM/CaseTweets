define([
	"dojo/_base/declare",
	"dojo/_base/lang",
	"dojo/json",
	"dojo/io/script",
	"dojo/request/xhr",
	"icm/base/BasePageWidget",
	"icm/base/_BaseWidget",
	"ecm/model/Request",
	"ecm/widget/HoverHelp",
	"dojo/text!./templates/ICMTweetWidget.html",
	"dijit/form/Button"
], function(declare, lang, json, jsonp, xhr, BasePageWidget, _BaseWidget, Request, HoverHelp, template){
	return declare("icmtweet.pgwidget.ICMTweetWidget", [_BaseWidget, BasePageWidget], {
		templateString: template,
		description: "BlueMix Twitter Insights",
		
		
		//SEARCH BOX
		message: "Please_input the hashtag you'd like to search for",
		
		tweetResults: "",
		
		postCreate: function(){
			
		},
		
		_onClickTweet: function() {
			this.tweetButton.style.background = "red";
			
			//dojo.byId("tweetResults").innerText = "These are the tweet results";
			
			//using a call to ICN plugin service
			Request.invokePluginService("ICMTweetPlugin", "TwitterService", {
				requestParams: {
					//configAction: ""
				},
				requestCompleteCallback: lang.hitch(this, function(response) {
					//do something after the results have been retrieved.. the results are contained in the response param
					this.tweetButton.style.background = "green";
					this.tweetResults = "These are the tweet results";
					this.tweetWidgetResults.innerText = this.tweetResults + ": ->" + response.results;
				}),
				requestFailedCallback: function(response){
					var something = response;
				}
			});
			
//			xhr("https://9703b749-0d64-4fc6-a0c2-57af929c69e9:zHZ54TpZym@cdeservice.mybluemix.net:443/api/v1/messages/search?q=IBMECM&size=1",{
//				handleAs:"json"
//			}).then(function(data) {
//				console.log(data);
//			}, function (err) {
//				
//			}, function (evt) {
//				
//			});
			
//			var jsonpArgs = {
//					url:"https://9703b749-0d64-4fc6-a0c2-57af929c69e9:zHZ54TpZym@cdeservice.mybluemix.net:443/api/v1/messages/search?q=IBMECM&size=1",
//					callbackParamName: "callback",
//					content: {
//						v:"1.0",
//						q:"dojo toolkit"
//					},
//					load: function(data) {
//						console.log(data);
//					},
//					error: function(error) {
//						console.log(error);
//					}
//			};
//			jsonp.get(jsonpArgs);
		}
	});
});
