import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:http/http.dart' as http;

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
        final userName = data["name"];
        Get.snackbar("Welcome", "$userName logged in successfully");
        // Navigate to home or dashboard
        
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
}
