import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:http/http.dart' as http;
import 'package:urbanserve/screens/home_screen.dart';

class RegisterController extends GetxController {
  final nameController = TextEditingController();
  final emailController = TextEditingController();
  final passwordController = TextEditingController();
  final flatNumberController = TextEditingController();

  RxString selectedRole = 'RESIDENT'.obs;
  RxBool isLoading = false.obs;

  Future<void> register() async {
    final name = nameController.text.trim();
    final email = emailController.text.trim();
    final password = passwordController.text.trim();
    final flat = flatNumberController.text.trim();
    final role = selectedRole.value;

    if (name.isEmpty || email.isEmpty || password.isEmpty) {
      Get.snackbar(
        "Validation Error",
        "All fields are required",
        snackPosition: SnackPosition.BOTTOM,
      );
      return;
    }

    isLoading.value = true;

    final url = Uri.parse('http://10.0.2.2:8080/auth/register');
    final headers = {"Content-Type": "application/json"};
    final body = jsonEncode({
      "name": name,
      "password": password,
      "email": email,
      "flatNumber": flat,
      "role": role,
    });

    try {
      final response = await http.post(url, headers: headers, body: body);

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);

        Get.snackbar(
          "Welcome",
          "$name registered successfully",
          snackPosition: SnackPosition.BOTTOM,
        );

        Get.to(() => HomeScreen());
        clearController();
      } else {
        final errorMsg =
            jsonDecode(response.body)['message'] ?? "Unknown error";
        Get.snackbar(
          "Registration Failed",
          errorMsg,
          snackPosition: SnackPosition.BOTTOM,
        );
      }
    } catch (e) {
      Get.snackbar(
        "Network Error",
        "Failed to connect to server",
        snackPosition: SnackPosition.BOTTOM,
      );
    } finally {
      isLoading.value = false;
    }
  }

  void clearController() {
    nameController.clear();
    emailController.clear();
    passwordController.clear();
    flatNumberController.clear();
  }

  @override
  void onClose() {
    nameController.dispose();
    emailController.dispose();
    passwordController.dispose();
    flatNumberController.dispose();
    super.onClose();
  }
}
