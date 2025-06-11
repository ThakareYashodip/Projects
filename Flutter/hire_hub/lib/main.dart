import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:get/get.dart';
import 'package:hire_hub/views/auth/landing_page.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  Firebase.initializeApp(
    options: FirebaseOptions(
      apiKey: "AIzaSyCEbjt7yNkLPG94n8q-ZmpdO3JpSUvL2Yc",
      appId: "1:419259127964:android:f828162ba4ce86971f3559",
      messagingSenderId: "419259127964",
      projectId: "flutter-firebase-9fbe2",
      storageBucket: "flutter-firebase-9fbe2.firebasestorage.app",
    ),
  );
  SystemChrome.setPreferredOrientations([
    DeviceOrientation.portraitUp,
  ]).then((value) => runApp(MainApp()));
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return ScreenUtilInit(
      designSize: Size(360, 720),
      child: GetMaterialApp(
        title: "HireHub",
        debugShowCheckedModeBanner: false,
        home: const LandingPage(),
      ),
    );
  }
}
