import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:urbanserve/controller/register_controller.dart';

class RegisterScreen extends StatelessWidget {
  RegisterScreen({super.key});
  final RegisterController controller = Get.put(RegisterController());

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
                  "Register",
                  22,
                  Colors.blue.shade700,
                  FontWeight.w700,
                ),
              ],
            ),
            const SizedBox(height: 30),
            _customText("Name*", 14, Colors.black, FontWeight.w600),
            TextField(
              controller: controller.nameController,
              decoration: const InputDecoration(
                hintText: "Enter name",
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 20),
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
              obscureText: true,
              decoration: const InputDecoration(
                hintText: "Enter password",
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 20),
            _customText("Flat Number", 14, Colors.black, FontWeight.w600),
            TextField(
              controller: controller.flatNumberController,
              decoration: const InputDecoration(
                hintText: "Enter flat number",
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 20),
            _customText("Role", 14, Colors.black, FontWeight.w600),
            Obx(
              () => DropdownButtonFormField<String>(
                value: controller.selectedRole.value,
                decoration: const InputDecoration(border: OutlineInputBorder()),
                items: ['RESIDENT', 'ADMIN']
                    .map(
                      (role) =>
                          DropdownMenuItem(value: role, child: Text(role)),
                    )
                    .toList(),
                onChanged: (val) =>
                    controller.selectedRole.value = val ?? 'RESIDENT',
              ),
            ),
            const SizedBox(height: 30),
            Obx(
              () => ElevatedButton(
                onPressed: controller.isLoading.value
                    ? null
                    : controller.register,
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.blue.shade700,
                  padding: const EdgeInsets.symmetric(vertical: 16),
                  textStyle: const TextStyle(fontSize: 16),
                ),
                child: controller.isLoading.value
                    ? const CircularProgressIndicator(color: Colors.white)
                    : const Text(
                        "Register",
                        style: TextStyle(color: Colors.white),
                      ),
              ),
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
