-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
#-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-optimizations !field/removal/writeonly,!field/marking/private,!class/merging/*,!code/allocation/variable
-dontshrink
-dontobfuscate  #不优化内部类
-dontoptimize
-keepattributes *Annotation*
-keepattributes Signature

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * implements java.io.Serializable
-keep public class com.android.vending.licensing.ILicensingService

-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}

-keep public class com.mrocker.library.R$*{
    public static final int *;
}

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclasseswithmembers class *$* {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class *$* {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keep class com.lz.easyhttp.** { *; }
-keep public interface com.lz.easyhttp.request.EasyDownloadListener { *; }
-keep public interface com.lz.easyhttp.request.EasyLoadingListener { *; }
-keep class com.liulishuo.filedownloader.** { *; }
-keep class okhttp3.**{ *; }
-keep class okio.**{ *; }
-keep class com.google.gson.** { *; }

