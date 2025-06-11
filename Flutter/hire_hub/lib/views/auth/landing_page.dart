import 'package:another_flutter_splash_screen/another_flutter_splash_screen.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:hire_hub/theme/app_colors.dart';
import 'package:hire_hub/views/auth/login_page.dart';

class LandingPage extends StatelessWidget {
  const LandingPage({super.key});

  @override
  Widget build(BuildContext context) {
    return FlutterSplashScreen.scale(
      duration: Duration(milliseconds: 5000),
      childWidget: Text(
        "HireHub",
        style: TextStyle(fontSize: 18.w, color: AppColors.background),
      ),
      nextScreen: const LoginPage(),
    );
  }
}
