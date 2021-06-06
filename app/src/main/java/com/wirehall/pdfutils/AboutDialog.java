package com.wirehall.pdfutils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class AboutDialog extends Dialog implements View.OnClickListener {

  public AboutDialog(Context context) {
    super(context);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.about_dialog);

    Button closeButton = findViewById(R.id.btn_about_dialog_close);
    closeButton.setOnClickListener(this);

    TextView privacyPolicyTextView = findViewById(R.id.tv_privacy_policy_link);
    privacyPolicyTextView.setPaintFlags(
        privacyPolicyTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    privacyPolicyTextView.setOnClickListener(this);

    String versionName =
        getContext().getResources().getString(R.string.label_version, BuildConfig.VERSION_NAME);
    TextView versionTextView = findViewById(R.id.tv_about_dialog_version);
    versionTextView.setText(versionName);
  }

  @Override
  public void onClick(View v) {
    if (v.getId() == R.id.tv_privacy_policy_link) {
      HelperUtils.openPrivacyPolicyIntent(getContext());
    } else {
      dismiss();
    }
  }
}
