package com.lhy.myweather.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class CustomDialog extends Dialog {

	public CustomDialog(Context context, int theme) {
		super(context, theme);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}
