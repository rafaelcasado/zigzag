package com.zigzagdigital.zigzag;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

public class RSSParser {

	private static final String ns = null;
	
	public List parse(InputStream in) throws XmlPullParserException, IOException {
		try{
			XmlPullParser parser = Xml.newPullParser();
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			parser.setInput(in, null);
			parser.nextTag();
			return readFeed(parser);
		} finally {
			in.close();
		}
	}
	
	private List readFeed(XmlPullParser parser) throws XmlPullParserException, IOException{
		
		List entries = new ArrayList();
		
		parser.require(XmlPullParser.START_TAG, ns, "channel");
		while(parser.next() != XmlPullParser.END_TAG){
			if (parser.getEventType() != XmlPullParser.START_TAG){
				continue;
			}
		}
		String name = parser.getName();
		
		if (name.equals("item")){
			entries.add(readItem(parser));
		}
		else{
			skip(parser);
		}
		
		return entries;
	}
	
	public static class Item{
		
		public final String title;
		
		private Item(String title){
			this.title = title;
		}
	}
	
	private Item readItem(XmlPullParser parser) throws XmlPullParserException, IOException{
		
		parser.require(XmlPullParser.START_TAG, ns, "item");
		
		String title = null;
		
		while(parser.next() != XmlPullParser.END_TAG){
			
			if (parser.getEventType() != XmlPullParser.START_TAG){
				continue;
			}
			String name = parser.getName();
			if (name.equals("title")){
				title = readTitle(parser);
			}
			else{
				skip(parser);
			}
		}
		
		return new Item(title);
	}
	
	private String readTitle(XmlPullParser parser) throws XmlPullParserException, IOException{
		
		parser.require(XmlPullParser.START_TAG, ns, "item");
		String title = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "item");
		
		return(title);
	}
	
	private String readText(XmlPullParser parser) throws XmlPullParserException, IOException{
		
		String result ="";
		if (parser.next() == XmlPullParser.TEXT){
			result = parser.getText();
			parser.nextTag();
		}
		
		return result;
	}
	
	private void skip(XmlPullParser parser) throws XmlPullParserException, IOException{
		
		if (parser.getEventType() != XmlPullParser.START_TAG){
			throw new IllegalStateException();
		}
		int depth = 1;
		while (depth !=0){
			switch (parser.next()){
			case XmlPullParser.END_TAG:
				depth--;
				break;
			
			case XmlPullParser.START_TAG:
				depth++;
				break;
			}
		}
	}
}

