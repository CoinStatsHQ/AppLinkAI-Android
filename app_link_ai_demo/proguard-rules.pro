# Keep AppLink public API
-keep class app.link.AppLink { *; }
-keep class app.link.AppLink

# Keep all internal classes that might be accessed
-keep class app.link.** { *; }

-keep,allowobfuscation class retrofit2.Retrofit { *; }
-keep,allowobfuscation class retrofit2.Retrofit$Builder { *; }
-keep,allowobfuscation class retrofit2.Retrofit$* { *; }
