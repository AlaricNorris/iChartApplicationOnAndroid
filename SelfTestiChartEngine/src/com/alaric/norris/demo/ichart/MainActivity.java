package com.alaric.norris.demo.ichart ;

import java.util.ArrayList ;
import android.annotation.SuppressLint ;
import android.app.Activity ;
import android.app.AlertDialog ;
import android.content.DialogInterface ;
import android.graphics.Bitmap ;
import android.os.Bundle ;
import android.view.View ;
import android.view.Window ;
import android.webkit.JsResult ;
import android.webkit.WebChromeClient ;
import android.webkit.WebSettings.PluginState ;
import android.webkit.WebView ;
import android.webkit.WebViewClient ;

public class MainActivity extends Activity {

	WebView wv ;

	@ SuppressLint ( "SetJavaScriptEnabled" )
	@ Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState) ;
		this.requestWindowFeature(Window.FEATURE_NO_TITLE) ;// 去掉标题栏
		setContentView(R.layout.a1) ;
		wv = (WebView) findViewById(R.id.wv) ;
		wv.getSettings().setJavaScriptEnabled(true) ;
		wv.getSettings().setUseWideViewPort(true) ;
		wv.getSettings().setSupportZoom(true) ;
		wv.getSettings().setPluginsEnabled(true) ;
		wv.getSettings().setPluginState(PluginState.ON) ;
		wv.getSettings().setDefaultTextEncodingName("UTF-8") ;
		wv.setHorizontalScrollbarOverlay(true) ;
		wv.setHorizontalScrollBarEnabled(true) ;
		wv.setVerticalScrollbarOverlay(true) ;
		wv.setVerticalScrollBarEnabled(true) ;
		
		// 设置是否可缩放
		wv.getSettings().setBuiltInZoomControls(true) ;
		wv.getSettings().setLoadWithOverviewMode(true) ;
		wv.requestFocus() ;
		wv.setWebChromeClient(new MyChromClient()) ;
		wv.setWebViewClient(new MyWebClient()) ;
		wv.addJavascriptInterface(new MyInit() , "myinit") ;
		wv.loadUrl("file:///android_asset/html/iChartDemoHtml.html") ;
	}

	class MyWebClient extends WebViewClient {

		@ Override
		public void onPageStarted(WebView view , String url , Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view , url , favicon) ;
		}

		@ Override
		public void onPageFinished(WebView view , String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view , url) ;
		}

		@ Override
		public void onReceivedError(WebView view , int errorCode , String description ,
				String failingUrl) {
			// TODO Auto-generated method stub
			final AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create() ;
			alertDialog.setTitle("提示") ;
			alertDialog.setMessage(description) ;
			alertDialog.setButton("ok" , new DialogInterface.OnClickListener() {

				@ Override
				public void onClick(DialogInterface dialog , int which) {
					alertDialog.dismiss() ;
				}
			}) ;
			super.onReceivedError(view , errorCode , description , failingUrl) ;
		}
	}

	class MyChromClient extends WebChromeClient {

		@ Override
		public boolean onJsAlert(WebView view , String url , String message , JsResult result) {
			// TODO Auto-generated method stub
			return super.onJsAlert(view , url , message , result) ;
		}

		@ Override
		public boolean onJsConfirm(WebView view , String url , String message , JsResult result) {
			// TODO Auto-generated method stub
			return super.onJsConfirm(view , url , message , result) ;
		}
	}

	class MyInit {

		public MyInit() {
			// TODO Auto-generated constructor stub
		}

		public String getTitle() {
			return "上海的平均气温" ;
		}

		public String getVales() {
			ArrayList<String> vaList = new ArrayList<String>() ;
			vaList.add( - 79 + "") ;
			vaList.add(61 + "") ;
			vaList.add(126 + "") ;
			vaList.add(220 + "") ;
			vaList.add(296 + "") ;
			vaList.add(830 + "") ;
			vaList.add(324 + "") ;
			vaList.add(529 + "") ;
			vaList.add(712 + "") ;
			vaList.add(33 + "") ;
			vaList.add(141 + "") ;
			vaList.add( - 36 + "") ;
			return vaList.toString() ;
		}

		public String getLables() {
			ArrayList<String> lables = new ArrayList<String>() ;
			lables.add("\"一月\"") ;
			lables.add("\"一月\"") ;
			lables.add("\"一月\"") ;
			lables.add("\"一月\"") ;
			lables.add("\"一月\"") ;
			lables.add("\"一月\"") ;
			lables.add("\"一月\"") ;
			lables.add("\"一月\"") ;
			lables.add("\"一月\"") ;
			lables.add("\"一月\"") ;
			lables.add("\"一月\"") ;
			lables.add("\"一月\"") ;
			return lables.toString() ;
		}
	}

	public void backBtn(View view) {
		this.finish() ;
	}
//	 public void updateBtn(View view)
//	 {
//	
//	 wv.loadUrl( "javascript:setContentInfo('" + getRemoteData() + "')" );
//	 }
}
