package com.example.beetel.stockhawk.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.gcm.TaskParams;

/**
 * Created by example on 10/1/15.
 */
public class StockIntentService extends IntentService {
  public static final String EXTRA_TAG="tag";
  public static final String EXTRA_SYMBOL="symbol";
  public static final String ACTION_INIT="init";
  public static final String ACTION_ADD="add";

  public StockIntentService(){
    super(StockIntentService.class.getName());
  }

//  public StockIntentService(String name) {
//    super(name);
//  }

  @Override
  protected void onHandleIntent(Intent intent) {
//    Log.d(StockIntentService.class.getSimpleName(), "Stock Intent Service");
//    StockTaskService stockTaskService = new StockTaskService(this);
    Bundle args = new Bundle();
    if (intent.getStringExtra(EXTRA_TAG).equals(ACTION_ADD)){
      args.putString(EXTRA_SYMBOL, intent.getStringExtra(EXTRA_SYMBOL));
    }
    // We can call OnRunTask from the intent service to force it to run immediately instead of
    // scheduling a task.
      StockTaskService stockTaskService = new StockTaskService(this);
    stockTaskService.onRunTask(new TaskParams(intent.getStringExtra(EXTRA_TAG),args));
  }
}
