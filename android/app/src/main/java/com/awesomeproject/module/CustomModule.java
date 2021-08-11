package com.awesomeproject.module;

import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.IllegalViewOperationException;

import androidx.annotation.NonNull;

public class CustomModule extends ReactContextBaseJavaModule {

    private ReactApplicationContext reactContext;
    public static final String TAG = "CustomModule";

    public CustomModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return "CustomModule";
    }

    // 接受RN过来的参数
    @ReactMethod
    public void sendRequest(String message) {
        Log.d(TAG,"=====收到来自RN调用的方法，参数:"+message);
        //Android调用RN
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("FromAndroid","Android");
    }

}
