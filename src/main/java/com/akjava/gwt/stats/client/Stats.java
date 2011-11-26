/*
 The MIT License

Copyright (c) 2011 aki@akjava.com

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package com.akjava.gwt.stats.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

public class Stats extends JavaScriptObject{
protected Stats(){}


public static final native Stats create() /*-{
return new $wnd.Stats();
	}-*/;

public final native void alignTopLeft()/*-{
this.domElement.style.position = 'absolute';
this.domElement.style.left = '0px';
this.domElement.style.top = '0px';
}-*/;

public  final native void update() /*-{
this.update();
}-*/;

public static final Stats insertStatsToRootPanel(){
	if(!avaiable()){
		GWT.log("did you forget add line or stats.js https://github.com/mrdoob/stats.js/blob/master/build/Stats.js");
		GWT.log("<script type=\"text/javascript\" language=\"javascript\" src=\"stats.js\"></script>");
		throw new RuntimeException("stats.js not found.for detail check log");
	}
	Stats stats=create();
	stats.alignTopLeft();
	RootPanel.get().getElement().appendChild(stats.domElement());
	return stats;
}

public static final native boolean avaiable() /*-{
if($wnd.Stats){
	return true;
}
else{
	return false;
}
}-*/;



public  final native Element domElement() /*-{
return this.domElement;
}-*/;

}
