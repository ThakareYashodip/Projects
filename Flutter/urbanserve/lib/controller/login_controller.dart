import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:http/http.dart' as http;
import 'package:urbanserve/screens/home_screen.dart';
import 'package:urbanserve/screens/main_screen.dart';
import 'package:urbanserve/utils/globals.dart';

class LoginController extends GetxController {
  final emailController = TextEditingController();
  final passwordController = TextEditingController();
  final visibility = true.obs;
  RxBool isLoading = false.obs;

  Future<void> login() async {
    final email = emailController.text.trim();
    final password = passwordController.text.trim();

    if (email.isEmpty || password.isEmpty) {
      Get.snackbar("Error", "Email and password are required");
      return;
    }

    isLoading.value = true;

    final url = Uri.parse('http://10.0.2.2:8080/auth/login');
    final headers = {"Content-Type": "application/json"};
    final body = jsonEncode({"email": email, "password": password});

    try {
      final response = await http.post(url, headers: headers, body: body);

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        // You can now access user details like:
        username = data["name"];
        useremail = data["email"];
        userflat = data["flatNo"];
        userrole = data["role"];
        userId = data["id"];

        Get.snackbar(
          "Welcome",
          "$username $useremail $userflat $userrole $userId logged in successfully",
          backgroundColor: Colors.orange.shade200,
        );
        // Navigate to home or dashboard
        Get.to(() => MainScreen());
        clearAll();
      } else {
        Get.snackbar("Login Failed", "Invalid credentials");
      }
    } catch (e) {
      Get.snackbar("Error", "Something went wrong");
    } finally {
      isLoading.value = false;
    }
  }

  void isVisibility() {
    visibility.value = !visibility.value;
  }

  void clearAll() {
    emailController.clear();
    passwordController.clear();
  }
}
