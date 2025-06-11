import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:get/get.dart';
import 'package:hire_hub/services/login_controller.dart';
import 'package:hire_hub/theme/app_colors.dart';

class LoginPage extends StatelessWidget {
  const LoginPage({super.key});

  @override
  Widget build(BuildContext context) {
    final loginController = Get.put(LoginController());

    return Scaffold(
      backgroundColor: AppColors.primaryDark,
      body: SafeArea(
        child: Padding(
          padding: EdgeInsets.all(16.w),
          child: SingleChildScrollView(
            child: Column(
              children: [
                SizedBox(height: 80.h),
                Text(
                  "Login",
                  style: TextStyle(
                    fontSize: 28.sp,
                    color: AppColors.background,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                SizedBox(height: 40.h),
                Form(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        "Email or Username",
                        style: TextStyle(
                          fontSize: 14.sp,
                          color: AppColors.card,
                        ),
                      ),
                      SizedBox(height: 5.h),
                      TextFormField(
                        style: TextStyle(color: Colors.white),
                        decoration: InputDecoration(
                          border: OutlineInputBorder(),
                          filled: true,
                          fillColor: AppColors.primary,
                        ),
                        onChanged:
                            (value) => loginController.username.value = value,
                      ),
                      SizedBox(height: 15.h),
                      Text(
                        "Password",
                        style: TextStyle(
                          fontSize: 14.sp,
                          color: AppColors.card,
                        ),
                      ),
                      SizedBox(height: 5.h),
                      TextFormField(
                        obscureText: true,
                        style: TextStyle(color: Colors.white),
                        decoration: InputDecoration(
                          border: OutlineInputBorder(),
                          filled: true,
                          fillColor: AppColors.primary,
                        ),
                        onChanged:
                            (value) => loginController.password.value = value,
                      ),
                      SizedBox(height: 20.h),
                      Text(
                        "Select Role",
                        style: TextStyle(
                          fontSize: 14.sp,
                          color: AppColors.card,
                        ),
                      ),
                      Obx(
                        () => Row(
                          mainAxisAlignment: MainAxisAlignment.start,
                          children: [
                            Row(
                              children: [
                                Radio<String>(
                                  value: "User",
                                  groupValue:
                                      loginController.selectedRole.value,
                                  activeColor: AppColors.background,
                                  onChanged: (value) {
                                    loginController.selectedRole.value = value!;
                                  },
                                ),
                                Text(
                                  "User",
                                  style: TextStyle(color: Colors.white),
                                ),
                              ],
                            ),
                            SizedBox(width: 20.w),
                            Row(
                              children: [
                                Radio<String>(
                                  value: "Company",
                                  groupValue:
                                      loginController.selectedRole.value,
                                  activeColor: AppColors.background,
                                  onChanged: (value) {
                                    loginController.selectedRole.value = value!;
                                  },
                                ),
                                Text(
                                  "Company",
                                  style: TextStyle(color: Colors.white),
                                ),
                              ],
                            ),
                          ],
                        ),
                      ),
                      SizedBox(height: 15.h),
                      Obx(
                        () => CheckboxListTile(
                          fillColor: WidgetStatePropertyAll(Colors.white),
                          checkColor: Colors.black,
                          title: Text(
                            "Remember Me",
                            style: TextStyle(color: Colors.white),
                          ),
                          value: loginController.rememberMe.value,
                          activeColor: AppColors.background,
                          onChanged: (value) {
                            loginController.rememberMe.value = value!;
                          },
                        ),
                      ),
                      Align(
                        alignment: Alignment.centerRight,
                        child: TextButton(
                          onPressed:
                              () => Get.snackbar(
                                "Info",
                                "Forgot Password?",
                                colorText: Colors.black,
                                backgroundColor: AppColors.accent,
                              ),
                          child: Text(
                            "Forgot Password?",
                            style: TextStyle(color: Colors.grey[300]),
                          ),
                        ),
                      ),
                      SizedBox(height: 20.h),
                      Obx(
                        () => SizedBox(
                          width: double.infinity,
                          height: 48.h,
                          child: ElevatedButton(
                            onPressed:
                                loginController.isLoading.value
                                    ? null
                                    : () {
                                      //loginController.loginUser();
                                    },
                            style: ElevatedButton.styleFrom(
                              backgroundColor: AppColors.background,
                            ),
                            child:
                                loginController.isLoading.value
                                    ? CircularProgressIndicator(
                                      color: Colors.white,
                                    )
                                    : Text(
                                      "Login",
                                      style: TextStyle(fontSize: 16.sp),
                                    ),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
