package com.example.xpp;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookTest implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        // hook 当前项目
        if (!loadPackageParam.packageName.startsWith("com.example.xpp"))
            return;

        Class<?> clazz = loadPackageParam.classLoader.loadClass("com.example.xpp.MainActivity");

        XposedHelpers.findAndHookMethod(clazz, "message", new XC_MethodHook() {
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            protected void afterHookedMethod(MethodHookParam param) {
                param.setResult("hook 成功！");
            }

        });
    }

}
