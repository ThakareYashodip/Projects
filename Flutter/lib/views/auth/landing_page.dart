import 'package:another_flutter_splash_screen/another_flutter_splash_screen.dart';
import 'package:flutter/material.dart';

class LandingPage extends StatelessWidget {
  const LandingPage({super.key});

  @override
  Widget build(BuildContext context) {
    return FlutterSplashScreen.scale(
      duration: Duration(milliseconds: 5000),
      childWidget: Image.asset("assets/HireHub_Logo.jpg", fit: BoxFit.cover),
      // z
    );
  }
}
