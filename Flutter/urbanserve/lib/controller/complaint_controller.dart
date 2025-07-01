import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:http/http.dart' as http;
import 'package:urbanserve/utils/globals.dart';

// Assuming this comes from login or registration
class ComplaintRegisterController extends GetxController {
  final titleController = TextEditingController();
  final descriptionController = TextEditingController();
  RxBool isLoading = false.obs;

  // You can allow status choice if needed; otherwise, hardcode as "OPEN"
  RxString status = "OPEN".obs;

  Future<void> submitComplaint() async {
    final title = titleController.text.trim();
    final description = descriptionController.text.trim();

    if (title.isEmpty || description.isEmpty) {
      Get.snackbar("Validation Error", "All fields are required");
      return;
    }

    isLoading.value = true;

    final url = Uri.parse("http://10.0.2.2:8080/complaints");
    final headers = {"Content-Type": "application/json"};

    final body = jsonEncode({
      "id": userId, // e.g., 1 — make sure it's set after login/register
      "complaint": {
        "title": title,
        "description": description,
        "status": status.value,
      }
    });

    try {
      final response = await http.post(url, headers: headers, body: body);

      if (response.statusCode == 200 || response.statusCode == 201) {
        Get.snackbar("Success", "Complaint registered successfully");
        clearFields();
      } else {
        Get.snackbar("Error", "Server error: ${response.body}");
      }
    } catch (e) {
      Get.snackbar("Error", "Failed to submit complaint: $e");
    } finally {
      isLoading.value = false;
    }
  }

  void clearFields() {
    titleController.clear();
    descriptionController.clear();
    status.value = "OPEN";
  }

  @override
  void onClose() {
    titleController.dispose();
    descriptionController.dispose();
    super.onClose();
  }
}
