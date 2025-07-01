import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:urbanserve/controller/login_controller.dart';
import 'package:urbanserve/screens/register_screen.dart';

class LoginScreen extends StatelessWidget {
  LoginScreen({super.key});
  final LoginController controller = Get.put(LoginController());

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: ListView(
          children: [
            const SizedBox(height: 60),
            Row(
              children: [
                GestureDetector(
                  onTap: Get.back,
                  child: Container(
                    height: 50,
                    width: 50,
                    decoration: BoxDecoration(
                      border: Border.all(),
                      borderRadius: BorderRadius.circular(12),
                    ),
                    child: const Icon(Icons.arrow_back),
                  ),
                ),
                const SizedBox(width: 30),
                _customText(
                  "Log In",
                  22,
                  Colors.blue.shade700,
                  FontWeight.w700,
                ),
              ],
            ),
            const SizedBox(height: 30),
            _customText("Email*", 14, Colors.black, FontWeight.w600),
            TextField(
              controller: controller.emailController,
              keyboardType: TextInputType.emailAddress,
              decoration: const InputDecoration(
                hintText: "Enter email",
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 20),
            _customText("Password*", 14, Colors.black, FontWeight.w600),
            TextField(
              controller: controller.passwordController,
              obscureText: controller.visibility.value,
              decoration: InputDecoration(
                hintText: "Enter password",
                border: const OutlineInputBorder(),
                suffixIcon: IconButton(
                  icon: Icon(
                    controller.visibility.value
                        ? Icons.visibility_off
                        : Icons.visibility,
                  ),
                  onPressed: controller.isVisibility,
                ),
              ),
            ),
            const SizedBox(height: 30),
            Obx(
              () => ElevatedButton(
                onPressed: controller.isLoading.value ? null : controller.login,
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.blue.shade700,
                  padding: const EdgeInsets.symmetric(vertical: 16),
                  textStyle: const TextStyle(fontSize: 16),
                ),
                child: controller.isLoading.value
                    ? const CircularProgressIndicator(color: Colors.white)
                    : _customText("Login", 14, Colors.white, FontWeight.w600),
              ),
            ),
            const SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                const Text("Don't have an account? "),
                TextButton(
                  onPressed: () {
                    Get.to(() => RegisterScreen());
                  },
                  child: const Text("Register here"),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }

  Text _customText(String value, double size, Color color, FontWeight weight) {
    return Text(
      value,
      style: TextStyle(fontSize: size, fontWeight: weight, color: color),
    );
  }
}
