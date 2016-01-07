package com.ibm.icm.extension.custom.plugin;
import java.util.Locale;

import com.ibm.ecm.extension.Plugin;
import com.ibm.ecm.extension.PluginAction;
import com.ibm.ecm.extension.PluginRequestFilter;
import com.ibm.ecm.extension.PluginResponseFilter;
import com.ibm.ecm.extension.PluginService;

public class ICMTweetPlugin extends Plugin {
	
	private PluginRequestFilter[] pluginRequestFilters = new PluginRequestFilter[0];
	private PluginResponseFilter[] pluginResponseFilters = new PluginResponseFilter[0];
	private PluginService[] pluginServices = new PluginService[0];

	@Override
	public String getId() {
		return "ICMTweetPlugin";
	}

	@Override
	public String getName(Locale arg0) {
		return "IBM Case Manager Custom plug-in";
	}

	@Override
	public String getVersion() {
		return "1.0.1";
	}

	@Override
	public PluginAction[] getActions() {
		return new PluginAction[] {};
	}

	@Override
	public String getScript() {
		return "ICMTweetPlugin.js";
	}

	@Override
	public String getDojoModule() {
		return null;
	}

	@Override
	public String getCSSFileName() {
		return "ICMTweetPlugin.css";
	}

	/** Provides a list of services that are provided by this plug-in. The
	 * services run on the web server, and can be called by the web browser
	 * logic component of the plug-in.
	 * 
	 * @return An array of {@link com.ibm.ecm.extension.PluginService
	 *         PluginService} objects. The plug-in should return the same set of
	 *         objects on every call. If there are no services defined by the
	 *         plug-in, the call should return an empty array.
	 */
	public PluginService[] getServices() {
		if (pluginServices.length == 0) {
			pluginServices = new PluginService[] {new com.ibm.icm.extension.custom.plugin.TwitterService()};
		}
		return pluginServices;
	}
	
	/**
	 * Provides a list of filters that are run before a requested service. This
	 * method can be used to modify the request or block the request.
	 * 
	 * @return An array of
	 *         <code>{@link com.ibm.ecm.extension.PluginRequestFilter PluginRequestFilter}</code>
	 *         objects.
	 */	
//	public PluginRequestFilter[] getRequestFilters() {
//		if (pluginRequestFilters.length == 0) {
//			pluginRequestFilters = new PluginRequestFilter[] {new com.ibm.ecm.extension.ColumnsDisplayedRequestFilter()};
//		}
//		return pluginRequestFilters;
//	}

	/**
	 * Provides a list of filters that are run after a requested service. This
	 * list of filters can be used to modify the response that is returned.
	 * 
	 * @return An array of
	 *         <code>{@link com.ibm.ecm.extension.PluginResponseFilter PluginResponseFilter}</code>
	 *         objects.
	 */
//	public PluginResponseFilter[] getResponseFilters() {
//		if (pluginResponseFilters.length == 0) {
//			pluginResponseFilters = new PluginResponseFilter[] {new com.ibm.ecm.extension.ColumnsDisplayedResponseFilter()};
//		}
//		return pluginResponseFilters;
//	}
}
