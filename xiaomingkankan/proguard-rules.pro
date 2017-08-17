# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\sdk\sdk170516/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#指定代码的压缩级别
-optimizationpasses 5

#不去忽略非公共的库类
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers

# 是否使用大小写混合
-dontusemixedcaseclassnames

#预校验
-dontpreverify

#混淆时是否记录日志
-verbose

#忽略警告，避免打包时某些警告出现
-ignorewarning

# 混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

#保护注解
-keepattributes *Annotation*

#记录生成的日志数据,gradle build时在本项目根目录输出
#apk 包内所有 class 的内部结构
-dump class_files.txt
#未混淆的类和成员
-printseeds seeds.txt
#列出从 apk 中删除的代码
-printusage unused.txt
#混淆前后的映射
-printmapping mapping.txt

#-----------------------------6.默认保留区-----------------------

# 保持哪些类不被混淆
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

#如果有引用v4、v7包可以添加下面这行
-keep public class * extends android.support.*

# 保持 native 方法不被混淆
#-keep classes with member names class * {
#        native;
#}

#--------------------------2.第三方包-------------------------------

-dontwarn butterknife.internal.**
-keep class **$$ViewInjector { *; }
#-keepnamesclass * { @butterknife.InjectView *;}

-keep class org.jsoup.**

-keep class com.chad.library.adapter.** {
*;
}
-keep public class * extends com.chad.library.adapter.base.BaseQuickAdapter
-keep public class * extends com.chad.library.adapter.base.BaseViewHolder
-keepclassmembers public class * extends com.chad.library.adapter.base.BaseViewHolder {
     <init>(android.view.View);
}

-dontwarn okio.**
-dontwarn javax.annotation.Nullable
-dontwarn javax.annotation.ParametersAreNonnullByDefault