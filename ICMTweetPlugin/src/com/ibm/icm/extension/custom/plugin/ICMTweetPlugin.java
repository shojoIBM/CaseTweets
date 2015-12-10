package com.ibm.icm.extension.custom.plugin;
import java.util.Locale;
import com.ibm.ecm.extension.Plugin;
import com.ibm.ecm.extension.PluginAction;

public class ICMTweetPlugin extends Plugin {

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
		return "1.0.0";
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

}
