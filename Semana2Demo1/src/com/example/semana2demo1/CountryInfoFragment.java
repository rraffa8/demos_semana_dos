package com.example.semana2demo1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CountryInfoFragment extends Fragment {
	private WebView webView;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String country = ((CountryDetailActivity)getActivity()).getCountry();
		webView.loadUrl("http://es.m.wikipedia.org.wiki/"+ country);
		webView.setWebViewClient(new WebViewClient(){
			public boolean ShouldOverrideUrlLoading(WebView view, String url ){
				view.loadUrl(url);
				return true;
			}
		});
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_country_info, container, false);
		webView = (WebView)view.findViewById(R.id.webView);
		return view;
	}
	

}
