package com.example.fragmenttest;

import android.os.Bundle;

/**
 * TubasaPrint Library
 * @author yokada
 */
//Custom interface that enables communication between Fragment and its Activity
public interface FragmentCallbacks
{
	public void onItemSelected(String classString, Bundle data);
	public void onBackPressed();
}
