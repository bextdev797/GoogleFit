# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.bextdev.googlefit.GoogleFit {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/bextdev/googlefit/repack'
-flattenpackagehierarchy
-dontpreverify
