import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:get/get.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  Firebase.initializeApp(
    options: FirebaseOptions(
      apiKey: "AIzaSyAL7G55sym88r9XK1BDH-RJP_JXVYcxdzw",
      appId: "1:974136692847:android:a9c15497a4b78129ee3d9a",
      messagingSenderId: "974136692847",
      projectId: "tap-n-pay-f0e86",
      storageBucket: "tap-n-pay-f0e86.firebasestorage.app",
    ),
  );
  SystemChrome.setPreferredOrientations([DeviceOrientation.portraitUp])
      .then((value) => runApp(MainApp()));
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: "HireHub",
      debugShowCheckedModeBanner: false,
    );
  }
}
