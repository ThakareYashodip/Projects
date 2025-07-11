import 'dart:convert';
import 'dart:developer';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:http/http.dart' as http;
import 'package:urbanserve/utils/globals.dart';

import '../models/complaint_model.dart';

// Assuming this comes from login or registration
class ComplaintRegisterController extends GetxController {
  final titleController = TextEditingController();
  final descriptionController = TextEditingController();
  RxBool isLoading = false.obs;

  // You can allow status choice if needed; otherwise, hardcode as "OPEN"
  RxString status = "OPEN".obs;
  RxList complaints = [].obs;
  RxInt openCount = 0.obs;
  RxInt resolvedCount = 0.obs;
  RxInt pendingCount = 0.obs;
  var complaintsCount;

  @override
  void onInit() {
    super.onInit();
    fetchComplaints(); // fetch data automatically when controller is initialized
    // fetchComplaintsCount();
  }

  Future<void> submitComplaint() async {
    final title = titleController.text.trim();
    final description = descriptionController.text.trim();

    if (title.isEmpty || description.isEmpty) {
      Get.snackbar("Validation Error", "All fields are required");
      return;
    }

    isLoading.value = true;

    const username = 'resident';
    const password = 'resident123';
    final credentials = base64Encode(utf8.encode('$username:$password'));

    final url = Uri.parse("http://10.0.2.2:8080/complaints");

    // ✅ Proper header format
    final headers = {
      'Authorization': 'Basic $credentials',
      'Content-Type': 'application/json',
    };

    final body = jsonEncode({
      "userId": userId, // Ensure `userId` is defined
      "complaint": {
        "title": title,
        "description": description,
        "status": status.value,
      },
    });

    try {
      final response = await http.post(url, headers: headers, body: body);

      if (response.statusCode == 200 || response.statusCode == 201) {
        Get.snackbar(
          "✅ Success!",
          "📦 Your complaint has been registered successfully!",
          backgroundColor: Colors.green.shade50,
          colorText: Colors.green.shade900,
          snackPosition: SnackPosition.TOP,
          margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
          borderRadius: 12,
          icon: const Icon(Icons.check_circle, color: Colors.green, size: 28),
          shouldIconPulse: true,
          duration: const Duration(seconds: 3),
          boxShadows: [
            BoxShadow(
              color: Colors.green.withOpacity(0.3),
              blurRadius: 8,
              offset: const Offset(2, 3),
            ),
          ],
          padding: const EdgeInsets.all(16),
          isDismissible: true,
        );

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

  Future<void> fetchComplaints() async {
    final Uri url = Uri.parse('http://10.0.2.2:8080/complaints');

    // Choose the correct credentials
    const username = 'resident'; // or 'admin'
    const password = 'resident123'; // or 'admin123'

    final credentials = base64Encode(utf8.encode('$username:$password'));

    try {
      final response = await http.get(
        url,
        headers: {
          'Authorization': 'Basic $credentials',
          'Content-Type': 'application/json',
        },
      );

      if (response.statusCode == 200) {
        final List<dynamic> data = jsonDecode(response.body);

        // ✅ Update the RxList correctly using `.assignAll`
        complaints.assignAll(data.cast<Map<String, dynamic>>());
        updateOpenCount();

        complaintsCount = complaints.length;
        log(complaints.toString());
      } else {
        Get.snackbar(
          "Error",
          "Failed to load complaints: ${response.statusCode}",
        );
      }
    } catch (e) {
      Get.snackbar("Error", "Error fetching complaints: $e");
    }
  }

  // Future<void> fetchComplaintsCount() async {
  //   final url = Uri.parse('http://10.0.2.2:8080/complaints/count');

  //   // Choose the correct credentials
  //   const username = 'resident'; // or 'admin'
  //   const password = 'resident123'; // or 'admin123'

  //   final credentials = base64Encode(utf8.encode('$username:$password'));

  //   try {
  //     final response = await http.get(
  //       url,
  //       headers: {
  //         'Authorization': 'Basic $credentials',
  //         'Content-Type': 'application/json',
  //       },
  //     );
  //     if (response.statusCode == 200) {
  //       complaintsCount = response.body;
  //       Get.snackbar(
  //         "$complaintsCount",
  //         "Successfully fetched total complaint count.",
  //       );
  //     } else {
  //       Get.snackbar(
  //         "Error",
  //         "Failed to load complaints: ${response.statusCode}",
  //       );
  //     }
  //   } catch (e) {}
  // }

  void updateOpenCount() {
    openCount.value = complaints.where((c) => c["status"] == "OPEN").length;

    log(openCount.toString());

    resolvedCount.value = complaints
        .where((c) => c["status"] == "RESOLVED")
        .length;

    log(resolvedCount.toString());

    pendingCount.value = complaints
        .where((c) => c["status"] == "PENDING")
        .length;
    log(pendingCount.toString());
  }
}



/*
| **Title**                      | **Mini Description**                                                   |
| ------------------------------ | ---------------------------------------------------------------------- |
| "Leaking Tap in Kitchen"       | "Water constantly drips from the kitchen faucet, wasting water."       |
| "Streetlight Not Working"      | "The lamp post in front of house #23 hasn't been functional in weeks." |
| "Broken Garbage Bin"           | "The bin near Gate 2 is cracked and trash is spilling out."            |
| "Noise Complaint - Loud Music" | "Flat 402 plays loud music every night past 11 PM."                    |
| "Lift Stuck on 3rd Floor"      | "Elevator in B-Wing is not responding and remains stuck."              |
| "Water Shortage"               | "Low water pressure in the bathrooms since this morning."              |
| "Cracked Footpath"             | "The footpath outside the gate is broken, posing a tripping hazard."   |
| "Unauthorized Parking"         | "Visitor's car parked in resident's reserved spot."                    |
| "Mosquito Breeding in Drain"   | "Open drainage near Block C is attracting mosquitoes."                 |
| "Security Guard Absent"        | "No security guard seen at the main entrance during morning hours."    |

*/